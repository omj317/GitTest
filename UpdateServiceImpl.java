package com.omj.mall.service.Impl;

import com.omj.mall.entity.Review;
import com.omj.mall.mapper.ReviewMapper;
import com.omj.mall.service.ReviewService;
import com.omj.mall.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

    @Resource
    ReviewMapper reviewMapper;

    /**
     * 根据商品id查询当前商品的评价总数
     * @param productId
     * @return
     */
    @Override
    public Integer getTotalByProductId(Integer productId) {
        return reviewMapper.selectTotalByProductId(productId);
    }

    @Override
    public List<Review> getListByProductId(Integer productId, PageUtil pageUtil) {
        return reviewMapper.selectByProductId(productId,pageUtil);
    }

    @Override
    public Integer getTotalByOrderItemId(Integer productOrderItemId) {
        return reviewMapper.selectTotalByOrderItemId(productOrderItemId);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public boolean add(Review review) {
        return reviewMapper.insertOne(review)>0;
    }
}

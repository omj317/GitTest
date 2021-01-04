package com.omj.mall.service.Impl;

import com.omj.mall.mapper.UserMapper;
import com.omj.mall.service.UserService;
import com.omj.mall.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Lenovo
 */
@Service("userService")
public class UserServiceImpl  implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User get(Integer userId) {
        return userMapper.selectOne(userId);
    }

    @Override
    public Integer getTotal(User user) {
        return userMapper.selectTotal(user);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean add(User user) {
        return userMapper.insertOne(user)>0;
    }


    //用户登陆
    @Override
    public User login(String userName, String userPassword) {
        return userMapper.selectByLogin(userName,userPassword);


    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean update(User user) {
        return userMapper.updateOne(user)>0;
    }
}

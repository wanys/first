package com.geneimpl.service.Impl;

import com.geneimpl.dao.UserMapper;
import com.geneimpl.model.User;
import com.geneimpl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource(name="UserMapper")
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserByNameAndPsw(String name, String psw) {
        return userMapper.getUserByNameAndPsw(name,psw);
    }

    @Override
    public int insertSelective(User u) {
        return userMapper.insertSelective(u);
    }

    @Override
    public int addUser(User u) {
        return userMapper.addUser(u);
    }
}

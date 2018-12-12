package com.geneimpl.service;

import com.geneimpl.model.User;

public interface UserService {
    public User getUserByNameAndPsw(String name,String psw);
    public int insertSelective(User u);
    public int addUser(User u);
}

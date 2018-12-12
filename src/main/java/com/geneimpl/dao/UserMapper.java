package com.geneimpl.dao;

import com.geneimpl.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("UserMapper")
public interface UserMapper {
    int insert(User record);
    int insertSelective(User record);//添加用户
    public User getUserByNameAndPsw(@Param("username") String name, @Param("userpsw") String psw);
    public int addUser(User u);
}
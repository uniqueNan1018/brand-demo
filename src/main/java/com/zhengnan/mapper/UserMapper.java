package com.zhengnan.mapper;

import com.zhengnan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@SuppressWarnings("ALL")
public interface UserMapper {
    List<User> selectAll();

    User select(@Param("username") String username, @Param("password") String password);

    int add(User user);

    User selectByUsername(String username);
}

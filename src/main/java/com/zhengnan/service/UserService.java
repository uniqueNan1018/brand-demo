package com.zhengnan.service;

import com.zhengnan.mapper.BrandMapper;
import com.zhengnan.mapper.UserMapper;
import com.zhengnan.pojo.Brand;
import com.zhengnan.pojo.User;
import com.zhengnan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User selectByUsernameAndPwd(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    public Integer register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer i = mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    public boolean checkDuplicate(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);
        sqlSession.close();
        if (user != null) {
            return false;
        } else {
            return true;
        }
    }
}

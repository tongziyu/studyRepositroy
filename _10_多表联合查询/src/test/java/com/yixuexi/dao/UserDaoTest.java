package com.yixuexi.dao;

import com.yixuexi.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 2020/8/5   3:20
 */
public class UserDaoTest {
    private InputStream in;
    private SqlSessionFactory factory;
    SqlSession session;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
    }
    //测试查询所有用户的方法
    @Test
    public void findAllTest(){
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }


    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }
}

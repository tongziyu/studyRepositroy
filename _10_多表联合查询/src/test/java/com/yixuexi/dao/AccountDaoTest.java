package com.yixuexi.dao;

import com.yixuexi.dao.AccountDao;
import com.yixuexi.entity.Account;
import com.yixuexi.entity.AccountUser;
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
 * 2020/8/5   3:16
 */
public class AccountDaoTest {
    private InputStream in;
    private SqlSessionFactory factory;
    SqlSession session;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
    }


    //测试方法 测试查询全部账户
    @Test
    public void findAllTest(){
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }





    //测试方法  测试查询全部账户信息和用户名用户密码
    @Test
    public void findAllAccountUserTest(){
        AccountDao mapper = session.getMapper(AccountDao.class);
        List<AccountUser> list = mapper.findAllAccountUser();
        for (AccountUser accountUser : list) {
            System.out.println(accountUser);

        }
    }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }
}

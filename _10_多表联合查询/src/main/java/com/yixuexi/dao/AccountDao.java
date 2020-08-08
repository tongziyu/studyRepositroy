package com.yixuexi.dao;

import com.yixuexi.entity.Account;
import com.yixuexi.entity.AccountUser;

import java.util.List;

/**
 * 2020/8/5   3:11
 */
public interface AccountDao {
    /**
     * 查询所有账户的方法
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有的账户信息 和 用户名称 密码
     * @return 返回一个list集合
     */
    List<AccountUser> findAllAccountUser();
}

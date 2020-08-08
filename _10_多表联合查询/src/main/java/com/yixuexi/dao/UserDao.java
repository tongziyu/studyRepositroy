package com.yixuexi.dao;

import com.yixuexi.entity.User;

import java.util.List;

/**
 * 2020/8/5   3:14
 */
public interface UserDao {
    /**
     * 查询所有User的方法
     * @return
     */
    List<User> findAll();

}

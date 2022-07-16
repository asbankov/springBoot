package com.abankov.springboot.dao;

import com.abankov.springboot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getByID(long id);
    void edit(User user);
    void delete(User user);
}

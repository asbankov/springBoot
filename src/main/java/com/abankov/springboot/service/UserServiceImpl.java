package com.abankov.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abankov.springboot.dao.UserDao;
import com.abankov.springboot.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getByID(long id) {
        return userDao.getByID(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}

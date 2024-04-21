package com.loginform.service;

import com.loginform.dao.UserDAO;
import com.loginform.myapp.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    UserDAO userDao;
    @Override
    public int register(User user) throws Exception {
        return userDao.insertUser(user);
    }

    @Override
    public int idCheck(String id) throws Exception {
        return userDao.selectUserId(id);
    }
}

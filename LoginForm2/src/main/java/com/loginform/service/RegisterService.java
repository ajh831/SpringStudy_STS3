package com.loginform.service;

import com.loginform.myapp.User;

public interface RegisterService {

    // 회원가입
    int register(User user) throws Exception;

    int idCheck(String id) throws Exception;
}

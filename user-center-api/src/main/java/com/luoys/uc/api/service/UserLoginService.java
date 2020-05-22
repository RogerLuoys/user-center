package com.luoys.uc.api.service;

import com.luoys.uc.api.bo.UserBO;

public interface UserLoginService {
    String login(String accountId, String passwd);
    String hello();
}

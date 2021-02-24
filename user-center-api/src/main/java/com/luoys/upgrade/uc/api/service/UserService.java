package com.luoys.upgrade.uc.api.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.api.bo.UserBO;

import java.util.List;

public interface UserService {
    Result<UserBO> login(String loginName, String password);

    Result<UserBO> queryByUserId(String userId);

    Result<Integer> register(UserBO userBO);

    Result<Integer> modifyUser(UserBO userBO);

    String sayHello (String var);
}

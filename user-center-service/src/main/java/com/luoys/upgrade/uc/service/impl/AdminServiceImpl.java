package com.luoys.upgrade.uc.service.impl;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.manager.UserManager;
import com.luoys.upgrade.uc.share.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;


public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserManager userManager;

    @Override
    public Result<String> removeUser(String userId) {
        if (userId == null) {
            return Result.error("userId不能为空");
        }
        return Result.ifSuccess(userManager.removeUser(userId));
    }
}

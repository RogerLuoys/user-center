package com.luoys.upgrade.uc.service.impl;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.api.bo.UserBO;
import com.luoys.upgrade.uc.api.service.UserService;
import com.luoys.upgrade.uc.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result<UserBO> login(@RequestParam("loginName") String loginName, @RequestParam("password") String password){
        LOG.info("====》用户登录开始：loginName={}, password={}", loginName, password);
        if (false == userManager.checkUserExist(loginName)) {
            return Result.error(null, "登录名不存在");
        }
        return Result.ifSuccess(userManager.queryByLoginInfo(loginName, password));
    }

    @Override
    @RequestMapping(value = "/queryByUserId", method = RequestMethod.GET)
    public Result<UserBO> queryByUserId(@RequestParam("userId") String userId) {
        LOG.info("====》查询用户信息开始：userId={}", userId);
        return Result.ifSuccess(userManager.queryByUserId(userId));
    }

    @Override
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<Integer> register(@RequestBody UserBO userBO){
        LOG.info("====》注册用户开始：{}", userBO);
        if (true == userManager.checkUserExist(userBO.getLoginName())) {
            return Result.error(null, "登录名已被注册");
        }
        return Result.ifSuccess(userManager.newUser(userBO));
    }

    @Override
    @RequestMapping(value = "/modifyUser", method = RequestMethod.PUT)
    public Result<Integer> modifyUser(@RequestBody UserBO userBO){
        LOG.info("====》修改用户信息开始：{}", userBO);
        return Result.ifSuccess(userManager.modifyUser(userBO));
    }
}


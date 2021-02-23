package com.luoys.upgrade.uc.service.impl;

import com.luoys.upgrade.uc.api.service.UserLoginService;
import com.luoys.upgrade.uc.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class UserLoginServiceImpl implements UserLoginService {

    private static Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello user center";
    }

    @Override
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String accountId, String passwd) {
        logger.info("开始校验账号");
        boolean aux = userManager.checkAccount(accountId, passwd);
        if (true == aux) {
            return "账号存在，登录通过";
        } else {
            return "账号或密码不存在";
        }
//        return null;
    }

}

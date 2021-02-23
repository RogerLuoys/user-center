package com.luoys.upgrade.uc.manager.impl;

import com.luoys.upgrade.uc.dao.mapper.UserMapper;
import com.luoys.upgrade.uc.manager.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserManagerImpl implements UserManager {

    private static Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean checkAccount(String accountId, String passwd) {
        String realPasswd = userMapper.getPasswdByAccount(accountId);
        if (realPasswd == null) {
            logger.info("账号或密码为空");
            return false;
        }
        if (realPasswd.equals(passwd)) {
            return true;
        }
        return false;
    }

}

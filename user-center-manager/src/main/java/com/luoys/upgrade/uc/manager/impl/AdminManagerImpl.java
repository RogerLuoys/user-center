package com.luoys.upgrade.uc.manager.impl;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.uc.dao.mapper.UserMapper;
import com.luoys.upgrade.uc.manager.AdminManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminManagerImpl implements AdminManager {

    private final static Logger LOG = LoggerFactory.getLogger(AdminManagerImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public String removeUser(@NotNull String userId) {
        return userMapper.deleteByUserId(userId) == 1 ? "删除成功" : null;
    }
}

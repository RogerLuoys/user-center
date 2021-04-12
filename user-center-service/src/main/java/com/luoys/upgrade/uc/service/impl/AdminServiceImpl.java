package com.luoys.upgrade.uc.service.impl;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.share.service.AdminService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(interfaceClass = AdminService.class)
public class AdminServiceImpl implements AdminService {

    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminService adminService;

    @Override
    public Result<String> removeUser(String userId) {
        LOG.info("====》删除用户开始：userId={}", userId);
        if (userId == null) {
            return Result.error("userId不能为空");
        }
        return Result.ifSuccess(adminService.removeUser(userId));
    }
}

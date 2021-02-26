package com.luoys.upgrade.uc.service.impl;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.manager.UserManager;
import com.luoys.upgrade.uc.share.dto.UserDTO;
import com.luoys.upgrade.uc.share.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@DubboService(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserManager userManager;

    @Override
    public Result<UserDTO> login(String loginName, String password){
        LOG.info("====》用户登录开始：loginName={}, password={}", loginName, password);
        if (false == userManager.checkUserExist(loginName)) {
            return Result.error(null, "登录名不存在");
        }
        return Result.ifSuccess(userManager.queryByLoginInfo(loginName, password));
    }

    @Override
    public Result<UserDTO> queryByUserId(String userId) {
        LOG.info("====》查询用户信息开始：userId={}", userId);
        return Result.ifSuccess(userManager.queryByUserId(userId));
    }

    @Override
    public Result<Integer> register(UserDTO userDTO){
        LOG.info("====》注册用户开始：{}", userDTO);
        if (true == userManager.checkUserExist(userDTO.getLoginName())) {
            return Result.error(null, "登录名已被注册");
        }
        return Result.ifSuccess(userManager.newUser(userDTO));
    }

    @Override
    public Result<Integer> modifyUser(UserDTO userDTO){
        LOG.info("====》修改用户信息开始：{}", userDTO);
        return Result.ifSuccess(userManager.modifyUser(userDTO));
    }

    @Override
    public String sayHello(String name) {
        LOG.info("====》调用hello：{}", name);
        System.out.println("hello");
        return "调用dubbo成功"+name;
    }
}




package com.luoys.upgrade.uc.manager.impl;

import com.luoys.common.api.NumberSender;
import com.luoys.upgrade.uc.dao.mapper.UserMapper;
import com.luoys.upgrade.uc.manager.UserManager;
import com.luoys.upgrade.uc.manager.transform.TransformUser;
import com.luoys.upgrade.uc.share.dto.UserDTO;
import com.luoys.upgrade.uc.share.enums.UserStatusEnum;
import com.luoys.upgrade.uc.share.enums.UserTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserManagerImpl implements UserManager {

    private final static Logger LOG = LoggerFactory.getLogger(UserManagerImpl.class);
    private final static String DEFAULT_USER_NAME = "新干旗人";
    private final static int DEFAULT_USER_TYPE = UserTypeEnum.REGULAR.getCode();
    private final static int DEFAULT_USER_STATUS = UserStatusEnum.NORMAL.getCode();
    private final static String SUCCESS = "成功";

    @Autowired
    private UserMapper userMapper;

    @Override
    public String modifyUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return userMapper.update(TransformUser.transformBO2PO(userDTO)) == 1 ? SUCCESS : null;
    }

    @Override
    public UserDTO queryByLoginName(String loginName, String passWord) {
        if (loginName == null || passWord == null) {
            return null;
        }
        return TransformUser.transformPO2BO(userMapper.selectByLoginInfo(loginName, null, passWord));
    }

    @Override
    public UserDTO queryByPhone(String phone, String passWord) {
        if (phone == null || passWord == null) {
            return null;
        }
        return TransformUser.transformPO2BO(userMapper.selectByLoginInfo(null, phone, passWord));
    }

    @Override
    public UserDTO queryByUserId(String userId) {
        if (null == userId) {
            return null;
        }
        return TransformUser.transformPO2BO(userMapper.selectByUserId(userId));
    }

    @Override
    public Boolean checkUserExist(String loginName) {
        if (loginName == null) {
            LOG.error("----》入参为空");
            return null;
        }
        return null != userMapper.selectByLoginName(loginName);
    }

    @Override
    public UserDTO newUser(UserDTO userDTO) {
        if (userDTO == null || userDTO.getLoginName() == null || userDTO.getPassword() == null) {
            LOG.error("----》入参为空");
            return null;
        }
        if (userDTO.getUserName() == null) {
            userDTO.setUserName(DEFAULT_USER_NAME);
        }
        if (userDTO.getType() == null) {
            userDTO.setType(DEFAULT_USER_TYPE);
        }
        if (userDTO.getStatus() == null) {
            userDTO.setStatus(DEFAULT_USER_STATUS);
        }
        userDTO.setUserId(NumberSender.createUserId());
        LOG.info("====》新增用户：{}", userDTO);
        int insertUserResult = userMapper.insert(TransformUser.transformBO2PO(userDTO));
        return insertUserResult == 1 ? userDTO : null;
    }

}


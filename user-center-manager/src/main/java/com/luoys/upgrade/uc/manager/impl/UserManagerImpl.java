package com.luoys.upgrade.uc.manager.impl;

import com.luoys.common.api.NumberSender;
import com.luoys.upgrade.uc.dao.mapper.PointMapper;
import com.luoys.upgrade.uc.dao.mapper.UserMapper;
import com.luoys.upgrade.uc.dao.po.PointPO;
import com.luoys.upgrade.uc.manager.UserManager;
import com.luoys.upgrade.uc.manager.transform.TransformUser;
import com.luoys.upgrade.uc.share.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserManagerImpl implements UserManager {

    private final static Logger LOG = LoggerFactory.getLogger(UserManagerImpl.class);
    private final static String DEFAULT_USER_NAME = "新干旗人";
    private final static int DEFAULT_TYPE = 2;
    private final static int DEFAULT_STATUS = 1;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PointMapper pointMapper;

    @Override
    public Integer modifyUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return userMapper.update(TransformUser.transformBO2PO(userDTO));
    }

    @Override
    public UserDTO queryByLoginInfo(String loginName, String passWord) {
        if (loginName == null || passWord == null) {
            return null;
        }
        return TransformUser.transformPO2BO(userMapper.selectByLoginInfo(loginName, passWord));
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
        return null == userMapper.selectByLoginName(loginName) ? false : true;
    }

    @Override
    public Integer newUser(UserDTO userDTO) {
        if (userDTO == null || userDTO.getLoginName() == null || userDTO.getPassword() == null) {
            LOG.error("----》入参为空");
            return null;
        }
        if (userDTO.getUserName() == null) {
            userDTO.setUserName(DEFAULT_USER_NAME);
        }
        if (userDTO.getType() == null) {
            userDTO.setType(DEFAULT_TYPE);
        }
        if (userDTO.getStatus() == null) {
            userDTO.setStatus(DEFAULT_STATUS);
        }
        userDTO.setUserId(NumberSender.createUserId());
        LOG.info("====》新增用户：{}", userDTO);
        int insertUserResult = userMapper.insert(TransformUser.transformBO2PO(userDTO));
        PointPO pointPO = new PointPO();
        pointPO.setUsablePoint(0);
        pointPO.setExpendPoint(0);
        pointPO.setStatus(1);
        pointPO.setOwnerId(userDTO.getUserId());
        pointPO.setPointId(NumberSender.createPointId());
        LOG.info("====》新增积分账号：{}", pointPO);
        int insertPointResult = pointMapper.insert(pointPO);
        return (insertUserResult == 1 && insertPointResult == 1) ? 1 : null;
    }
}


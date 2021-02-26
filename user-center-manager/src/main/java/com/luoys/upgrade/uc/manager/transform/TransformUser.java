package com.luoys.upgrade.uc.manager.transform;

import com.luoys.upgrade.uc.dao.po.UserPO;
import com.luoys.upgrade.uc.share.dto.UserDTO;

public class TransformUser {

    public static UserPO transformBO2PO(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserPO po = new UserPO();
        po.setStatus(dto.getStatus());
        po.setUserId(dto.getUserId());
        po.setLoginName(dto.getLoginName());
        po.setType(dto.getType());
        po.setPhone(dto.getPhone());
        po.setUserName(dto.getUserName());
        po.setPassword(dto.getPassword());
        return po;
    }

    public static UserDTO transformPO2BO(UserPO po) {
        if (po == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setPassword(po.getPassword());
        dto.setUserId(po.getUserId());
        dto.setUserName(po.getUserName());
        dto.setPhone(po.getPhone());
        dto.setStatus(po.getStatus());
        dto.setType(po.getType());
        dto.setLoginName(po.getLoginName());
        return dto;
    }
}

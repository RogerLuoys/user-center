package com.luoys.upgrade.uc.manager;

import com.luoys.upgrade.uc.share.dto.UserDTO;

public interface UserManager {
    String modifyUser(UserDTO userDTO);

    UserDTO queryByLoginName(String loginName, String passWord);

    UserDTO queryByPhone(String phone, String passWord);

    UserDTO queryByUserId(String userId);

    Boolean checkUserExist(String loginName);

    UserDTO newUser(UserDTO userDTO);
}

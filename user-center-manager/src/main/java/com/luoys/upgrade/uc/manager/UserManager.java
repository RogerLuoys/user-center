package com.luoys.upgrade.uc.manager;

import com.luoys.upgrade.uc.share.dto.UserDTO;

public interface UserManager {
    String modifyUser(UserDTO userDTO);

    UserDTO queryByLoginInfo(String loginName, String passWord);

    UserDTO queryByUserId(String userId);

    Boolean checkUserExist(String loginName);

    String newUser(UserDTO userDTO);
}

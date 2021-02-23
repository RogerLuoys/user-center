package com.luoys.upgrade.uc.manager;

import com.luoys.upgrade.uc.api.bo.UserBO;

public interface UserManager {
    Integer modifyUser(UserBO userBO);

    UserBO queryByLoginInfo(String loginName, String passWord);

    UserBO queryByUserId(String userId);

    Boolean checkUserExist(String loginName);

    Integer newUser(UserBO userBO);
}

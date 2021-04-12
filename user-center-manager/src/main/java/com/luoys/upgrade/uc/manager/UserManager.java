package com.luoys.upgrade.uc.manager;

import com.luoys.common.annotation.NotNull;
import com.luoys.upgrade.uc.share.dto.UserDTO;

public interface UserManager {
    String modifyUser(@NotNull UserDTO userDTO);

    UserDTO queryByLoginName(@NotNull String loginName, @NotNull String passWord);

    UserDTO queryByPhone(@NotNull String phone, @NotNull String passWord);

    UserDTO queryByUserId(@NotNull String userId);

    Boolean checkUserExist(@NotNull String loginName);

    UserDTO newUser(@NotNull UserDTO userDTO);

}

package com.luoys.upgrade.uc.share.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.share.dto.UserDTO;

public interface UserService {
    Result<UserDTO> login(String loginName, String phone, String password);

    Result<UserDTO> queryByUserId(String userId);

    Result<UserDTO> register(UserDTO userBO);

    Result<String> modifyUser(UserDTO userBO);

}

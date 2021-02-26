package com.luoys.upgrade.uc.share.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.share.dto.UserDTO;

public interface UserService {
    Result<UserDTO> login(String loginName, String password);

    Result<UserDTO> queryByUserId(String userId);

    Result<Integer> register(UserDTO userBO);

    Result<Integer> modifyUser(UserDTO userBO);

    String sayHello (String var);
}

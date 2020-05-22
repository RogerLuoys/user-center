package com.luoys.uc.manager;

public interface UserManager {

    /**
     * 确认账号是否存在
     * @param accountId
     * 账号
     * @param passwd
     * 密码
     * @return
     */
    boolean checkAccount(String accountId, String passwd);
}

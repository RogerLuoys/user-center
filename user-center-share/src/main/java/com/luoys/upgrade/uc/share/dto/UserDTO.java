package com.luoys.upgrade.uc.share.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String userId;

    /**
     * 登录名
     */
    private String loginName;

    private String password;

    /**
     * 用户号码，登录账号
     */
    private String phone;

    private String userName;

    /**
     * 1--管理员；2--普通账号
     */
    private Integer type;

    /**
     * 1-正常；
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

}

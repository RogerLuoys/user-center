package com.luoys.upgrade.uc.dao.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author
 */
@Data
public class UserPO implements Serializable {
    private Integer id;

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

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
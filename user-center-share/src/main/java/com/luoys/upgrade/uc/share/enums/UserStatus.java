package com.luoys.upgrade.uc.share.enums;

import lombok.Getter;

@Getter
public enum UserStatus {

    NORMAL(1, "正常");

    private final Integer status;
    private final String description;

    UserStatus(Integer status, String description) {
        this.status = status;
        this.description = description;
    }
}

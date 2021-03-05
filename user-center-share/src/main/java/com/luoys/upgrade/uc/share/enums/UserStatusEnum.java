package com.luoys.upgrade.uc.share.enums;

import lombok.Getter;

@Getter
public enum UserStatusEnum {

    NORMAL(1, "正常");

    private final Integer code;
    private final String description;

    UserStatusEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

}

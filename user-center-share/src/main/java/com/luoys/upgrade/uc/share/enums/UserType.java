package com.luoys.upgrade.uc.share.enums;

import lombok.Getter;

@Getter
public enum UserType {

    ADMIN(1, "管理员"),
    REGULAR(2, "普通账号");

    private final Integer type;
    private final String description;

    UserType(Integer type, String description) {
        this.type = type;
        this.description = description;
    }
}

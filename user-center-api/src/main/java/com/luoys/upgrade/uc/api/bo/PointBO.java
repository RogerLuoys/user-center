package com.luoys.upgrade.uc.api.bo;

import lombok.Data;
@Deprecated
@Data
public class PointBO {

    private String pointId;

    private String ownerId;

    /**
     * 总积分
     */
    private Integer usablePoint;

    /**
     * 可用积分
     */
    private Integer expendPoint;

    private Integer totalPoint;

    /**
     * 未使用
     */
    private Integer type;

    /**
     * 1-正常；2-冻结
     */
    private Integer status;
}

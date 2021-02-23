package com.luoys.upgrade.uc.dao.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * point_log
 * @author luoys
 */
@Data
public class PointLogPO implements Serializable {
    private Integer id;

    private String pointId;

    private String taskDailyId;

    private Integer point;

    private String description;

    private String comment;

    /**
     * 1-增加；2-减少
     */
    private Integer type;

    private Integer status;

    private Date recordTime;

    private Date gmtCreate;

    private Date gmtModified;

    private static final long serialVersionUID = 1L;
}
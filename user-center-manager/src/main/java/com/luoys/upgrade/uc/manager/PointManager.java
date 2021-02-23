package com.luoys.upgrade.uc.manager;

import com.luoys.upgrade.uc.api.bo.PointBO;
import com.luoys.upgrade.uc.api.bo.PointLogBO;

import java.util.List;

public interface PointManager {

    PointBO queryPointByOwnerId(String ownerId);

    List<PointLogBO> queryPointLog(String pointId, Integer type);

    String newPointLog(PointLogBO pointLogBO);
}

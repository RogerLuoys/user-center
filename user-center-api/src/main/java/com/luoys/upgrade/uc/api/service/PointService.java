package com.luoys.upgrade.uc.api.service;

import com.luoys.common.api.Result;
import com.luoys.upgrade.uc.api.bo.PointBO;
import com.luoys.upgrade.uc.api.bo.PointLogBO;

import java.util.List;
@Deprecated
public interface PointService {

    Result<PointBO> queryPointSummary(String ownerId);

    Result<List<PointLogBO>> queryPointLogList(String pointId, Integer type);

    Result<String> newPointLog(PointLogBO pointLogBO);
}

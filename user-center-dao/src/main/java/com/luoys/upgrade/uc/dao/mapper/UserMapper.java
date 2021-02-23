package com.luoys.upgrade.uc.dao.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select passwd from `user` where account_id=#{accountId}")
    String getPasswdByAccount(@Param("accountId") String accountId);

    @Select("select status from `user` where account_id=#{accountId} and passwd=#{passwd}")
    String getUserLevel(@Param("accountId") String accountId, @Param("passwd") String passwd);

}

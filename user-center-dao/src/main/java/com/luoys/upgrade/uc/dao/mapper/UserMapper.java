package com.luoys.upgrade.uc.dao.mapper;

import com.luoys.upgrade.uc.dao.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int insert(UserPO userPO);

    int update(UserPO userPO);

    UserPO selectByLoginInfo(@Param("loginName") String loginName, @Param("password") String password);

    UserPO selectByLoginName(String loginName);

    UserPO selectByUserId(String userId);

    UserPO select(UserPO userPO);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserPO record);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}
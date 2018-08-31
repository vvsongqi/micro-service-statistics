package com.pactera.domain.userUs.mapper;

import com.pactera.domain.userUs.model.UserUsModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Mapper
public interface UserUsMapper {
    Logger logger = LoggerFactory.getLogger(UserUsMapper.class);
    @Select("select count,date_format(date,'%Y-%m-%d') date from user_action_result_daily where date>=#{startTime} and date <=#{endTime}")
    List<UserUsModel> getUserUsCount(@Param("startTime")String startTime, @Param("endTime")String endTime);
}

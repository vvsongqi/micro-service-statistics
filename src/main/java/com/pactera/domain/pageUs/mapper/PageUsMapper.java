package com.pactera.domain.pageUs.mapper;

import com.pactera.domain.pageUs.model.PageUsModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Mapper
public interface PageUsMapper {
    Logger logger = LoggerFactory.getLogger(PageUsMapper.class);
    @Select("select count,page_id from user_action_result_daily where date>=#{startTime} and date <=#{endTime}")
    List<PageUsModel> getUserUsCount(@Param("startTime") String startTime, @Param("endTime") String endTime);
}

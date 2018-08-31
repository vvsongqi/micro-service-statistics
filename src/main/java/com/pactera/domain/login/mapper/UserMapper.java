package com.pactera.domain.login.mapper;

import com.pactera.domain.login.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mapper
public interface UserMapper{
     Logger logger = LoggerFactory.getLogger(UserMapper.class);

     @Select("select user_name userName,pass_word passWord from t_user_info where user_name = #{user_name}")
     UserModel getUserInfo(String userName);
}

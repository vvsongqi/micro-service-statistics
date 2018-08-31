package com.pactera.domain.login.action;

import com.alibaba.fastjson.JSONObject;
import com.pactera.domain.login.mapper.UserMapper;
import com.pactera.domain.login.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginAction{
    private Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value="/report/login",method= RequestMethod.POST)
    @ResponseBody
    public JSONObject login(UserModel userModel){
        System.out.println("进入login-----------------");
        String userName = userModel.getUserName();
        UserModel user = userMapper.getUserInfo(userName);

        /*JSONObject-------返回信息*/
        JSONObject jsonObject = new JSONObject();
        if(null==user){
            jsonObject.put("returnMsg","用户不存在");
            jsonObject.put("returnCode","error");
            return jsonObject;
        }

        if(!userModel.getPassWord().equals(user.getPassWord())){
            jsonObject.put("returnMsg","密码错误");
            jsonObject.put("returnCode","error");
            return jsonObject;
        }
        jsonObject.put("returnCode","success");
        return jsonObject;
    }

}

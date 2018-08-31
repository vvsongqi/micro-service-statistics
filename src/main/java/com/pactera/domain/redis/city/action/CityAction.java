package com.pactera.domain.redis.city.action;

import com.alibaba.fastjson.JSONObject;
import com.pactera.domain.redis.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class CityAction {
    @Autowired
    private CityService cityService;

    @RequestMapping(value="city/cityInfo",method= RequestMethod.POST)
    @ResponseBody
    public String getCityInfo(){
        System.out.println("========================0000000000======");
        Map<String,String> map = cityService.getCityInfo();

        List colorList = new ArrayList();//颜色列表
        colorList.add("#a5c2d5");
        colorList.add("#76a871");
        colorList.add("#76a871");
        colorList.add("#76a871");
        colorList.add("#a56f8f");
        colorList.add("#c12c44");
        colorList.add("#a56f8f");
        colorList.add("#9f7961");
        colorList.add("#76a871");
        colorList.add("#6f83a5");
        colorList.add("#76a871");
        colorList.add("#6f83a5");
        List arr = new ArrayList();
        Set<String> keys = map.keySet();   //此行可省略，直接将map.keySet()写在for-each循环的条件中
        for(String key:keys){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",key);
            jsonObject.put("value",map.get(key));
            jsonObject.put("color",colorList.get(new Random().nextInt(12)));
            arr.add(jsonObject);
        }
        return arr.toString();
    }
}

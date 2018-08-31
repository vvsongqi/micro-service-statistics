package com.pactera.domain.redis.city.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@Service
public class CityService {
    private Logger logger = LoggerFactory.getLogger(CityService.class);

    public Map<String,String> getCityInfo(){
        Jedis jedis = new Jedis("localhost");
        jedis.set("cityName","成都,上海,北京,深圳,广东,长沙,哈尔滨,乌鲁木齐");
        jedis.set("cityNum","12,15,10,11,9,7,14,8");

        String cityName = jedis.get("cityName");
        String cityNum = jedis.get("cityNum");
        String[] name = cityName.split(",");
        String[] num = cityNum.split(",");
        Map<String,String> map = new HashMap<String, String>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],num[i]);
        }
        return map;
    }
}

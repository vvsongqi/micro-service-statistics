package com.pactera.domain.pageUs.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pactera.domain.pageUs.mapper.PageUsMapper;
import com.pactera.domain.pageUs.model.PageUsModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class PageUsAction {
    private Logger logger = LoggerFactory.getLogger(PageUsAction.class);

    @Autowired
    private PageUsMapper pageUsMapper;

    @RequestMapping(value="/report/pageUs",method= RequestMethod.POST)
    @ResponseBody
    public String getUserUs(String startTime,String endTime){
        List<PageUsModel> list = pageUsMapper.getUserUsCount(startTime,endTime);
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
        JSONArray jsonArray = new JSONArray();
        List arr = new ArrayList();

        for(PageUsModel pageUsModel:list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",pageUsModel.getPage_id());
            jsonObject.put("value",pageUsModel.getCount());

            jsonObject.put("color",colorList.get(new Random().nextInt(12)));
            arr.add(jsonObject);
        }
        System.out.println(arr.toString());
        return arr.toString();
    }
}

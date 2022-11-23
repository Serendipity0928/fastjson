package com.spl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.geo.Feature;

public class TestCore {

    public static void main(String[] args) {
        String json = "{open:true, intValue: 1}";
        Config config = JSON.parseObject(json, Config.class);
        System.out.println(config.getIntValue());
    }

}

package com.spl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

public class TestCore {

    public static void main(String[] args) {
        String json = "{open:true, intValue: 1}";
//        Config config = JSON.parseObject(json, Config.class, Feature.InitStringFieldAsEmpty);
//        System.out.println(config.getStrKey());

        Object parse = JSON.parse(json);
        System.out.println(parse);

    }

}

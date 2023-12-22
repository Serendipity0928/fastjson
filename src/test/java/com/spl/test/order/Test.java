package com.spl.test.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.spl.test.order.domain.WmsPoiCoverageScopeCache;

public class Test {
    public static void main(String[] args) {
        WmsPoiCoverageScopeCache coverageScopeCache = BastTestDataFactory.buildWmsPoiCoverageScopeCache();

        String oriSerialStr = JSON.toJSONString(coverageScopeCache, SerializerFeature.MapSortField);
        System.out.println(oriSerialStr);

//        WmsPoiCoverageScopeCache wmsPoiCoverageScopeCache = JSON.parseObject(oriSerialStr, WmsPoiCoverageScopeCache.class);
//        String dupSerialStr = JSON.toJSONString(wmsPoiCoverageScopeCache);
//        System.out.println("对比结果：" + oriSerialStr.equals(dupSerialStr));

    }
}

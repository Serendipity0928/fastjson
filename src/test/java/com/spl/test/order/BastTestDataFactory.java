package com.spl.test.order;


import com.google.common.collect.Lists;
import com.spl.test.order.domain.WmsCoverageCache;
import com.spl.test.order.domain.WmsPoiCoverageScopeCache;
import com.spl.test.order.domain.WmsWarehouseCache;

import java.util.HashMap;

public class BastTestDataFactory {

    static WmsPoiCoverageScopeCache buildWmsPoiCoverageScopeCache() {

        WmsPoiCoverageScopeCache coverageScopeCache = new WmsPoiCoverageScopeCache();
        coverageScopeCache.setPoiId(510);
        coverageScopeCache.setCoverageType(1);
        coverageScopeCache.setCoverageMap(new HashMap<Long, WmsCoverageCache>(){{
            put(1000L, buildWmsCoverageCache(1000L));
            put(2000L, buildWmsCoverageCache(2000L));
            put(3000L, buildWmsCoverageCache(3000L));
            put(4000L, buildWmsCoverageCache(4000L));
            put(5000L, buildWmsCoverageCache(5000L));
            put(6000L, buildWmsCoverageCache(6000L));
            put(7000L, buildWmsCoverageCache(7000L));
        }});
        coverageScopeCache.setWarehouseMap(Lists.newArrayList(
                buildWmsWarehouseCache(3000), buildWmsWarehouseCache(1000), buildWmsWarehouseCache(2000), buildWmsWarehouseCache(4000)));


        return coverageScopeCache;



    }

    private static WmsCoverageCache buildWmsCoverageCache(long coverageId) {
        WmsCoverageCache coverageCache = new WmsCoverageCache();
        coverageCache.setCoverageId(coverageId);
        coverageCache.setCityCollection("{这是一个城市集合}");
        coverageCache.setAreaType(1);
        return coverageCache;
    }

    private static WmsWarehouseCache buildWmsWarehouseCache(long warehouseId) {

        WmsWarehouseCache warehouseCache = new WmsWarehouseCache();
        warehouseCache.setWarehouseId(warehouseId);
        warehouseCache.setWarehouseCode(warehouseId +"");

        return warehouseCache;
    }




}

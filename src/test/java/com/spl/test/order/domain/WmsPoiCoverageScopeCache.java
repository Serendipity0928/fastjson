package com.spl.test.order.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class WmsPoiCoverageScopeCache {

    private long poiId;

    // 配送范围类型(1-仓库、2-门店)
    private int coverageType;

    private Map<Long, WmsCoverageCache> coverageMap;

    private List<WmsWarehouseCache> warehouseMap;
}

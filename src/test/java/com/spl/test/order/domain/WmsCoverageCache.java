package com.spl.test.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WmsCoverageCache {

    private long coverageId;

    private long poiId;

    // 覆盖范围类型(1-门店、2-仓库)
    private int coverageType;

    // 仓库ID。如果是门店覆盖范围类型，此值为-1
    private long warehouseId;

    private String cityCollection;

    // 闪购物流聚合运费模版ID
    private long templateId;

    // 区域类型（1:一级 2:二级）
    private int areaType;

}

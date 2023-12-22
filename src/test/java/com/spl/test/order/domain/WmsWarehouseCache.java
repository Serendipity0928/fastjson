package com.spl.test.order.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WmsWarehouseCache {

    private long warehouseId;
    // 仓库编码（外部）
    private String warehouseCode;
    private String warehouseName;
    private Double warehouseLon;
    private Double warehouseLat;

    // 省级行政区域编码
    private String provinceCode;
    // 市级行政区域编码
    private String cityCode;
    // 县级行政区域编码
    private String districtCode;

}

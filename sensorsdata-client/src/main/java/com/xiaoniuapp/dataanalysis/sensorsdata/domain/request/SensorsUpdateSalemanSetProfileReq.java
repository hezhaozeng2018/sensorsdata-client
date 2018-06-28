package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SalemanTypeEnum;

/**
 * 用户变更理财师类别更新profile
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUpdateSalemanSetProfileReq extends SensorsBaseReq {

    private boolean salemanFlag;

    private SalemanTypeEnum salemanType;

    public boolean getSalemanFlag() {
        return salemanFlag;
    }

    public void setSalemanFlag(boolean salemanFlag) {
        this.salemanFlag = salemanFlag;
    }

    public SalemanTypeEnum getSalemanType() {
        return salemanType;
    }

    public void setSalemanType(SalemanTypeEnum salemanType) {
        this.salemanType = salemanType;
    }
}

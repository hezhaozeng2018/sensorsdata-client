package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

import java.util.Date;

/**
 * 用户理财金相关事件(领取/使用）请求基类
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsExpCashReq extends SensorsBaseReq {

    private String expCashId;

    private String productId;

    private Date validDays;

    private long amount;

    public String getExpCashId() {
        return expCashId;
    }

    /**
     * 设置体验金id
     *
     * @param expCashId
     */
    public void setExpCashId(String expCashId) {
        this.expCashId = expCashId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getValidDays() {
        return validDays;
    }

    /**
     * 设置红包的有效期
     *
     * @param validDays
     */
    public void setValidDays(Date validDays) {
        this.validDays = validDays;
    }

    public long getAmount() {
        return amount;
    }

    /**
     * 设置红包的金额，单位为毫
     *
     * @param amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }
}

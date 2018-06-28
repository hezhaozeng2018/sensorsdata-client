package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

import java.util.Date;

/**
 * 用户红包相关事件(领取/使用）请求基类
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsRedpaperReq extends SensorsBaseReq {

    private String redpaperId;

    private int investPeriod;

    private long principal;

    private Date validDays;

    private long amount;

    public int getInvestPeriod() {
        return investPeriod;
    }

    public String getRedpaperId() {
        return redpaperId;
    }

    /**
     * 设置红包id
     *
     * @param redpaperId
     */
    public void setRedpaperId(String redpaperId) {
        this.redpaperId = redpaperId;
    }

    /**
     * 设置可以使用红包的产品期限条件：如90天产品、180天产品等
     *
     * @param investPeriod
     */
    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public long getPrincipal() {
        return principal;
    }

    /**
     * 设置能够使用红包的投资金额限制，如投资额大于20000
     *
     * @param principal
     */
    public void setPrincipal(long principal) {
        this.principal = principal;
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

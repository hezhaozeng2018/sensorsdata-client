package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

import java.util.Date;

/**
 * 用户加息券相关事件(领取/使用）基类
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsRateCouponReq extends SensorsBaseReq {

    private String rateCouponId;

    private int investPeriod;

    private long principal;

    private Date validDays;

    private int rateDays;

    private String finalRate;


    public String getRateCouponId() {
        return rateCouponId;
    }

    /**
     * 设置加息券id
     *
     * @param rateCouponId
     */
    public void setRateCouponId(String rateCouponId) {
        this.rateCouponId = rateCouponId;
    }

    public String getFinalRate() {
        return finalRate;
    }

    /**
     * 设置加息利率
     *
     * @param finalRate
     */
    public void setFinalRate(String finalRate) {
        this.finalRate = finalRate;
    }

    public int getInvestPeriod() {
        return investPeriod;
    }

    /**
     * 设置可以使用加息券的产品期限条件：如90天产品、180天产品等
     *
     * @param investPeriod
     */
    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public Date getValidDays() {
        return validDays;
    }

    /**
     * 设置加息券的有效期
     *
     * @param validDays
     */
    public void setValidDays(Date validDays) {
        this.validDays = validDays;
    }

    public long getPrincipal() {
        return principal;
    }

    /**
     * 设置能够使用加息券的投资金额限制，如投资额大于20000
     *
     * @param principal
     */
    public void setPrincipal(long principal) {
        this.principal = principal;
    }


    public int getRateDays() {
        return rateDays;
    }

    /**
     * 设置加息券的加息周期
     *
     * @param rateDays
     */
    public void setRateDays(int rateDays) {
        this.rateDays = rateDays;
    }
}

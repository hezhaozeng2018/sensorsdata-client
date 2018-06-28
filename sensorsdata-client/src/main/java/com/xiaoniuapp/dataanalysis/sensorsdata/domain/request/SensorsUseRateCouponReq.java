package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户使用加息券
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUseRateCouponReq extends SensorsRateCouponReq {

    private long profit;

    private String investId;

    public String getInvestId() {
        return investId;
    }

    public void setInvestId(String investId) {
        this.investId = investId;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }
}

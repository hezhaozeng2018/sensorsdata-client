package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户使用理财金
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUseExpCashReq extends SensorsExpCashReq {

    private long profit;

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }
}

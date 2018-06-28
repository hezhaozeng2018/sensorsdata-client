package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户提现完成
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsWithdrawSuccessReq extends SensorsBaseReq {

    private String requestId;

    private long amount;

    public long getAmount() {
        return amount;
    }

    /**
     * 设置提现金额，单位为毫
     *
     * @param amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}

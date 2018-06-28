package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户申请提现
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsWithdrawRequestReq extends SensorsBaseReq {

    private String requestId;

    private String partner;

    private long amount;

    private boolean result;

    private String msg;

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

    /**
     * 设置提现请求ID
     *
     * @param requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
}

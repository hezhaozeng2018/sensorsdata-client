package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户充值完成
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsRechargeFinishReq extends SensorsBaseReq {

    private long amount;

    private String provider;

    private boolean firstRechargeFlag;

    private boolean result;

    private String msg;


    public long getAmount() {
        return amount;
    }

    /**
     * 设置充值金额，单位为毫
     * @param amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    /**
     * 设置充值方式：快钱、连连、微信
     *
     * @param provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isFirstRechargeFlag() {
        return firstRechargeFlag;
    }

    /**
     * 设置是否首次充值
     *
     * @param firstRechargeFlag
     */
    public void setFirstRechargeFlag(boolean firstRechargeFlag) {
        this.firstRechargeFlag = firstRechargeFlag;
    }

    public boolean isResult() {
        return result;
    }

    /**
     * 用户充值是否成功
     *
     * @param result
     */
    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 用户充值结果描述：成功则值为“成功”；失败则值为失败原因
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

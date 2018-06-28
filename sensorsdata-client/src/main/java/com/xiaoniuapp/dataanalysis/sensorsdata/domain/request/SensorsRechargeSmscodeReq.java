package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 充值发送短信
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsRechargeSmscodeReq extends SensorsBaseReq {

    private boolean result;

    private String msg;

    public boolean isResult() {
        return result;
    }

    /**
     * 充值发送验证码是否成功
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
     * 充值发送验证码结果描述：成功则值为“成功”；失败则值为失败原因
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}

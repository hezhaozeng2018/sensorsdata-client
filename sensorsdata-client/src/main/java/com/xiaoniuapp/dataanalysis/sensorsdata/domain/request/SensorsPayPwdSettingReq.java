package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 首次设置支付密码
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsPayPwdSettingReq extends SensorsBaseReq {


    private boolean result;

    private String msg;

    public boolean isResult() {
        return result;
    }

    /**
     * 首次设置支付密码是否成功
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
     * 首次设置支付密码结果描述：成功则值为“成功”；失败则值为失败原因
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

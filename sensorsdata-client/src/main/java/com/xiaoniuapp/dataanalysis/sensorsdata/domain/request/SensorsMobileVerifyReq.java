package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户注册时验证短信验证码
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsMobileVerifyReq extends SensorsBaseReq {

    private String regChannel;

    private boolean result;

    private String msg;

    public boolean isResult() {
        return result;
    }

    /**
     * 用户注册发送验证码是否成功
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
     * 用户注册发送验证码结果描述：成功则值为“成功”；失败则值为失败原因
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRegChannel() {
        return regChannel;
    }

    /**
     * 设置注册来源渠道，如百度、迅雷等
     *
     * @param regChannel
     */
    public void setRegChannel(String regChannel) {
        this.regChannel = regChannel;
    }
}

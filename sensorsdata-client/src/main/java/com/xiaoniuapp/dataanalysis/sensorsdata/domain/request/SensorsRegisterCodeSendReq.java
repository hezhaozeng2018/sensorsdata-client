package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户注册时发送验证码
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsRegisterCodeSendReq extends SensorsBaseReq {

    private String regChannel;

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

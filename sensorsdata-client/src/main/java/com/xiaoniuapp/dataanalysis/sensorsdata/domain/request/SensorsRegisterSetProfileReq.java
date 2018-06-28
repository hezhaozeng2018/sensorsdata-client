package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户注册更新profile
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsRegisterSetProfileReq extends SensorsBaseReq {

    private String mobile;

    private String regChannel;

    private String referrerMobile;

    private String referrerUid;

    private String keyword;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public String getReferrerMobile() {
        return referrerMobile;
    }

    public void setReferrerMobile(String referrerMobile) {
        this.referrerMobile = referrerMobile;
    }

    public String getReferrerUid() {
        return referrerUid;
    }

    public void setReferrerUid(String referrerUid) {
        this.referrerUid = referrerUid;
    }
}

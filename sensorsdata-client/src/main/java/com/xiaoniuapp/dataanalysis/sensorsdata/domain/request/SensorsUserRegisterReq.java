package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户注册
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUserRegisterReq extends SensorsBaseReq {

    private String regChannel;

    private String mobile;

    private String keyword;

    private boolean result;

    private String msg;

    private String newDistinctId;

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

    public boolean isResult() {
        return result;
    }

    /**
     * 用户注册是否成功
     *
     * @param result
     */
    public void setResult(boolean result) {
        this.result = result;
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

    public String getMsg() {
        return msg;
    }

    /**
     * 发注册结果描述：成功则值为“成功”；失败则值为失败原因
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getNewDistinctId() {
        return newDistinctId;
    }

    /**
     * 设置用户的新id，通常是注册后的userid
     *
     * @param newDistinctId
     */
    public void setNewDistinctId(String newDistinctId) {
        this.newDistinctId = newDistinctId;
    }
}

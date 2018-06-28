package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 绑卡相关请求基类
 *
 * @author tangdengke
 * @date 2017/9/7
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsBindAuthReq extends SensorsBaseReq {
    private String bankCode;

    private boolean result;

    private String msg;


    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public boolean isResult() {
        return result;
    }

    /**
     * 操作是否成功
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
     * 操作结果描述：成功则值为“成功”；失败则值为失败原因
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户投资完成
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsInvestPayFinishReq extends SensorsInvestReq {

    private boolean fixedFlag;

    private String finalRate;

    private boolean result;

    private String msg;


    public boolean isFixedFlag() {
        return fixedFlag;
    }

    /**
     * 设置是否固定期限
     *
     * @param fixedFlag
     */
    public void setFixedFlag(boolean fixedFlag) {
        this.fixedFlag = fixedFlag;
    }

    public String getFinalRate() {
        return finalRate;
    }

    /**
     * 设置预期年化收益率
     *
     * @param finalRate
     */
    public void setFinalRate(String finalRate) {
        this.finalRate = finalRate;
    }

    public boolean isResult() {
        return result;
    }

    /**
     * 投资支付是否成功
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
     * 投资支付结果描述：成功则值为“成功”；失败则值为失败原因
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}

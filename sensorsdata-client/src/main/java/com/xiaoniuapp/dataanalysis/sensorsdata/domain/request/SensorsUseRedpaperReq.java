package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户使用红包
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUseRedpaperReq extends SensorsRedpaperReq {

    private String investId;

    public String getInvestId() {
        return investId;
    }

    /**
     * 设置投资记录id
     *
     * @param investId
     */
    public void setInvestId(String investId) {
        this.investId = investId;
    }

}

package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户绑卡更新profile
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsBindCardSetProfileReq extends SensorsBaseReq {

    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}

package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户更新推荐人更新profile
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUpdateReferrerSetProfileReq extends SensorsBaseReq {

    private String referrerMobile;

    public String getReferrerMobile() {
        return referrerMobile;
    }

    public void setReferrerMobile(String referrerMobile) {
        this.referrerMobile = referrerMobile;
    }
}

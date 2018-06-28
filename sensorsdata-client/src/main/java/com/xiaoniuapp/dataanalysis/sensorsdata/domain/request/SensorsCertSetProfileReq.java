package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户实名认证更新profile
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsCertSetProfileReq extends SensorsBaseReq {

    private String name;

    private String certNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }
}

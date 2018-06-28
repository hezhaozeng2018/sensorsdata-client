package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户升降级更新profile
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUpdateLevelSetProfileReq extends SensorsBaseReq {

    private String memberLevel;

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }
}

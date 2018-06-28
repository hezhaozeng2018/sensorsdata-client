package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户领取积分
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsGetPointReq extends SensorsBaseReq {

    private String businessType;

    private String remark;

    private int pointNum;

    private int totalPointNum;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPointNum() {
        return pointNum;
    }

    public void setPointNum(int pointNum) {
        this.pointNum = pointNum;
    }

    public int getTotalPointNum() {
        return totalPointNum;
    }

    public void setTotalPointNum(int totalPointNum) {
        this.totalPointNum = totalPointNum;
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户登录
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsUserLoginReq extends SensorsBaseReq {


    private boolean firstLoginFlag;


    public boolean isFirstLoginFlag() {
        return firstLoginFlag;
    }

    /**
     * 设置用户是否首次登录
     *
     * @param firstLoginFlag
     */
    public void setFirstLoginFlag(boolean firstLoginFlag) {
        this.firstLoginFlag = firstLoginFlag;
    }
}

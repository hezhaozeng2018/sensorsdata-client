package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain;

/**
 * 提现请求预处理补充的数据
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsWithdrawPrehandleVo {


    private double balance;

    private double dueInPrincipal;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDueInPrincipal() {
        return dueInPrincipal;
    }

    public void setDueInPrincipal(double dueInPrincipal) {
        this.dueInPrincipal = dueInPrincipal;
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain;

/**
 * 回款预处理补充的数据：用户数据
 *
 * @author hezhaozeng
 * @date 2017/7/18
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsSetProfitRefundPrehandleVo {

    private double dueInPrincipal;

    private int dueInNum;

    private double totalProfit;

    public double getDueInPrincipal() {
        return dueInPrincipal;
    }

    public void setDueInPrincipal(double dueInPrincipal) {
        this.dueInPrincipal = dueInPrincipal;
    }

    public int getDueInNum() {
        return dueInNum;
    }

    public void setDueInNum(int dueInNum) {
        this.dueInNum = dueInNum;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }
}

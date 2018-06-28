package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain;

/**
 * 投资完成预处理补充的数据：用户数据
 *
 * @author hezhaozeng
 * @date 2017/7/18
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsSetProfitInvestPrehandleVo {

    private double totalInvestAmount;

    private double dueInPrincipal;

    private int totalInvestNum;

    private int dueInNum;

    private double totalAnnualInvestment;

    public double getTotalInvestAmount() {
        return totalInvestAmount;
    }

    public void setTotalInvestAmount(double totalInvestAmount) {
        this.totalInvestAmount = totalInvestAmount;
    }

    public double getDueInPrincipal() {
        return dueInPrincipal;
    }

    public void setDueInPrincipal(double dueInPrincipal) {
        this.dueInPrincipal = dueInPrincipal;
    }

    public int getTotalInvestNum() {
        return totalInvestNum;
    }

    public void setTotalInvestNum(int totalInvestNum) {
        this.totalInvestNum = totalInvestNum;
    }

    public int getDueInNum() {
        return dueInNum;
    }

    public void setDueInNum(int dueInNum) {
        this.dueInNum = dueInNum;
    }

    public double getTotalAnnualInvestment() {
        return totalAnnualInvestment;
    }

    public void setTotalAnnualInvestment(double totalAnnualInvestment) {
        this.totalAnnualInvestment = totalAnnualInvestment;
    }
}

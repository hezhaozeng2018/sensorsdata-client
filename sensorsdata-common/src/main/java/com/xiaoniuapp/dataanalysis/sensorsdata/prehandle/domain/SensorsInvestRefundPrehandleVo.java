package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain;

/**
 * 投资回款预处理补充的数据
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsInvestRefundPrehandleVo {

    private boolean fixFlag;

    private int currentRefundIssue;

    private String finalRate;

    private double annualInvestment;

    private int investPeriod;

    public boolean isFixFlag() {
        return fixFlag;
    }

    public void setFixFlag(boolean fixFlag) {
        this.fixFlag = fixFlag;
    }

    public double getAnnualInvestment() {
        return annualInvestment;
    }

    public void setAnnualInvestment(double annualInvestment) {
        this.annualInvestment = annualInvestment;
    }

    public int getCurrentRefundIssue() {
        return currentRefundIssue;
    }

    public void setCurrentRefundIssue(int currentRefundIssue) {
        this.currentRefundIssue = currentRefundIssue;
    }

    public String getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(String finalRate) {
        this.finalRate = finalRate;
    }

    public int getInvestPeriod() {
        return investPeriod;
    }

    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }
}

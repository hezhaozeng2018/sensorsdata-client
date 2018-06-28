package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain;

/**
 * 投资完成预处理补充的数据
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsInvestFinishPrehandleVo {

    private String productName;

    private int investPeriod;

    private boolean fixFlag;

    private int refundIssue;

    private double annualInvestment;

    private double redpaperProfit;

    private double rateCouponProfit;

    private double collectProfit;

    private double memberRateProfit;

    private double activityRateProfit;

    private double giftAmount;

    private double totalProfit;

    private String annualRate;

    private boolean firstInvestFlag;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getInvestPeriod() {
        return investPeriod;
    }

    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public boolean isFixFlag() {
        return fixFlag;
    }

    public void setFixFlag(boolean fixFlag) {
        this.fixFlag = fixFlag;
    }

    public int getRefundIssue() {
        return refundIssue;
    }

    public void setRefundIssue(int refundIssue) {
        this.refundIssue = refundIssue;
    }

    public double getAnnualInvestment() {
        return annualInvestment;
    }

    public void setAnnualInvestment(double annualInvestment) {
        this.annualInvestment = annualInvestment;
    }

    public double getRedpaperProfit() {
        return redpaperProfit;
    }

    public void setRedpaperProfit(double redpaperProfit) {
        this.redpaperProfit = redpaperProfit;
    }

    public double getRateCouponProfit() {
        return rateCouponProfit;
    }

    public void setRateCouponProfit(double rateCouponProfit) {
        this.rateCouponProfit = rateCouponProfit;
    }

    public double getCollectProfit() {
        return collectProfit;
    }

    public void setCollectProfit(double collectProfit) {
        this.collectProfit = collectProfit;
    }

    public double getMemberRateProfit() {
        return memberRateProfit;
    }

    public void setMemberRateProfit(double memberRateProfit) {
        this.memberRateProfit = memberRateProfit;
    }

    public double getActivityRateProfit() {
        return activityRateProfit;
    }

    public void setActivityRateProfit(double activityRateProfit) {
        this.activityRateProfit = activityRateProfit;
    }

    public double getGiftAmount() {
        return giftAmount;
    }

    public void setGiftAmount(double giftAmount) {
        this.giftAmount = giftAmount;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(String annualRate) {
        this.annualRate = annualRate;
    }

    public boolean isFirstInvestFlag() {
        return firstInvestFlag;
    }

    public void setFirstInvestFlag(boolean firstInvestFlag) {
        this.firstInvestFlag = firstInvestFlag;
    }
}

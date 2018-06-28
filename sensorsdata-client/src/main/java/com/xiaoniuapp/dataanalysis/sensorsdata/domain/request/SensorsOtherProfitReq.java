package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户其他收益
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsOtherProfitReq extends SensorsBaseReq {

    private String activityCode;

    private String activityName;

    private String productName;

    private int investPeriod;

    private String investId;

    private long amount;

    private String finalRate;

    private long oddProfit;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getInvestPeriod() {
        return investPeriod;
    }

    /**
     * 设置投资期限，如：7天、30天、90天等
     *
     * @param investPeriod
     */
    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public String getFinalRate() {
        return finalRate;
    }

    /**
     * 设置预期年化收益率
     *
     * @param finalRate
     */
    public void setFinalRate(String finalRate) {
        this.finalRate = finalRate;
    }

    public long getAmount() {
        return amount;
    }

    /**
     * 设置投资金额，单位为毫
     *
     * @param amount
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }


    public long getOddProfit() {
        return oddProfit;
    }

    /**
     * 设置预期收益，单位为毫
     *
     * @param oddProfit
     */
    public void setOddProfit(long oddProfit) {
        this.oddProfit = oddProfit;
    }

    public String getActivityCode() {
        return activityCode;
    }

    /**
     * 设置活动ID
     *
     * @param activityCode
     */
    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityName() {
        return activityName;
    }

    /**
     * 设置活动名称
     *
     * @param activityName
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getInvestId() {
        return investId;
    }

    /**
     * 设置投资记录id
     *
     * @param investId
     */
    public void setInvestId(String investId) {
        this.investId = investId;
    }
}

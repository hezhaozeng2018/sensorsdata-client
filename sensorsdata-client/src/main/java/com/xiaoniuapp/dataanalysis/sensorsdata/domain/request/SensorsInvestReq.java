package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

/**
 * 用户投资相关事件（投资完成/回款）基类
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsInvestReq extends SensorsBaseReq {

    private String investId;

    private String productId;

    private String productName;

    private int investPeriod;

    private int refundIssue;

    private long principal;

    private long oddProfit;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getInvestPeriod() {
        return investPeriod;
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

    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public int getRefundIssue() {
        return refundIssue;
    }

    public void setRefundIssue(int refundIssue) {
        this.refundIssue = refundIssue;
    }

    public long getPrincipal() {
        return principal;
    }

    public void setPrincipal(long principal) {
        this.principal = principal;
    }

    public long getOddProfit() {
        return oddProfit;
    }

    public void setOddProfit(long oddProfit) {
        this.oddProfit = oddProfit;
    }
}

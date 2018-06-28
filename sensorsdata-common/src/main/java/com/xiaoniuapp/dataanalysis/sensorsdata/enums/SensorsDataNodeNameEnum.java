package com.xiaoniuapp.dataanalysis.sensorsdata.enums;

/**
 * 神策JSON格式数据的节点名称枚举
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public enum SensorsDataNodeNameEnum {

    NODE_NAME_PROPERTIES("properties", "上传属性的父节点"),
    NODE_NAME_DISTINCT_ID("distinct_id", "用户唯一标识节点"),
    NODE_NAME_PROJECT("project", "项目名称"),
    NODE_NAME_EVENT("event", "事件类型节点"),
    NODE_NAME_PROPERTIES_SOURCE("source", "平台类型"),
    NODE_NAME_PROPERTIES_REG_CHANNEL("regChannel", "注册来源渠道"),
    NODE_NAME_PROPERTIES_KEYWORD("keyword", "注册来源关键词"),
    NODE_NAME_PROPERTIES_RESULT("result", "操作结果"),
    NODE_NAME_PROPERTIES_MSG("msg", "操作结果提示"),
    NODE_NAME_PROPERTIES_MOBILE("mobile", "手机号"),
    NODE_NAME_PROPERTIES_BANKCODE("bankCode", "银行编码"),
    NODE_NAME_PROPERTIES_AMOUNT("amount", "金额"),
    NODE_NAME_PROPERTIES_PROVIDER("provider", "支付方式"),
    NODE_NAME_PROPERTIES_INVEST_ID("investId", "投资记录ID"),
    NODE_NAME_PROPERTIES_PRODUCT_ID("productId", "产品ID"),
    NODE_NAME_PROPERTIES_PRODUCT_NAME("productName", "产品名称"),
    NODE_NAME_PROPERTIES_INVEST_PERIOD("investPeriodNew", "投资期限"),
    NODE_NAME_PROPERTIES_FIXED_FLAG("fixedFlag", "是否定期"),
    NODE_NAME_PROPERTIES_REFUND_ISSUE("refundIssue", "回款期数"),
    NODE_NAME_PROPERTIES_FINAL_RATE("finalRate", "预期年化收益率"),
    NODE_NAME_PROPERTIES_PRINCIPAL("principalNew", "投资本金"),
    NODE_NAME_PROPERTIES_ANNUAL_INVESTMENT("annualInvestment", "年化金额"),
    NODE_NAME_PROPERTIES_ODD_PROFIT("oddProfit", "预期收益"),
    NODE_NAME_PROPERTIES_REDPAPER_PROFIT("redpaperProfit", "红包收益"),
    NODE_NAME_PROPERTIES_RATECOUPON_PROFIT("rateCouponProfit", "加息券收益"),
    NODE_NAME_PROPERTIES_COLLECT_PROFIT("collectProfit", "募集期收益"),
    NODE_NAME_PROPERTIES_MEMBERRATE_PROFIT("memberRateProfit", "会员加息收益"),
    NODE_NAME_PROPERTIES_ACTIVITYRATE_PROFIT("activityRateProfit", "活动加息收益"),
    NODE_NAME_PROPERTIES_GIFT_AMOUNT("giftAmount", "优惠收益"),
    NODE_NAME_PROPERTIES_TOTAL_PROFIT("totalProfit", "实际收益"),
    NODE_NAME_PROPERTIES_ANNUAL_RATE("annualRate", "实际收益率"),
    NODE_NAME_PROPERTIES_FIRST_INVEST_FLAG("firstInvestFlag", "是否首次投资"),
    NODE_NAME_PROPERTIES_CURRENT_REFUND_ISSUE("currentRefundIssue", "当前回款期数"),
    NODE_NAME_PROPERTIES_WITHDRAW_REQUEST_ID("withdrawRequestId", "提现申请ID"),
    NODE_NAME_PROPERTIES_PARTNER("partner", "账户类别"),
    NODE_NAME_PROPERTIES_BALANCE("balance", "余额"),
    NODE_NAME_PROPERTIES_DUE_IN_PRINCIPAL("dueInPrincipal", "在投金额"),
    NODE_NAME_PROPERTIES_REDPAPER_ID("redpaperId", "红包ID"),
    NODE_NAME_PROPERTIES_ACTIVITY_NAME("activityName", "活动名称"),
    NODE_NAME_PROPERTIES_VALID_DAYS("validDays", "有效期"),
    NODE_NAME_PROPERTIES_RATECOUPON_ID("rateCouponId", "加息券ID"),
    NODE_NAME_PROPERTIES_RATE_DAYS("rateDays", "加息天数"),
    NODE_NAME_PROPERTIES_PROFIT("profit", "收益"),
    NODE_NAME_PROPERTIES_EXPCASH_ID("expCashId", "理财金ID"),
    NODE_NAME_PROPERTIES_BUSINESS_TYPE("businessType", "业务类别"),
    NODE_NAME_PROPERTIES_REMARK("remark", "备注"),
    NODE_NAME_PROPERTIES_POINT_NUM("pointNum", "积分数量"),
    NODE_NAME_PROPERTIES_TOTAL_POINT_NUM("totalPointNum", "总积分数量"),
    NODE_NAME_PROPERTIES_GOODS_ID("goodsId", "商品ID"),
    NODE_NAME_PROPERTIES_GOODS_NUM("goodsNum", "商品数量"),
    NODE_NAME_PROPERTIES_COUPON_ID("couponId", "优惠券ID");


    private String code;

    private String description;

    SensorsDataNodeNameEnum() {

    }

    SensorsDataNodeNameEnum(String code, String desc) {
        this.code = code;
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 返回枚举的代码
     *
     * @return
     */
    public String getCode() {
        return code;
    }
}

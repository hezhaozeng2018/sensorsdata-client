package com.xiaoniuapp.dataanalysis.sensorsdata.enums;

/**
 * 神策JSON格式数据的节点名称枚举
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public enum SensorsDataUserFieldEnum {

    NODE_NAME_PROPERTIES("properties", "上传属性的父节点"),
    NODE_NAME_DISTINCT_ID("distinct_id", "用户唯一标识节点"),
    NODE_NAME_PROJECT("project", "项目名称"),
    NODE_NAME_PROPERTIES_EVENT("profileEvent", "事件类型节点"),
    NODE_NAME_PROPERTIES_MOBILE("mobile", "手机号"),
    NODE_NAME_PROPERTIES_NAME("$name", "姓名"),
    NODE_NAME_PROPERTIES_BANKNAME("bankName", "银行名称"),
    NODE_NAME_PROPERTIES_GENDER("gender", "性别"),
    NODE_NAME_PROPERTIES_AGE("age", "年龄"),
    NODE_NAME_PROPERTIES_TOTAL_INVEST_NUM("totalInvestNum", "总投资笔数"),
    NODE_NAME_PROPERTIES_TOTAL_INVEST_AMOUNT("totalInvestAmount", "总投资金额"),
    NODE_NAME_PROPERTIES_TOTAL_ANNUAL_INVESTMENT("totalAnnualInvestment", "总投资年华"),
    NODE_NAME_PROPERTIES_TOTAL_PROFIT("totalProfit", "总收益"),
    NODE_NAME_PROPERTIES_DUE_IN_NUM("dueInNum", "在投笔数"),
    NODE_NAME_PROPERTIES_DUE_IN_PRINCIPAL("dueInPrincipal", "在投金额"),
    NODE_NAME_PROPERTIES_REG_CHANNEL_BIG("bigRegChannel", "注册来源大渠道"),
    NODE_NAME_PROPERTIES_SOURCE("source", "平台类型"),
    NODE_NAME_PROPERTIES_REG_CHANNEL("regChannel", "注册来源小渠道"),
    NODE_NAME_PROPERTIES_MEMBER_LEVEL("memberLevel", "用户等级"),
    NODE_NAME_PROPERTIES_SALEMAN_FLAG("salemanFlag", "是否理财师"),
    NODE_NAME_PROPERTIES_SALEMAN_TYPE("salemanType", "理财师类型"),
    NODE_NAME_PROPERTIES_REFERRER_MOBILE("referrerMobile", "推荐人手机号"),
    NODE_NAME_PROPERTIES_REFERRER_UID("referrerUid", "推荐人id"),
    NODE_NAME_PROPERTIES_KEYWORD("keyword", "注册来源关键词");


    private String code;

    private String description;

    SensorsDataUserFieldEnum() {

    }

    SensorsDataUserFieldEnum(String code, String desc) {
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

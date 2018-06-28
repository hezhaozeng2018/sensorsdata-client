package com.xiaoniuapp.dataanalysis.sensorsdata.enums;

/**
 * @author Administrator
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public enum SensorsDataEventEnum {

    USER_REGISTER_CODE_SEND("registerCodeSend", "注册发送短信验证码"),
    USER_MOBILE_VERIFY("mobileVerify", "注册验证短信验证码"),
    USER_REGISTER("userRegister", "注册完成"),
    USER_GET_RED_PAPER("getRedpaper", "用户领取红包"),
    USER_USE_RED_PAPER("useRedpaper", "用户使用红包"),
    USER_GET_RATE_COUPON("getRateCoupon", "用户领取加息券"),
    USER_USE_RATE_COUPON("useRateCoupon", "用户使用加息券"),
    USER_GET_EXP_CASH("getExpCash", "用户领取体验金"),
    USER_USE_EXP_CASH("useExpCash", "用户使用体验金"),
    USER_LOGIN("userLogin", "用户登录"),
    ACCOUNT_PAY_PWD_SET("paypwdSetting", "设置交易密码"),
    ACCOUNT_BIND_AUTH_SMS("bindAuthSms", "绑卡鉴权"),
    ACCOUNT_BIND_AUTH_FINISH("bindAuthFinish", "绑卡完成"),
    ACCOUNT_RECHARGE_SMS_CODE("rechargeSmscode", "充值发送短信"),
    ACCOUNT_RECHARGE_FINISH("rechargeFinish", "充值完成"),
    INVEST_PAY_FINISH("investPayFinish", "投资支付完成"),
    INVEST_OTHER_PROFIT("otherProfit", "投资其他收益"),
    INVEST_REFUND("investRefund", "投资到期"),
    ACCOUNT_WITHDRAW_REQUEST("withdrawRequest", "提现申请"),
    ACCOUNT_WITHDRAW_SUCCESS("withdrawSuccess", "提现成功"),
    USER_GET_POINT("getPoint", "用户领取积分"),
    USER_USE_POINT("usePoint", "用户使用积分"),

    /** 设置用户profile事件start*/
    SET_PROFILE_INVEST("setProfileInvest", "用户投资设置profile"),
    SET_PROFILE_REFUND("setProfileRefund", "用户回款设置profile"),
    SET_PROFILE_REGISTER("setProfileRegister", "用户注册设置profile");
    /** 设置用户profile事件end*/

    private String code;

    private String description;

    SensorsDataEventEnum() {

    }

    SensorsDataEventEnum(String code, String desc) {
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

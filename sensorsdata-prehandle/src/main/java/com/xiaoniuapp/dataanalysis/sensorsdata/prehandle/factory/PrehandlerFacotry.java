package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.factory;

import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataEventEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler.*;
import org.apache.commons.lang.StringUtils;

/**
 * 数据预处理器的工厂。
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class PrehandlerFacotry {

    private PrehandlerFacotry() {
    }


    public static IPrehandler createPrehandler(String eventType) {
        if (StringUtils.isBlank(eventType)) {
            return null;
        }

        if (SensorsDataEventEnum.INVEST_PAY_FINISH.getCode().equals(eventType)) {
            return InvestFinishPrehandler.getInstance();
        }

        if (SensorsDataEventEnum.INVEST_REFUND.getCode().equals(eventType)) {
            return InvestRefundPrehandler.getInstance();
        }

        if (SensorsDataEventEnum.USER_GET_RED_PAPER.getCode().equals(eventType)
                || SensorsDataEventEnum.USER_USE_RED_PAPER.getCode().equals(eventType)
                || SensorsDataEventEnum.USER_GET_RATE_COUPON.getCode().equals(eventType)
                || SensorsDataEventEnum.USER_USE_RATE_COUPON.getCode().equals(eventType)
                || SensorsDataEventEnum.USER_GET_EXP_CASH.getCode().equals(eventType)
                || SensorsDataEventEnum.USER_USE_EXP_CASH.getCode().equals(eventType)) {
            return PropPrehandler.getInstance();
        }

        if (SensorsDataEventEnum.ACCOUNT_WITHDRAW_REQUEST.getCode().equals(eventType)) {
            return WithdrawRequestPrehandler.getInstance();
        }

        if (SensorsDataEventEnum.SET_PROFILE_INVEST.getCode().equals(eventType)) {
            return SetProfileInvestPrehandler.getInstance();
        }

        if (SensorsDataEventEnum.SET_PROFILE_REFUND.getCode().equals(eventType)) {
            return SetProfileRefundPrehandler.getInstance();
        }

        if (SensorsDataEventEnum.SET_PROFILE_REGISTER.getCode().equals(eventType)) {
            return SetProfileRegisterPrehandler.getInstance();
        }

        return null;
    }
}

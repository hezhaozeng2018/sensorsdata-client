package com.xiaoniuapp.dataanalysis.sensorsdata.service;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.xiaoniuapp.common.utils.MoneyUnitUtils;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.*;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataEventEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 神策分析数据接入接口-账户相关接口
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Service
public class SensorsDataAccountClient {


    private Logger logger = LoggerFactory.getLogger(SensorsDataAccountClient.class);

    @Autowired
    private SensorsAnalytics sensorsAnalytics;

    /**
     * 用户设置支付密码
     *
     * @param vo
     */
    public void payPwdSet(SensorsPayPwdSettingReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("payPwdSet|用户设置支付密码参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode()
                , vo.getMsg() == null ? "" : vo.getMsg());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.ACCOUNT_PAY_PWD_SET.getCode(),
                    properties);
        } catch (Exception e) {
            logger.warn("payPwdSet|用户设置支付密码写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户绑卡鉴权
     *
     * @param vo
     */
    public void bindAuthSms(SensorsBindAuthSmsReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("bindAuthSms|用户绑卡鉴权参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_BANKCODE.getCode()
                , vo.getBankCode() == null ? "" : vo.getBankCode());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode()
                , vo.getMsg() == null ? "" : vo.getMsg());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.ACCOUNT_BIND_AUTH_SMS.getCode(), properties);
        } catch (Exception e) {
            logger.warn("bindAuthSms|用户绑卡鉴权写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户绑卡完成
     *
     * @param vo
     */
    public void bindAuthFinish(SensorsBindAuthFinishReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("bindAuthFinish|用户绑卡完成参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_BANKCODE.getCode()
                , vo.getBankCode() == null ? "" : vo.getBankCode());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode()
                , vo.getMsg() == null ? "" : vo.getMsg());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.ACCOUNT_BIND_AUTH_FINISH.getCode(), properties);
        } catch (Exception e) {
            logger.warn("bindAuthFinish|用户绑卡完成写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户充值发送短信
     *
     * @param vo
     */
    public void rechargeSmscode(SensorsRechargeSmscodeReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("rechargeSmscode|用户充值发送短信参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode()
                , vo.getMsg() == null ? "" : vo.getMsg());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.ACCOUNT_RECHARGE_SMS_CODE.getCode(), properties);
        } catch (Exception e) {
            logger.warn("rechargeSmscode|用户充值发送短信写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户充值完成
     *
     * @param vo
     */
    public void rechargeFinish(SensorsRechargeFinishReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("rechargeFinish|用户充值完成参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode()
                , MoneyUnitUtils.milliToYuan(vo.getAmount()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PROVIDER.getCode()
                , vo.getProvider() == null ? "" : vo.getProvider());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode()
                , vo.getMsg() == null ? "" : vo.getMsg());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.ACCOUNT_RECHARGE_FINISH.getCode(), properties);
        } catch (Exception e) {
            logger.warn("rechargeFinish|用户充值完成写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户申请提现
     *
     * @param vo
     */
    public void withdrawRequest(SensorsWithdrawRequestReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("withdrawRequest|用户申请提现参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PARTNER.getCode()
                , vo.getPartner() == null ? "" : vo.getPartner());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode()
                , MoneyUnitUtils.milliToYuan(vo.getAmount()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_WITHDRAW_REQUEST_ID.getCode()
                , vo.getRequestId() == null ? "" : vo.getRequestId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode()
                , vo.getMsg() == null ? "" : vo.getMsg());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.ACCOUNT_WITHDRAW_REQUEST.getCode(), properties);
        } catch (Exception e) {
            logger.warn("withdrawRequest|用户申请提现写神策日志异常,vo={}", vo, e);
        }
    }
    /**
     * 用户提现完成
     *
     * @param vo
     */
    public void withdrawSuccess(SensorsWithdrawSuccessReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("withdrawSuccess|用户提现完成参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode()
                , MoneyUnitUtils.milliToYuan(vo.getAmount()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_WITHDRAW_REQUEST_ID.getCode()
                , vo.getRequestId() == null ? "" : vo.getRequestId());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.ACCOUNT_WITHDRAW_SUCCESS.getCode(), properties);
        } catch (Exception e) {
            logger.warn("withdrawSuccess|用户提现完成写神策日志异常,vo={}", vo, e);
        }
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.service;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsMobileVerifyReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsRegisterCodeSendReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsUserRegisterReq;
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
 * 神策分析数据接入接口-注册相关接口
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Service
public class SensorsDataRegisterClient {


    private Logger logger = LoggerFactory.getLogger(SensorsDataRegisterClient.class);

    @Autowired
    private SensorsAnalytics sensorsAnalytics;

    /**
     * 注册发送验证码
     *
     * @param vo
     */
    public void registerSendCode(SensorsRegisterCodeSendReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("registerSendCode|注册发送验证码参数错误，vo={}", vo);
            return;
        }
        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REG_CHANNEL.getCode()
                , vo.getRegChannel() == null ? "" : vo.getRegChannel());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MOBILE.getCode(), vo.getMobile());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), false, SensorsDataEventEnum.USER_REGISTER_CODE_SEND.getCode(),
                    properties);
        } catch (Exception e) {
            logger.warn("registerSendCode|注册发送验证码写神策日志异常,vo={}", vo, e);
        }

    }

    /**
     * 注册验证短信验证码
     *
     * @param vo
     */
    public void mobileVerify(SensorsMobileVerifyReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("mobileVerify|注册验证短信验证码参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REG_CHANNEL.getCode(),
                vo.getRegChannel() == null ? "" : vo.getRegChannel());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode(),
                vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode(),
                vo.getMsg() == null ? "" : vo.getMsg());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), false,
                    SensorsDataEventEnum.USER_MOBILE_VERIFY.getCode(), properties);
        } catch (Exception e) {
            logger.warn("mobileVerify|注册验证短信验证码写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户注册完成
     *
     * @param vo
     */
    public void userRegister(SensorsUserRegisterReq vo) {
        if ((vo.isResult() && StringUtils.isBlank(vo.getNewDistinctId()))
                || (!vo.isResult() && StringUtils.isBlank(vo.getDistinctId()))) {
            logger.warn("userRegister|用户注册完成参数错误，vo={}", vo);
            return;
        }
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("userRegister|用户注册完成参数错误，distinctId为空，vo={}", vo);
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REG_CHANNEL.getCode(),
                vo.getRegChannel() == null ? "" : vo.getRegChannel());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode(),
                vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MOBILE.getCode(),
                vo.getMobile());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_KEYWORD.getCode(),
                vo.getKeyword() == null ? "" : vo.getKeyword());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(),
                vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode(),
                vo.getMsg() == null ? "" : vo.getMsg());

        try {
            if (vo.isResult()) {
                if (StringUtils.isNotBlank(vo.getDistinctId())) {
                    sensorsAnalytics.trackSignUp(vo.getNewDistinctId(), vo.getDistinctId());    // 注册前行为的绑定
                }
                sensorsAnalytics.track(vo.getNewDistinctId(), true,
                        SensorsDataEventEnum.USER_REGISTER.getCode(), properties);
            } else {
                sensorsAnalytics.track(vo.getDistinctId(), false,
                        SensorsDataEventEnum.USER_REGISTER.getCode(), properties);
            }
        } catch (Exception e) {
            logger.warn("userRegister|用户注册完成写神策日志异常,vo={}", vo, e);
        }
    }
}

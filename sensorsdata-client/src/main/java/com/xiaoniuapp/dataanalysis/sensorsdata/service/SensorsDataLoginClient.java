package com.xiaoniuapp.dataanalysis.sensorsdata.service;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
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
 * 神策分析数据接入接口-登录相关接口
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Service
public class SensorsDataLoginClient {


    private Logger logger = LoggerFactory.getLogger(SensorsDataLoginClient.class);

    @Autowired
    private SensorsAnalytics sensorsAnalytics;

    /**
     * 用户登录
     *
     * @param vo
     */
    public void userLogin(SensorsUserLoginReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("userLogin|用户登录参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode(), vo.getSource() == null ? "" : vo.getSource());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.USER_LOGIN.getCode(), properties);
        } catch (Exception e) {
            logger.warn("userLogin|用户登录写神策日志异常,vo={}", vo, e);
        }
    }
}

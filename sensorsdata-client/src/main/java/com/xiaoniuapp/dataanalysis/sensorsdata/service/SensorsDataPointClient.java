package com.xiaoniuapp.dataanalysis.sensorsdata.service;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsGetPointReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsUsePointReq;
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
 * 神策分析数据接入接口-用户积分相关接口
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Service
public class SensorsDataPointClient {


    private Logger logger = LoggerFactory.getLogger(SensorsDataPointClient.class);

    @Autowired
    private SensorsAnalytics sensorsAnalytics;

    /**
     * 用户领取积分
     *
     * @param req
     */
    public void getPoint(SensorsGetPointReq req) {
        if (StringUtils.isBlank(req.getDistinctId())) {
            logger.warn("getPoint|用户领取积分参数错误，req={}", req);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode(), req.getSource() == null ? "" : req.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_BUSINESS_TYPE.getCode(), req.getBusinessType() == null ? "" :
                req.getBusinessType());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REMARK.getCode(), req.getRemark() == null ? "" : req
                .getRemark());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_POINT_NUM.getCode(), req.getPointNum());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_TOTAL_POINT_NUM.getCode(), req.getTotalPointNum());
        try {
            sensorsAnalytics.track(req.getDistinctId(), true, SensorsDataEventEnum.USER_GET_POINT.getCode(), properties);
        } catch (Exception e) {
            logger.warn("getPoint|用户领取积分写神策日志异常,req={}", req, e);
        }
    }

    /**
     * 用户使用积分
     *
     * @param req
     */
    public void usePoint(SensorsUsePointReq req) {
        if (StringUtils.isBlank(req.getDistinctId())) {
            logger.warn("usePoint|用户使用积分参数错误，req={}", req);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode(), req.getSource() == null ? "" : req.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_GOODS_ID.getCode(), req.getGoodsId() == null ? "" : req
                .getGoodsId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_GOODS_NUM.getCode(), req.getGoodsNum());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_POINT_NUM.getCode(), req.getPointNum());
        try {
            sensorsAnalytics.track(req.getDistinctId(), true, SensorsDataEventEnum.USER_USE_POINT.getCode(), properties);
        } catch (Exception e) {
            logger.warn("usePoint|用户使用积分写神策日志异常,req={}", req, e);
        }
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.service;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.xiaoniuapp.common.utils.MoneyUnitUtils;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsInvestPayFinishReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsInvestRefundReq;
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
 * 神策分析数据接入接口-投资相关接口
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Service
public class SensorsDataInvestClient {


    private Logger logger = LoggerFactory.getLogger(SensorsDataInvestClient.class);

    @Autowired
    private SensorsAnalytics sensorsAnalytics;

    /**
     * 用户投资完成
     *
     * @param vo
     */
    public void investPayFinish(SensorsInvestPayFinishReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("investPayFinish|用户投资完成参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_ID.getCode()
                , vo.getInvestId() == null ? "" : vo.getInvestId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_ID.getCode()
                , vo.getProductId() == null ? "" : vo.getProductId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_NAME.getCode()
                , vo.getProductName() == null ? "" : vo.getProductName());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FIXED_FLAG.getCode(), vo.isFixedFlag());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FINAL_RATE.getCode()
                , vo.getFinalRate() == null ? "" : vo.getFinalRate());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRINCIPAL.getCode()
                , MoneyUnitUtils.milliToYuan(vo.getPrincipal()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ODD_PROFIT.getCode()
                , MoneyUnitUtils.milliToYuan(vo.getOddProfit()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REFUND_ISSUE.getCode(), vo.getRefundIssue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RESULT.getCode(), vo.isResult());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MSG.getCode()
                , vo.getMsg() == null ? "" : vo.getMsg());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.INVEST_PAY_FINISH.getCode(), properties);
        } catch (Exception e) {
            logger.warn("investPayFinish|用户投资完成写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户投资到期
     *
     * @param vo
     */
    public void investRefund(SensorsInvestRefundReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("investRefund|用户投资到期参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_ID.getCode(), vo.getInvestId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_ID.getCode(), vo.getProductId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_NAME.getCode(), vo.getProductName());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REFUND_ISSUE.getCode(), vo.getRefundIssue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRINCIPAL.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getPrincipal()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ODD_PROFIT.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getOddProfit()).doubleValue());

        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.INVEST_REFUND.getCode(), properties);
        } catch (Exception e) {
            logger.warn("investRefund|用户投资到期写神策日志异常,vo={}", vo, e);
        }
    }
}

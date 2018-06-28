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
 * 神策分析数据接入接口-道具（红包/加息券/理财金/积分等）领取/使用相关接口
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Service
public class SensorsDataPropClient {


    private Logger logger = LoggerFactory.getLogger(SensorsDataPropClient.class);

    @Autowired
    private SensorsAnalytics sensorsAnalytics;

    /**
     * 用户领取现金红包
     *
     * @param vo
     */
    public void getRedpaper(SensorsGetRedpaperReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("getRedpaper|用户领取现金红包参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REDPAPER_ID.getCode(), vo.getRedpaperId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRINCIPAL.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getPrincipal()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_VALID_DAYS.getCode(), vo.getValidDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getAmount()).doubleValue());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.USER_GET_RED_PAPER.getCode(), properties);
        } catch (Exception e) {
            logger.warn("getRedpaper|用户领取现金红包写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户使用现金红包
     *
     * @param vo
     */
    public void useRedpaper(SensorsUseRedpaperReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("useRedpaper|用户使用现金红包参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REDPAPER_ID.getCode(), vo.getRedpaperId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_ID.getCode(), vo.getInvestId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRINCIPAL.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getPrincipal()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_VALID_DAYS.getCode(), vo.getValidDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getAmount()).doubleValue());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.USER_USE_RED_PAPER.getCode(), properties);
        } catch (Exception e) {
            logger.warn("useRedpaper|用户使用现金红包写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户领取加息券
     *
     * @param vo
     */
    public void getRateCoupon(SensorsGetRateCouponReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("getRateCoupon|用户领取加息券参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RATECOUPON_ID.getCode(), vo.getRateCouponId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRINCIPAL.getCode()
                , MoneyUnitUtils.milliToYuan(vo.getPrincipal()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_VALID_DAYS.getCode(), vo.getValidDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RATE_DAYS.getCode(), vo.getRateDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FINAL_RATE.getCode(), vo.getFinalRate());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.USER_GET_RATE_COUPON.getCode(), properties);
        } catch (Exception e) {
            logger.warn("getRateCoupon|用户领取加息券写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户使用加息券
     *
     * @param vo
     */
    public void useRateCoupon(SensorsUseRateCouponReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("useRateCoupon|用户使用加息券参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RATECOUPON_ID.getCode(), vo.getRateCouponId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_ID.getCode(), vo.getInvestId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRINCIPAL.getCode()
                , MoneyUnitUtils.milliToYuan(vo.getPrincipal()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_VALID_DAYS.getCode(), vo.getValidDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RATE_DAYS.getCode(), vo.getRateDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FINAL_RATE.getCode(), vo.getFinalRate());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PROFIT.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getProfit()).doubleValue());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.USER_USE_RATE_COUPON.getCode(), properties);
        } catch (Exception e) {
            logger.warn("useRateCoupon|用户使用加息券写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户领取理财金
     *
     * @param vo
     */
    public void getExpCash(SensorsGetExpCashReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("getExpCash|用户领取理财金参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_EXPCASH_ID.getCode(), vo.getExpCashId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_ID.getCode(), vo.getProductId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_VALID_DAYS.getCode(), vo.getValidDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getAmount()).doubleValue());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.USER_GET_EXP_CASH.getCode(), properties);
        } catch (Exception e) {
            logger.warn("getExpCash|用户领取理财金写神策日志异常,vo={}", vo, e);
        }
    }

    /**
     * 用户使用理财金
     *
     * @param vo
     */
    public void useExpCash(SensorsUseExpCashReq vo) {
        if (StringUtils.isBlank(vo.getDistinctId())) {
            logger.warn("useExpCash|用户使用理财金参数错误，vo={}", vo);
            return;
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , vo.getSource() == null ? "" : vo.getSource());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_EXPCASH_ID.getCode(), vo.getExpCashId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_ID.getCode(), vo.getProductId());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_VALID_DAYS.getCode(), vo.getValidDays());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getAmount()).doubleValue());
        properties.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PROFIT.getCode(), MoneyUnitUtils.milliToYuan(vo
                .getProfit()).doubleValue());
        try {
            sensorsAnalytics.track(vo.getDistinctId(), true, SensorsDataEventEnum.USER_USE_EXP_CASH.getCode(), properties);
        } catch (Exception e) {
            logger.warn("useExpCash|用户使用理财金写神策日志异常,vo={}", vo, e);
        }
    }
}

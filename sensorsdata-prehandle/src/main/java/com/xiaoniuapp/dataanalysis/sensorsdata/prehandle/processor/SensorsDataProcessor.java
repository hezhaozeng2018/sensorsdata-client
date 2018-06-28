package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sensorsdata.analytics.extractor.processor.ExtProcessor;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataUserFieldEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.factory.PrehandlerFacotry;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler.IPrehandler;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 预处理模块，用来拦截要发送到神策服务器的数据，并对数据进行扩展
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsDataProcessor implements ExtProcessor {

    private static final Logger logger = LoggerFactory.getLogger(SensorsDataProcessor.class);

    public String process(String record) {
        if (logger.isInfoEnabled()) {
            logger.info("process|预处理数据，record={}", record);
        }
        if (StringUtils.isBlank(record)) {
            return null;
        }

        JSONObject recordJO = JSON.parseObject(record);
        String eventType = recordJO.getString(SensorsDataNodeNameEnum.NODE_NAME_EVENT.getCode());
        if (StringUtils.isBlank(eventType)) {
            JSONObject propertiesJo = recordJO.getJSONObject(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES.getCode());
            eventType = propertiesJo.getString(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_EVENT.getCode());
            if (StringUtils.isBlank(eventType)) {
                return record;
            }
        }

        IPrehandler prehandler = PrehandlerFacotry.createPrehandler(eventType);
        if (prehandler == null) {
            logger.warn("process|预处理数据，未识别事件类型！record={},eventType={}", record, eventType);
            return this.handleFieldRename(record);
        }
        String newRecord;
        try {
            newRecord = prehandler.handle(record);
        } catch (Exception e) {
            logger.error("process|预处理数据发生异常,record={}", record, e);
            return this.handleFieldRename(record);
        }
        if (StringUtils.isBlank(newRecord)) {
            if (logger.isInfoEnabled()) {
                logger.info("process|预处理数据，数据未被成功处理,newRecord={},origRecord={}", newRecord, record);
            }
            return this.handleFieldRename(record);
        }

        if (logger.isInfoEnabled()) {
            logger.info("process!预处理数据，数据成功处理,newRecord={},origRecord={}", newRecord, record);
        }
        newRecord = this.handleFieldRename(newRecord);
        return newRecord;
    }

    /**
     * 处理字段改名
     *
     * @param record
     * @return
     */
    private String handleFieldRename(String record) {
        JSONObject dataJo = JSON.parseObject(record);
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        String eventType = propertiesJo.getString(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_EVENT.getCode());
        if (StringUtils.isNotBlank(eventType)) {
            return dataJo.toJSONString();
        }
        // oddPrifit改名
        String oddProfitKey = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ODD_PROFIT.getCode();
        if (propertiesJo.containsKey(oddProfitKey)) {
            Double value = propertiesJo.getDouble(oddProfitKey);
            propertiesJo.remove(oddProfitKey);
            propertiesJo.put(oddProfitKey + "New", this.nullToZero(value));
        }
        // amount改名
        String amountKey = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_AMOUNT.getCode();
        if (propertiesJo.containsKey(amountKey)) {
            Double value = propertiesJo.getDouble(amountKey);
            propertiesJo.remove(amountKey);
            propertiesJo.put(amountKey + "New", this.nullToZero(value));
        }

        // fixedFlag改名
        String fixedFlagKey = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FIXED_FLAG.getCode();
        if (propertiesJo.containsKey(fixedFlagKey)) {
            Boolean value = propertiesJo.getBoolean(fixedFlagKey);
            propertiesJo.remove(fixedFlagKey);
            propertiesJo.put(fixedFlagKey + "New", value == null ? false : value);
        }
        // annualInvestment改名
        String annualInvestmentKey = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ANNUAL_INVESTMENT.getCode();
        if (propertiesJo.containsKey(annualInvestmentKey)) {
            Double value = propertiesJo.getDouble(annualInvestmentKey);
            propertiesJo.remove(annualInvestmentKey);
            propertiesJo.put(annualInvestmentKey + "New", this.nullToZero(value));
        }
        // totalProfit改名
        String totalProfitKey = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_TOTAL_PROFIT.getCode();
        if (propertiesJo.containsKey(totalProfitKey)) {
            Double value = propertiesJo.getDouble(totalProfitKey);
            propertiesJo.remove(totalProfitKey);
            propertiesJo.put(totalProfitKey + "New", this.nullToZero(value));
        }
        // couponId改名
        String couponIdKey = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_COUPON_ID.getCode();
        if (propertiesJo.containsKey(couponIdKey)) {
            String value = propertiesJo.getString(couponIdKey);
            propertiesJo.remove(couponIdKey);
            propertiesJo.put(couponIdKey + "New", this.nullToEmpty(value));
        }
        return dataJo.toJSONString();
    }

    private String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    private double nullToZero(Double d) {
        return d == null ? 0d : d;
    }
}

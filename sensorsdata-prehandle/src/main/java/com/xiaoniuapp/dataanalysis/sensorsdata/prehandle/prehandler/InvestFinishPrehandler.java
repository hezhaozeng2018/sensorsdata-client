package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain.SensorsInvestFinishPrehandleVo;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 投资支付完成数据预处理器
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class InvestFinishPrehandler extends AbstractPrehandler {

    private static final String REQUEST_URL = "/investFinish";

    private static volatile IPrehandler iPrehandler;

    private InvestFinishPrehandler() {
    }

    public static IPrehandler getInstance() {
        if (iPrehandler == null) {
            synchronized (InvestFinishPrehandler.class) {
                if (iPrehandler == null) {
                    iPrehandler = new InvestFinishPrehandler();
                }
            }
        }
        return iPrehandler;
    }

    @Override
    protected boolean validParam(JSONObject dataJo) {
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        if (propertiesJo == null) {
            return false;
        }
        String productId = propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_ID.getCode());
        return StringUtils.isNotBlank(productId);
    }

    @Override
    protected Map<String, String> buildRequestParam(JSONObject dataJo) {
        Map<String, String> requestParam = new HashMap<>();
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        requestParam.put("investId", propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_ID.getCode()));
        // 如果investId为null，则根据productId查询产品信息
        requestParam.put("productId", propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_ID.getCode()));
        return requestParam;
    }

    @Override
    protected String getRequestUrl() {
        return REQUEST_URL;
    }

    @Override
    protected String assembleResponse(ResponseData responseData, JSONObject origData) {
        SensorsInvestFinishPrehandleVo vo = JSON.parseObject(responseData.getData().toString(),
                SensorsInvestFinishPrehandleVo.class);
        JSONObject propertiesJo = origData.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PRODUCT_NAME.getCode()
                , vo.getProductName() == null ? "" : vo.getProductName());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FIXED_FLAG.getCode(), vo.isFixFlag());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REFUND_ISSUE.getCode(), vo.getRefundIssue());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ANNUAL_INVESTMENT.getCode(), vo.getAnnualInvestment());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REDPAPER_PROFIT.getCode(), vo.getRedpaperProfit());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RATECOUPON_PROFIT.getCode(), vo.getRateCouponProfit());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_COLLECT_PROFIT.getCode(), vo.getCollectProfit());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_MEMBERRATE_PROFIT.getCode(), vo.getMemberRateProfit());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ACTIVITYRATE_PROFIT.getCode(), vo.getActivityRateProfit());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_GIFT_AMOUNT.getCode(), vo.getGiftAmount());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_TOTAL_PROFIT.getCode(), vo.getTotalProfit());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ANNUAL_RATE.getCode()
                , vo.getAnnualRate() == null ? "" : vo.getAnnualRate());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FIRST_INVEST_FLAG.getCode(), vo.isFirstInvestFlag());

        return origData.toJSONString();
    }
}

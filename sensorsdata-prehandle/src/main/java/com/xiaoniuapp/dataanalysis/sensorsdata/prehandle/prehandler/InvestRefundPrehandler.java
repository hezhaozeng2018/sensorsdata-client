package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain.SensorsInvestRefundPrehandleVo;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 投资回款数据预处理器
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class InvestRefundPrehandler extends AbstractPrehandler {

    private static final String REQUEST_URL = "/investRefund";

    private static volatile IPrehandler iPrehandler;

    private InvestRefundPrehandler() {
    }

    public static IPrehandler getInstance() {
        if (iPrehandler == null) {
            synchronized (InvestRefundPrehandler.class) {
                if (iPrehandler == null) {
                    iPrehandler = new InvestRefundPrehandler();
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
        String investId = propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_ID.getCode());
        return StringUtils.isNotBlank(investId);
    }

    @Override
    protected Map<String, String> buildRequestParam(JSONObject dataJo) {
        Map<String, String> requestParam = new HashMap<>();
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        requestParam.put("investId", propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_ID.getCode()));
        return requestParam;
    }

    @Override
    protected String getRequestUrl() {
        return REQUEST_URL;
    }

    @Override
    protected String assembleResponse(ResponseData responseData, JSONObject origData) {
        SensorsInvestRefundPrehandleVo vo = JSON.parseObject(responseData.getData().toString(),
                SensorsInvestRefundPrehandleVo.class);
        JSONObject propertiesJo = origData.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FIXED_FLAG.getCode(), vo.isFixFlag());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_CURRENT_REFUND_ISSUE.getCode()
                , vo.getCurrentRefundIssue());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ANNUAL_INVESTMENT.getCode()
                , vo.getAnnualInvestment());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_FINAL_RATE.getCode()
                , vo.getFinalRate() == null ? "" : vo.getFinalRate());
        if (vo.getInvestPeriod() > 0) {
            propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_INVEST_PERIOD.getCode(), vo.getInvestPeriod());
        }

        return origData.toJSONString();
    }
}

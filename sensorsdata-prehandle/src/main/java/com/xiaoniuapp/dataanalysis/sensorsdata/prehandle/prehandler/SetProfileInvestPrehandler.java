package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataUserFieldEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain.SensorsSetProfitInvestPrehandleVo;

import java.util.HashMap;
import java.util.Map;

/**
 * 投资支付完成数据预处理器：设置profile
 *
 * @author hezhaozeng
 * @date 2017/7/18
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SetProfileInvestPrehandler extends AbstractPrehandler {

    private static final String REQUEST_URL = "/setProfileInvest";

    private static volatile IPrehandler iPrehandler;

    private SetProfileInvestPrehandler() {
    }

    public static IPrehandler getInstance() {
        if (iPrehandler == null) {
            synchronized (SetProfileInvestPrehandler.class) {
                if (iPrehandler == null) {
                    iPrehandler = new SetProfileInvestPrehandler();
                }
            }
        }
        return iPrehandler;
    }

    @Override
    protected boolean validParam(JSONObject dataJo) {
        return validDistinctId(dataJo);
    }

    @Override
    protected Map<String, String> buildRequestParam(JSONObject dataJo) {
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("userId", dataJo.getString(SensorsDataUserFieldEnum.NODE_NAME_DISTINCT_ID.getCode()));
        return requestParam;
    }

    @Override
    protected String getRequestUrl() {
        return REQUEST_URL;
    }

    @Override
    protected String assembleResponse(ResponseData respData, JSONObject origData) {
        SensorsSetProfitInvestPrehandleVo vo = JSON.parseObject(respData.getData().toString(),
                SensorsSetProfitInvestPrehandleVo.class);
        JSONObject propertiesJo = origData.getJSONObject(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES.getCode());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_TOTAL_INVEST_AMOUNT.getCode(),
                vo.getTotalInvestAmount());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_TOTAL_INVEST_NUM.getCode(),
                vo.getTotalInvestNum());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_DUE_IN_PRINCIPAL.getCode(),
                vo.getDueInPrincipal());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_DUE_IN_NUM.getCode(),
                vo.getDueInNum());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_TOTAL_ANNUAL_INVESTMENT.getCode(),
                vo.getTotalAnnualInvestment());

        return origData.toJSONString();
    }
}

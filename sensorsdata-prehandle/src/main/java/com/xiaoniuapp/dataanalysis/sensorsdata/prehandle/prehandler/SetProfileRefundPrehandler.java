package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataUserFieldEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain.SensorsSetProfitRefundPrehandleVo;

import java.util.HashMap;
import java.util.Map;

/**
 * 投资支付完成数据预处理器：设置profile
 *
 * @author hezhaozeng
 * @date 2017/7/18
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SetProfileRefundPrehandler extends AbstractPrehandler {

    private static final String REQUEST_URL = "/setProfileRefund";

    private static volatile IPrehandler iPrehandler;

    private SetProfileRefundPrehandler() {
    }

    public static IPrehandler getInstance() {
        if (iPrehandler == null) {
            synchronized (SetProfileRefundPrehandler.class) {
                if (iPrehandler == null) {
                    iPrehandler = new SetProfileRefundPrehandler();
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
    protected String assembleResponse(ResponseData responseData, JSONObject origData) {
        SensorsSetProfitRefundPrehandleVo vo = JSON.parseObject(responseData.getData().toString(),
                SensorsSetProfitRefundPrehandleVo.class);
        JSONObject propertiesJo = origData.getJSONObject(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES.getCode());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_DUE_IN_PRINCIPAL.getCode(),
                vo.getDueInPrincipal());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_DUE_IN_NUM.getCode(),
                vo.getDueInNum());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_TOTAL_PROFIT.getCode(),
                vo.getTotalProfit());

        return origData.toJSONString();
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain.SensorsWithdrawPrehandleVo;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 提现请求数据预处理器
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class WithdrawRequestPrehandler extends AbstractPrehandler {

    private static final String REQUEST_URL = "/withdrawRequest";

    private static volatile IPrehandler iPrehandler;

    private WithdrawRequestPrehandler() {
    }

    public static IPrehandler getInstance() {
        if (iPrehandler == null) {
            synchronized (WithdrawRequestPrehandler.class) {
                if (iPrehandler == null) {
                    iPrehandler = new WithdrawRequestPrehandler();
                }
            }
        }
        return iPrehandler;
    }

    @Override
    protected boolean validParam(JSONObject dataJo) {
        String userId = dataJo.getString(SensorsDataNodeNameEnum.NODE_NAME_DISTINCT_ID.getCode());
        if (StringUtils.isBlank(userId)) {
            return false;
        }

        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        String withdrawRequestId = propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_WITHDRAW_REQUEST_ID.getCode());
        if (StringUtils.isBlank(withdrawRequestId)) {
            return false;
        }

        String partner = propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PARTNER.getCode());
        return StringUtils.isNotBlank(partner);
    }

    @Override
    protected Map<String, String> buildRequestParam(JSONObject dataJo) {
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("userId", dataJo.getString(SensorsDataNodeNameEnum.NODE_NAME_DISTINCT_ID.getCode()));
        requestParam.put("withdrawRequestId", propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_WITHDRAW_REQUEST_ID.getCode()));
        requestParam.put("partner", propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_PARTNER.getCode()));
        return requestParam;
    }

    @Override
    protected String getRequestUrl() {
        return REQUEST_URL;
    }

    @Override
    protected String assembleResponse(ResponseData responseData, JSONObject origData) {
        JSONObject propertiesJo = origData.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        SensorsWithdrawPrehandleVo vo = JSON.parseObject(responseData.getData().toString(),
                SensorsWithdrawPrehandleVo.class);
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_BALANCE.getCode(), vo.getBalance());
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_DUE_IN_PRINCIPAL.getCode(), vo.getDueInPrincipal());

        return origData.toJSONString();
    }
}

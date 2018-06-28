package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataUserFieldEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain.SensorsSetProfitRegisterPrehandleVo;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册完成数据预处理器：设置profile
 *
 * @author hezhaozeng
 * @date 2017/7/18
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SetProfileRegisterPrehandler extends AbstractPrehandler {

    private static final String REQUEST_URL = "/setProfileRegister";

    private static volatile IPrehandler iPrehandler;

    private SetProfileRegisterPrehandler() {
    }

    public static IPrehandler getInstance() {
        if (iPrehandler == null) {
            synchronized (SetProfileRegisterPrehandler.class) {
                if (iPrehandler == null) {
                    iPrehandler = new SetProfileRegisterPrehandler();
                }
            }
        }
        return iPrehandler;
    }

    @Override
    protected boolean validParam(JSONObject dataJo) {
        if (!validDistinctId(dataJo)) {
            return false;
        }
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        if (propertiesJo == null) {
            return false;
        }
        String referrerUid = propertiesJo.getString(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_UID.getCode());
        String referrerMobile = propertiesJo.getString(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_MOBILE.getCode());
        return StringUtils.isNotBlank(referrerUid) && StringUtils.isBlank(referrerMobile);
    }

    @Override
    protected Map<String, String> buildRequestParam(JSONObject dataJo) {
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("userId", propertiesJo.getString(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_UID.getCode()));
        return requestParam;
    }

    @Override
    protected String getRequestUrl() {
        return REQUEST_URL;
    }

    @Override
    protected String assembleResponse(ResponseData responseData, JSONObject origData) {
        SensorsSetProfitRegisterPrehandleVo vo = JSON.parseObject(responseData.getData().toString(),
                SensorsSetProfitRegisterPrehandleVo.class);
        JSONObject propertiesJo = origData.getJSONObject(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES.getCode());
        propertiesJo.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_MOBILE.getCode(),
                vo.getReferrerMobile());
        propertiesJo.remove(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_UID.getCode());
        return origData.toJSONString();
    }
}

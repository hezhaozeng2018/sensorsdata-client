package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.domain.SensorsPropPrehandleVo;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 小道具数据预处理器
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class PropPrehandler extends AbstractPrehandler {

    private static final String REQUEST_URL = "/prop";

    private static volatile IPrehandler iPrehandler;

    private PropPrehandler() {
    }

    public static IPrehandler getInstance() {
        if (iPrehandler == null) {
            synchronized (PropPrehandler.class) {
                if (iPrehandler == null) {
                    iPrehandler = new PropPrehandler();
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
        boolean valid = true;
        if (StringUtils.isBlank(propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REDPAPER_ID.getCode()))
                && StringUtils.isBlank(propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RATECOUPON_ID.getCode()))
                && StringUtils.isBlank(propertiesJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_EXPCASH_ID.getCode()))) {
            valid = false;
        }
        return valid;
    }
    @Override
    protected Map<String, String> buildRequestParam(JSONObject dataJo) {
        Map<String, String> requestParam = new HashMap<>();
        String repaperIdName = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_REDPAPER_ID.getCode();
        String rateCouponIdName = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_RATECOUPON_ID.getCode();
        String expCashIdName = SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_EXPCASH_ID.getCode();
        String propIdKeyName = "propId";
        String propTypeKeyName = "propType";
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        if (!StringUtils.isBlank(propertiesJo.getString(repaperIdName))) {
            requestParam.put(propIdKeyName, propertiesJo.getString(repaperIdName));
            requestParam.put(propTypeKeyName, "redpaper");
        } else if (!StringUtils.isBlank(propertiesJo.getString(rateCouponIdName))) {
            requestParam.put(propIdKeyName, propertiesJo.getString(rateCouponIdName));
            requestParam.put(propTypeKeyName, "rateCoupon");
        } else if (!StringUtils.isBlank(propertiesJo.getString(expCashIdName))) {
            requestParam.put(propIdKeyName, propertiesJo.getString(expCashIdName));
            requestParam.put(propTypeKeyName, "expCash");
            requestParam.put("productId", propertiesJo.getString("productId"));
        }
        return requestParam;
    }

    @Override
    protected String getRequestUrl() {
        return REQUEST_URL;
    }

    @Override
    protected String assembleResponse(ResponseData responseData, JSONObject origData) {
        JSONObject propertiesJo = origData.getJSONObject(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES.getCode());
        SensorsPropPrehandleVo vo = JSON.parseObject(responseData.getData().toString(),
                SensorsPropPrehandleVo.class);
        propertiesJo.put(SensorsDataNodeNameEnum.NODE_NAME_PROPERTIES_ACTIVITY_NAME.getCode(), vo.getActivityName() == null ? ""
                : vo.getActivityName());

        return origData.toJSONString();
    }
}

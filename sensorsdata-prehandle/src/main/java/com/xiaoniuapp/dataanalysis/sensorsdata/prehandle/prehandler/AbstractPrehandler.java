package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.result.ResponseData;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataNodeNameEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataUserFieldEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.config.PartnerApiConfig;
import com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.remote.HttpProvider;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Administrator
 * @date 2017/6/29
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public abstract class AbstractPrehandler implements IPrehandler {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public String handle(String record) {
        if (StringUtils.isBlank(record)) {
            return null;
        }
        JSONObject dataJo = JSON.parseObject(record);
        if (!this.validParam(dataJo)) {
            return null;
        }

        Map<String, String> requestParam = this.buildRequestParam(dataJo);
        String requestUrl = this.getPartnerApi(dataJo) + this.getRequestUrl();
        if (logger.isInfoEnabled()) {
            logger.info("handle|预处理请求，record={}, requestParam={}, url={}", record, requestParam, requestUrl);
        }
        String rlt;
        try {
            rlt = HttpProvider.httpPost(requestParam, requestUrl);
        } catch (Exception e) {
            logger.error("handle|预处理投资成功事件发生异常, record={}, requestParam={}, url={}", record, requestParam, requestUrl, e);
            return null;
        }

        if (logger.isInfoEnabled()) {
            logger.info("handle|预处理请求响应，record={}, result={}", record, rlt);
        }
        if (StringUtils.isBlank(rlt)) {
            return null;
        }

        ResponseData responseData = JSON.parseObject(rlt, ResponseData.class);
        if (responseData.getData() == null) {
            logger.warn("handle|预处理投资成功事件失败!record={},responseData={}", record, responseData);
            return null;
        }
        return this.assembleResponse(responseData, dataJo);
    }

    protected boolean validParam(JSONObject dataJo) {
        return  true;
    }

    protected boolean validDistinctId(JSONObject dataJo) {
        JSONObject propertiesJo = dataJo.getJSONObject(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES.getCode());
        if (propertiesJo == null) {
            return false;
        }
        String userId = dataJo.getString(SensorsDataUserFieldEnum.NODE_NAME_DISTINCT_ID.getCode());
        return StringUtils.isNotBlank(userId);
    }

    protected abstract Map<String, String>  buildRequestParam(JSONObject dataJo);

    protected abstract String getRequestUrl();

    protected abstract String assembleResponse(ResponseData resp, JSONObject origData);

    private String getPartnerApi(JSONObject dataJo) {
        String projectName = dataJo.getString(SensorsDataNodeNameEnum.NODE_NAME_PROJECT.getCode());
        if (StringUtils.isBlank(projectName)) {
            return null;
        }

        return PartnerApiConfig.getPartnerApi(projectName);
    }
}

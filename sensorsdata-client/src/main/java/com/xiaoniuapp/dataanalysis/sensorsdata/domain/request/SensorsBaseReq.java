package com.xiaoniuapp.dataanalysis.sensorsdata.domain.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * @author Administrator
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsBaseReq implements Serializable {

    private String source;

    private String distinctId;

    public String getSource() {
        return source;
    }

    /**
     * 设置平台类别：如PC、微信、APP等
     *
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
    }

    public String getDistinctId() {
        return distinctId;
    }

    /**
     * 设置用户id
     *
     * @param distinctId
     */
    public void setDistinctId(String distinctId) {
        this.distinctId = distinctId;
    }

    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoniuapp.common.utils.CookieUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;

/**
 * 神策分析的工具类
 *
 * @author tangdengke
 * @date 2017/6/13
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsdataUtils {

    /**
     * distinctId在cookie中的key值
     */
    private static final String COOKIE_KEY_DISTINCT_ID = "sensorsdata2015jssdkcross";

    private static final String JSON_KEY_FIRST_ID = "first_id";

    private static final String JSON_KEY_DISTINCT_ID = "distinct_id";

    private SensorsdataUtils() {

    }

    /**
     * 从cookie中取出distinctId
     *
     * @param request
     * @return
     */
    public static String getDistinctIdFromCookie(HttpServletRequest request) {
        String jsonStr = CookieUtil.getCookieValue(request, COOKIE_KEY_DISTINCT_ID);
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            jsonStr = URLDecoder.decode(jsonStr, "UTF-8");
        } catch (Exception e) {
            return null;
        }
        JSONObject jo = JSON.parseObject(jsonStr);
        if (StringUtils.isNotBlank(jo.getString(JSON_KEY_FIRST_ID))) {
            return jo.getString(JSON_KEY_FIRST_ID);
        }
        return jo.getString(JSON_KEY_DISTINCT_ID);
    }
}

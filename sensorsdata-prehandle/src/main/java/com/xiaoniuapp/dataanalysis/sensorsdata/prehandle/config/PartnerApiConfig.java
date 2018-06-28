package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.config;

import java.util.Properties;

/**
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class PartnerApiConfig {
    private static Properties apis = new Properties();

    static {
        try {
            apis.load(PartnerApiConfig.class.getResourceAsStream("/partnerapi.properties"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private PartnerApiConfig() {

    }

    public static String getPartnerApi(String projectName) {

        return apis.getProperty(projectName);
    }
}

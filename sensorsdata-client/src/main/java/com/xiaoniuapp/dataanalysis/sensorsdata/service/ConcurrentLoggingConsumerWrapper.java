package com.xiaoniuapp.dataanalysis.sensorsdata.service;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Map;

/**
 * 神策日志消费包装类
 *
 * @author tangdengke
 * @date 2017/11/29
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class ConcurrentLoggingConsumerWrapper extends SensorsAnalytics.ConcurrentLoggingConsumer {

    private Logger logger = LoggerFactory.getLogger(ConcurrentLoggingConsumerWrapper.class);

    /**
     * 是否开启神策日志,默认开始
     */
    @Value("${sensorsdata.enableOutput:true}")
    private boolean enableOutput;

    public ConcurrentLoggingConsumerWrapper(String filenamePrefix) throws IOException {
        super(filenamePrefix);
    }

    public ConcurrentLoggingConsumerWrapper(String filenamePrefix, boolean enableOutput) throws IOException {
        super(filenamePrefix);
        this.enableOutput = enableOutput;
    }

    @Override
    public synchronized void send(Map<String, Object> message) {
        if (!enableOutput) {
            if (logger.isDebugEnabled()) {
                logger.debug("send|不打印神策日志，enableOutput={}", enableOutput);
            }
            return;
        }
        super.send(message);
    }
}

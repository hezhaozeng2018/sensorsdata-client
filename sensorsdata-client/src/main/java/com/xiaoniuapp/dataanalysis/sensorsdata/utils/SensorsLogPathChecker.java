package com.xiaoniuapp.dataanalysis.sensorsdata.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * 神策日志路径检查，如果不存在则自动生成
 *
 * @author tangdengke
 * @date 2017/11/29
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Component
public class SensorsLogPathChecker {

    private Logger logger = LoggerFactory.getLogger(SensorsLogPathChecker.class);

    @Value("${sensorsdata.logPath:default}")
    private String logPath;


    @PostConstruct
    public void check() {
        logger.info("check|开始检查神策日志路径是否配置！");
        if ("default".equals(logPath)) {
            logger.info("check|不需要配置神策日志路径");
            return;
        }

        int lastSlashIdx = logPath.lastIndexOf('/');
        String catalog = logPath.substring(0, lastSlashIdx);
        File file = new File(catalog);
        if (!file.exists()) {
            logger.info("check|神策日志路径不存在，新建");
            if (!file.mkdirs()) {
                logger.error("check|神策日志路径创建失败！");
                throw new IllegalStateException("check|神策日志路径创建失败！");
            }
            logger.info("check|神策日志路径创建成功！");
        }
    }
}

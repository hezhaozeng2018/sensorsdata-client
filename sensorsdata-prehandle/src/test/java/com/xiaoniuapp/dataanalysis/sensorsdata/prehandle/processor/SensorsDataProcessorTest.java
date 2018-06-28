package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.processor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public class SensorsDataProcessorTest {

    private static final Logger logger = LoggerFactory.getLogger(SensorsDataProcessorTest.class);

    SensorsDataProcessor processor = new SensorsDataProcessor();

    @Test
    public void process_UserRegister_Test() throws Exception {
        String str = "{\"time\":1500891144309,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\"," +
                "\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataRegisterClient##userRegister##SensorsDataRegisterClient.java##110\",\"$lib\":\"Java\"},\"distinct_id\":\"df6a0224-6ded-4702-8c40-f9f9d5582ebb\",\"event\":\"userRegister\",\"properties\":{\"regChannel\":\"XXXX_AC\",\"result\":true,\"source\":\"web\",\"keyword\":\"钱罐子\",\"$lib_version\":\"2.0.10\",\"msg\":\"成功\",\"$lib\":\"Java\",\"mobile\":\"13534201090\"},\"type\":\"track\"}";
        String handleStr = processor.process(str);
        System.out.println(handleStr);
        logger.info("process_UserRegister_Test|handleStr={}", handleStr);
    }

    @Test
    public void process_useRateCoupon_Test() throws Exception {
        String str = "{\"time\":1497595678458,\"project\":\"dev_project\",\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataPropClient##useRateCoupon##SensorsDataPropClient.java##131\",\"$lib\":\"Java\"},\"distinct_id\":\"4f528fa2-b622-4c39-9121-fd1d82e3b87f\",\"event\":\"useRateCoupon\",\"properties\":{\"profit\":5,\"validDays\":\"2018-12-01 15:54:43.000\",\"source\":\"web\",\"rateCouponId\":\"5\",\"$lib_version\":\"2.0.10\",\"principalNew\":100,\"finalRate\":\"2.0\",\"investId\":\"fffffa13-ac31-4ed5-a09d-f6002f861dd4\",\"rateDays\":3,\"$lib\":\"Java\",\"investPeriodNew\":90},\"type\":\"track\"}";
        String handleStr = processor.process(str);
        logger.info("process_useRateCoupon_Test|handleStr={}", handleStr);
    }

    @Test
    public void process_investFinish_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\",\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"},\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\",\"properties\":{\"result\":true,\"$lib_version\":\"2.0.10\",\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_oddProfit_string_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs" +
                "/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"}," +
                "\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\",\"properties\":{\"result\":true,\"$lib_version\":\"2.0.10\",\"principalNew\":100.0,\"oddProfit\":\"10.0\",\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_fixedflag_int_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"},\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\",\"properties\":{\"result\":true,\"$lib_version\":\"2.0.10\",\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":1,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_fixedflag_boolean_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\",\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"},\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\",\"properties\":{\"result\":true,\"$lib_version\":\"2.0.10\",\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_annualInvestment_string_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs" +
                "/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"}," +
                "\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\"," +
                "\"properties\":{\"annualInvestment\":\"500.0\",\"result\":true,\"$lib_version\":\"2.0.10\"," +
                "\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_annualInvestment_string_empty_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs" +
                "/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"}," +
                "\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\"," +
                "\"properties\":{\"annualInvestment\":\"\",\"result\":true,\"$lib_version\":\"2.0.10\"," +
                "\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_annualInvestment_double_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs" +
                "/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"}," +
                "\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\"," +
                "\"properties\":{\"annualInvestment\":500.0,\"result\":true,\"$lib_version\":\"2.0.10\"," +
                "\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_totalProfit_string_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs" +
                "/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"}," +
                "\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\"," +
                "\"properties\":{\"totalProfit\":\"500.0\",\"annualInvestment\":\"500.0\",\"result\":true," +
                "\"$lib_version\":\"2.0.10\"," +
                "\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_totalProfit_string_empty_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs" +
                "/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"}," +
                "\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\"," +
                "\"properties\":{\"totalProfit\":\"\",\"annualInvestment\":\"\",\"result\":true,\"$lib_version\":\"2.0.10\"," +
                "\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_totalProfit_double_Test() throws Exception {
        String str = "{\"time\":1498720433396,\"lib\":{\"$lib\":\"LogAgent\",\"$lib_version\":\"1.6.20170511\"," +
                "\"$lib_method\":\"tools\",\"$lib_detail\":\"10.16.15.106.productbuyservice##/data/docker/logs" +
                "/buyproductservice106/logs/sensorlogs/productbuyservice/access.log\"}," +
                "\"distinct_id\":\"17629332-6df2-42cf-927f-be1f5e3697f8\",\"event\":\"investPayFinish\"," +
                "\"properties\":{\"totalProfit\":500.0,\"annualInvestment\":500.0,\"result\":true,\"$lib_version\":\"2.0.10\"," +
                "\"principalNew\":100.0,\"oddProfit\":0.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"76d96952-92a2-431a-96f9-803bf009a1f5\",\"investPeriodNew\":0,\"source\":\"android\",\"finalRate\":\"5.50\",\"fixedFlag\":false,\"investId\":\"6981cbc7-adc9-45a0-8ceb-64976f1cabee\",\"productName\":\"活期宝\"},\"type\":\"track\",\"project\":\"default\",\"la\":{\"f\":\"(dev=801,ino=292087)\",\"o\":56455,\"n\":\"access.log\",\"s\":194,\"c\":194,\"e\":\"LogAgent.20\"},\"ip\":\"218.17.197.10\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investFinish_rateCoupon_Test() throws Exception {
        String str = "{\"time\":1497934100414,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataInvestClient##investPayFinish##SensorsDataInvestClient.java##60\",\"$lib\":\"Java\"},\"distinct_id\":\"62d31647-2ce7-4da7-9812-5b1c8624a83e\",\"event\":\"investPayFinish\",\"properties\":{\"result\":true,\"$lib_version\":\"2.0.10\",\"principalNew\":6000.0,\"oddProfit\":273.0,\"$lib\":\"Java\",\"msg\":\"成功\",\"refundIssue\":1,\"productId\":\"03158f73-ec34-4e07-8ace-9a0024522564\",\"investPeriodNew\":180,\"source\":\"PC\",\"finalRate\":\"9.1\",\"fixedFlag\":true,\"investId\":\"00000cc1-df3e-4dce-bfaf-c4c3ba1901d7\",\"productName\":\"天添牛A款180天期\"},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_investRefund_fixed_Test() throws Exception {
        String str = "{\"time\":1497939927276,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataInvestClient##investRefund##SensorsDataInvestClient.java##117\",\"$lib\":\"Java\"},\"distinct_id\":\"62d31647-2ce7-4da7-9812-5b1c8624a83e\",\"event\":\"investRefund\",\"properties\":{\"source\":\"web\",\"$lib_version\":\"2.0.10\",\"principalNew\":6000.0,\"oddProfit\":273.0,\"investId\":\"00000cc1-df3e-4dce-bfaf-c4c3ba1901d7\",\"productName\":\"天添牛A款180天期\",\"$lib\":\"Java\",\"refundIssue\":1,\"productId\":\"03158f73-ec34-4e07-8ace-9a0024522564\",\"investPeriodNew\":180},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_withdrawRequest_Test() throws Exception {
        String str = "{\"time\":1497944779118,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataAccountClient##withdrawRequest##SensorsDataAccountClient.java##170\",\"$lib\":\"Java\"},\"distinct_id\":\"48ed05f3-360e-4a9d-9bbd-2e72a430ed23\",\"event\":\"withdrawRequest\",\"properties\":{\"amount\":500.0,\"result\":true,\"source\":\"PC\",\"withdrawRequestId\":\"request0001\",\"$lib_version\":\"2.0.10\",\"partner\":\"QGZ\",\"msg\":\"成功\",\"$lib\":\"Java\"},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        System.out.println(handledStr);
    }

    @Test
    public void process_getRedpaper_Test() throws Exception {
        String str = "{\"time\":1497941564718,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataPropClient##getRedpaper##SensorsDataPropClient.java##51\",\"$lib\":\"Java\"},\"distinct_id\":\"eecc12bc-0869-4596-88a3-15327fb2ff39\",\"event\":\"getRedpaper\",\"properties\":{\"amount\":500.0,\"validDays\":\"2017-06-27 14:52:44.718\",\"source\":\"PC\",\"$lib_version\":\"2.0.10\",\"principalNew\":2000.0,\"redpaperId\":\"6c37c59bdce4485f838f1b2fe40bb07a\",\"$lib\":\"Java\",\"investPeriodNew\":29},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_getRedpaper_amount_string_Test() throws Exception {
        String str = "{\"time\":1497941564718,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\"," +
                "\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service" +
                ".SensorsDataPropClient##getRedpaper##SensorsDataPropClient.java##51\",\"$lib\":\"Java\"}," +
                "\"distinct_id\":\"eecc12bc-0869-4596-88a3-15327fb2ff39\",\"event\":\"getRedpaper\"," +
                "\"properties\":{\"amount\":\"500.0\",\"validDays\":\"2017-06-27 14:52:44.718\",\"source\":\"PC\",\"$lib_version\":\"2.0.10\",\"principalNew\":2000.0,\"redpaperId\":\"6c37c59bdce4485f838f1b2fe40bb07a\",\"$lib\":\"Java\",\"investPeriodNew\":29},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_getRedpaper_amount_empty_Test() throws Exception {
        String str = "{\"time\":1497941564718,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataPropClient##getRedpaper##SensorsDataPropClient.java##51\",\"$lib\":\"Java\"},\"distinct_id\":\"eecc12bc-0869-4596-88a3-15327fb2ff39\",\"event\":\"getRedpaper\",\"properties\":{\"amount\":\"\",\"validDays\":\"2017-06-27 14:52:44.718\",\"source\":\"PC\",\"$lib_version\":\"2.0.10\",\"principalNew\":2000.0,\"redpaperId\":\"6c37c59bdce4485f838f1b2fe40bb07a\",\"$lib\":\"Java\",\"investPeriodNew\":29},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_getRateCoupon_Test() throws Exception {
        String str = "{\"time\":1497941801631,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataPropClient##getRateCoupon##SensorsDataPropClient.java##103\",\"$lib\":\"Java\"},\"distinct_id\":\"62d31647-2ce7-4da7-9812-5b1c8624a83e\",\"event\":\"getRateCoupon\",\"properties\":{\"validDays\":\"2017-06-27 14:56:41.631\",\"source\":\"PC\",\"rateCouponId\":\"6744\",\"$lib_version\":\"2.0.10\",\"principalNew\":1000.0,\"finalRate\":\"10.5\",\"rateDays\":5,\"$lib\":\"Java\",\"investPeriodNew\":29},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_getExpCash_Test() throws Exception {
        String str = "{\"time\":1497941983997,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataPropClient##getExpCash##SensorsDataPropClient.java##155\",\"$lib\":\"Java\"},\"distinct_id\":\"0e8b2664-83f5-49de-97a8-4c43c9ebe38f\",\"event\":\"getExpCash\",\"properties\":{\"amount\":10000.0,\"expCashId\":\"5b9eaa43e5b745c192e2aa489f96031f\",\"validDays\":\"2017-06-27 14:59:43.981\",\"source\":\"PC\",\"$lib_version\":\"2.0.10\",\"$lib\":\"Java\",\"productId\":\"cf155c2c09d445ae80388ba93799306c\"},\"type\":\"track\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_investPayClick_Test() throws Exception {
        String str = "{\"distinct_id\":\"15d0b8818e50-04c9b1f9-14794f6a-230400-15d0b8818ea80\"," +
                "\"lib\":{\"$lib\":\"js\",\"$lib_method\":\"code\",\"$lib_version\":\"1.7.8\"},\"properties\":{\"$screen_height\":640,\"$screen_width\":360,\"$lib\":\"js\",\"$lib_version\":\"1.7.8\",\"$latest_referrer\":\"\",\"$latest_referrer_host\":\"\",\"productId\":\"d3480443-a2ec-4085-a10b-bc9c1c098ef5\",\"productName\":\"天添牛Plus92天170704-005\",\"investPeriod\":\"92天\",\"fixedFlag\":1,\"finalRate\":\"7.5%\",\"amount\":\"8500\",\"annualInvestment\":\"65166.66\",\"oddProfit\":165.08,\"couponId\":\"\",\"giftType\":\"\",\"giftAmount\":0,\"totalProfit\":165.08,\"annualRate\":\"0.00%\",\"source\":\"android\",\"$is_first_day\":false},\"type\":\"track\",\"event\":\"investPayClick\",\"_nocache\":\"060438600555062\",\"project\":\"production\",\"ip\":\"112.97.51.159\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_setProfileRefund_Test() throws Exception{
        String str = "{\"time\":1500427641394,\"project\":\"dev_project\",\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataSetProfileClient##refundSetProfile##SensorsDataSetProfileClient.java##224\",\"$lib\":\"Java\"},\"distinct_id\":\"06ca64d1-647a-4cfb-9860-d5964bc7dc61\",\"properties\":{\"profileEvent\":\"setProfileRefund\"},\"type\":\"profile_set\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_setProfileInvest_Test() throws Exception{
        String str = "{\"time\":1500427165462,\"project\":\"dev_project\",\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"2.0.10\",\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataSetProfileClient##investSetProfile##SensorsDataSetProfileClient.java##203\",\"$lib\":\"Java\"},\"distinct_id\":\"06ca64d1-647a-4cfb-9860-d5964bc7dc61\",\"properties\":{\"profileEvent\":\"setProfileInvest\"},\"type\":\"profile_set\"}";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }

    @Test
    public void process_setProfileRegister_Test() {
        String str = "{\"time\":1513823030053,\"lib\":{\"$lib_method\":\"code\",\"$lib_version\":\"3.1.1\"," +
                "\"$lib_detail\":\"com.xiaoniuapp.dataanalysis.sensorsdata.service" +
                ".SensorsDataSetProfileClient##registerSetProfile##SensorsDataSetProfileClient.java##72\"," +
                "\"$lib\":\"Java\"},\"distinct_id\":\"newDistinctId0000010\"," +
                "\"properties\":{\"regChannel\":\"XXXX_bd\",\"referrerMobile\":\"18719041202\",\"bigRegChannel\":\"LCS\"," +
                "\"source\":\"PC\",\"$is_login_id\":true,\"referrerUid\":\"\"," +
                "\"keyword\":\"钱罐子1\",\"profileEvent\":\"setProfileRegister\",\"mobile\":\"18719041201\"}," +
                "\"type\":\"profile_set\",\"project\":\"dev_project\"}\n";
        String handledStr = processor.process(str);
        JSONObject dataJo = JSON.parseObject(handledStr);
        System.out.println(handledStr);
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata;

import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsInvestPayFinishReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataInvestClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Administrator
 * @date 2017/6/8
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:sensorsdata-client-context_test.xml"})
public class SensorsDataInvestClientTest {


    @Autowired
    private SensorsDataInvestClient sensorsDataInvestClient;


    @Test
    public void investFinish_redpaper_Test() {
        SensorsInvestPayFinishReq vo = new SensorsInvestPayFinishReq();
        vo.setResult(true);
        vo.setMsg("成功");
        vo.setSource("PC");
        vo.setDistinctId("eecc12bc-0869-4596-88a3-15327fb2ff39");
        vo.setInvestId("53366777-b176-4130-ab77-e21dee58cb70");
        vo.setProductId("ea3cfc77-cdcd-423a-924e-a571fac92c3e");
        vo.setProductName("天添牛92天期-102701");
        vo.setInvestPeriod(92);
        vo.setFixedFlag(true);
        vo.setRefundIssue(1);
        vo.setFinalRate("9");
        vo.setPrincipal(80000000);
        vo.setOddProfit(2106666);

        sensorsDataInvestClient.investPayFinish(vo);
    }


    @Test
    public void investFinish_rateCoupon_Test() {
        SensorsInvestPayFinishReq vo = new SensorsInvestPayFinishReq();
        vo.setResult(true);
        vo.setMsg("成功");
        vo.setSource("PC");
        vo.setDistinctId("62d31647-2ce7-4da7-9812-5b1c8624a83e");
        vo.setInvestId("00000cc1-df3e-4dce-bfaf-c4c3ba1901d7");
        vo.setProductId("03158f73-ec34-4e07-8ace-9a0024522564");
        vo.setProductName("天添牛A款180天期");
        vo.setInvestPeriod(180);
        vo.setFixedFlag(true);
        vo.setRefundIssue(1);
        vo.setFinalRate("9.1");
        vo.setPrincipal(60000000);
        vo.setOddProfit(2730000);

        sensorsDataInvestClient.investPayFinish(vo);
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata;

import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsWithdrawRequestReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsWithdrawSuccessReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataAccountClient;
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
public class SensorsDataAccountClientTest {


    @Autowired
    private SensorsDataAccountClient sensorsDataAccountClient;


    @Test
    public void withdrawRequest_Test() {
        SensorsWithdrawRequestReq vo = new SensorsWithdrawRequestReq();
        vo.setResult(true);
        vo.setMsg("成功");
        vo.setSource("PC");
        vo.setPartner("QGZ");
        vo.setDistinctId("48ed05f3-360e-4a9d-9bbd-2e72a430ed23");
        vo.setRequestId("request0001");
        vo.setAmount(5000000);

        sensorsDataAccountClient.withdrawRequest(vo);
    }

    @Test
    public void withdrawSuccess_Test() {
        SensorsWithdrawSuccessReq vo = new SensorsWithdrawSuccessReq();
        vo.setSource("PC");
        vo.setDistinctId("48ed05f3-360e-4a9d-9bbd-2e72a430ed23");
        vo.setRequestId("request0001");
        vo.setAmount(5000000);

        sensorsDataAccountClient.withdrawSuccess(vo);
    }

}

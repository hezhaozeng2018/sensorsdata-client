package com.xiaoniuapp.dataanalysis.sensorsdata;

import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsInvestPayFinishReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsUserRegisterReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.GiftTypeEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataInvestClient;
import com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataRegisterClient;
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
public class SensorsDataClientTest {


    @Autowired
    private SensorsDataRegisterClient sensorsDataRegisterClient;
    @Autowired
    private SensorsDataInvestClient sensorsDataInvestClient;

    @Test
    public void userRegister_Test() {

        SensorsUserRegisterReq vo = new SensorsUserRegisterReq();
        vo.setRegChannel("xunlei");
        vo.setSource("PC");
        vo.setMobile("18719041203");
        vo.setKeyword("迅雷金融超市");
        vo.setResult(true);
        vo.setMsg("登录名已存在");
        vo.setDistinctId("distinctId0000009");
        vo.setNewDistinctId("newDistinctId0000009");

        sensorsDataRegisterClient.userRegister(vo);
    }
}

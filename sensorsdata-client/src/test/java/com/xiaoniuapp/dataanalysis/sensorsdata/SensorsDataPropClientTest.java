package com.xiaoniuapp.dataanalysis.sensorsdata;

import com.xiaoniuapp.common.utils.DateUtils;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsGetExpCashReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsGetRateCouponReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsGetRedpaperReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.SensorsWithdrawRequestReq;
import com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataAccountClient;
import com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataPropClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @author Administrator
 * @date 2017/6/8
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:sensorsdata-client-context_test.xml"})
public class SensorsDataPropClientTest {


    @Autowired
    private SensorsDataPropClient sensorsDataPropClient;


    @Test
    public void getRedpaper_Test() {
        SensorsGetRedpaperReq vo = new SensorsGetRedpaperReq();
        vo.setSource("PC");
        vo.setDistinctId("eecc12bc-0869-4596-88a3-15327fb2ff39");
        vo.setRedpaperId("6c37c59bdce4485f838f1b2fe40bb07a");
        vo.setPrincipal(20000000);
        vo.setInvestPeriod(29);
        vo.setValidDays(DateUtils.addDate(new Date(), 7));
        vo.setAmount(5000000);

        sensorsDataPropClient.getRedpaper(vo);
    }


    @Test
    public void getRateCoupon_Test() {
        SensorsGetRateCouponReq vo = new SensorsGetRateCouponReq();
        vo.setSource("PC");
        vo.setDistinctId("62d31647-2ce7-4da7-9812-5b1c8624a83e");
        vo.setRateCouponId("6744");
        vo.setPrincipal(10000000);
        vo.setInvestPeriod(29);
        vo.setValidDays(DateUtils.addDate(new Date(), 7));
        vo.setFinalRate("10.5");
        vo.setRateDays(5);

        sensorsDataPropClient.getRateCoupon(vo);
    }
    @Test
    public void getExpCash_Test() {
        SensorsGetExpCashReq vo = new SensorsGetExpCashReq();
        vo.setSource("PC");
        vo.setDistinctId("0e8b2664-83f5-49de-97a8-4c43c9ebe38f");
        vo.setValidDays(DateUtils.addDate(new Date(), 7));
        vo.setProductId("cf155c2c09d445ae80388ba93799306c");
        vo.setExpCashId("5b9eaa43e5b745c192e2aa489f96031f");
        vo.setAmount(100000000);

        sensorsDataPropClient.getExpCash(vo);
    }

}

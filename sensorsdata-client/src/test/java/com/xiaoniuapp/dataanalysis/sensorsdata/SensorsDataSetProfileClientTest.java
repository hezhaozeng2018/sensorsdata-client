package com.xiaoniuapp.dataanalysis.sensorsdata;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.*;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SalemanTypeEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataUserFieldEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataSetProfileClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2017/7/12
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:sensorsdata-client-context_test.xml"})
public class SensorsDataSetProfileClientTest {

    @Autowired
    private SensorsDataSetProfileClient sensorsDataSetProfileClient;
    @Autowired
    private SensorsAnalytics analytics;

    @Test
    public void feature_override_test() {
        String distinctId = "06ca64d1-647a-4cfb-9860-d5964bc7dc61";
        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_MOBILE.getCode(), "18719041201");
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REG_CHANNEL_BIG.getCode()
                ,"BD");
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_SOURCE.getCode()
                , "PC");
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REG_CHANNEL.getCode()
                , "");
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_SALEMAN_FLAG.getCode(), true);
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_SALEMAN_TYPE.getCode()
                , "内部");
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_AGE.getCode()
                , 34);
        profileMap.put("test", 35);

        try {
            analytics.profileSetOnce(distinctId, false, profileMap);
        } catch (Exception e) {
        }
    }

    @Test
    public void registerSetProfile_noreferrer_Test() {
        SensorsRegisterSetProfileReq req = new SensorsRegisterSetProfileReq();
        req.setDistinctId("newDistinctId0000010");
        req.setKeyword("钱罐子1");
        req.setSource("PC");
        req.setMobile("18719041201");
        req.setRegChannel("AFFDS_bd");
        sensorsDataSetProfileClient.registerSetProfile(req);
    }

    @Test
    public void registerSetProfile_hasreferrer_Test() {
        SensorsRegisterSetProfileReq req = new SensorsRegisterSetProfileReq();
        req.setDistinctId("newDistinctId0000010");
        req.setKeyword("钱罐子1");
        req.setSource("PC");
        req.setMobile("18719041201");
        // req.setReferrerMobile("18719041202");
        req.setReferrerUid("dfd1b102-7ffb-4617-b391-be47b10f8a94");

        req.setRegChannel("XXXX_bd");
        sensorsDataSetProfileClient.registerSetProfile(req);
    }

    @Test
    public void registerSetProfile_allnull_Test() {
        SensorsRegisterSetProfileReq req = new SensorsRegisterSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.registerSetProfile(req);
    }

    @Test
    public void updateReferrerSetProfile_Test() {
        SensorsUpdateReferrerSetProfileReq req = new SensorsUpdateReferrerSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setReferrerMobile("18719041203");
        sensorsDataSetProfileClient.updateReferrerSetProfile(req);
    }
    @Test
    public void updateReferrerSetProfile_allnull_Test() {
        SensorsUpdateReferrerSetProfileReq req = new SensorsUpdateReferrerSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.updateReferrerSetProfile(req);
    }

    @Test
    public void certSetProfile_Test() {
        SensorsCertSetProfileReq req = new SensorsCertSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setName("tdk");
        req.setCertNo("420624198805140095");
        sensorsDataSetProfileClient.certSetProfile(req);
    }

    @Test
    public void certSetProfile_15certno_Test() {
        SensorsCertSetProfileReq req = new SensorsCertSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setName("tdk");
        req.setCertNo("110105710923582");
        sensorsDataSetProfileClient.certSetProfile(req);
    }
    @Test
    public void certSetProfile_illegalCertNo_Test() {
        SensorsCertSetProfileReq req = new SensorsCertSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setName("tdk");
        req.setCertNo("2222");
        sensorsDataSetProfileClient.certSetProfile(req);
    }
    @Test
    public void certSetProfile_allnull_Test() {
        SensorsCertSetProfileReq req = new SensorsCertSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.certSetProfile(req);
    }

    @Test
    public void bindCardSetProfile_Test() {
        SensorsBindCardSetProfileReq req = new SensorsBindCardSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setBankName("平安银行");
        sensorsDataSetProfileClient.bindCardSetProfile(req);
    }
    @Test
    public void bindCardSetProfile_allnull_Test() {
        SensorsBindCardSetProfileReq req = new SensorsBindCardSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.bindCardSetProfile(req);
    }

    @Test
    public void updateLevelSetProfile_Test() {
        SensorsUpdateLevelSetProfileReq req = new SensorsUpdateLevelSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setMemberLevel("青铜");
        sensorsDataSetProfileClient.updateLevelSetProfile(req);
    }
    @Test
    public void updateLevelSetProfile_allnull_Test() {
        SensorsUpdateLevelSetProfileReq req = new SensorsUpdateLevelSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.updateLevelSetProfile(req);
    }


    @Test
    public void updateSalemanSetProfile_is_Test() {
        SensorsUpdateSalemanSetProfileReq req = new SensorsUpdateSalemanSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setSalemanFlag(true);
        req.setSalemanType(SalemanTypeEnum.INNER);
        sensorsDataSetProfileClient.updateSalemanSetProfile(req);
    }

    @Test
    public void updateSalemanSetProfile_isnot_Test() {
        SensorsUpdateSalemanSetProfileReq req = new SensorsUpdateSalemanSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        req.setSalemanFlag(false);
        sensorsDataSetProfileClient.updateSalemanSetProfile(req);
    }
    @Test
    public void updateSalemanSetProfile_allnull_Test() {
        SensorsUpdateSalemanSetProfileReq req = new SensorsUpdateSalemanSetProfileReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.updateSalemanSetProfile(req);
    }


    @Test
    public void investSetProfile_Test() {
        SensorsBaseReq req = new SensorsBaseReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.investSetProfile(req);
    }
    @Test
    public void refundSetProfile_Test() {
        SensorsBaseReq req = new SensorsBaseReq();
        req.setDistinctId("06ca64d1-647a-4cfb-9860-d5964bc7dc61");
        sensorsDataSetProfileClient.refundSetProfile(req);
    }
}

package com.xiaoniuapp.dataanalysis.sensorsdata.service;

import com.sensorsdata.analytics.javasdk.SensorsAnalytics;
import com.xiaoniuapp.common.enums.Gender;
import com.xiaoniuapp.common.utils.DateUtils;
import com.xiaoniuapp.common.utils.IdentityCardUtils;
import com.xiaoniuapp.dataanalysis.sensorsdata.domain.request.*;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataEventEnum;
import com.xiaoniuapp.dataanalysis.sensorsdata.enums.SensorsDataUserFieldEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 神策分析数据接入接口-注册相关接口
 *
 * @author tangdengke
 * @date 2017/6/6
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
@Service
public class SensorsDataSetProfileClient {


    private Logger logger = LoggerFactory.getLogger(SensorsDataSetProfileClient.class);

    private static final String BIG_REG_CHANNEL_LCS = "LCS";

    private static final String BIG_REG_CHANNEL_SP = "SP";

    private static final String BIG_REG_CHANNEL_BD = "BD";

    private static final String BIG_REG_CHANNEL_SF = "SF";

    private static final String BIG_REG_CHANNEL_AC = "AC";

    private static final String BIG_REG_CHANNEL_NA = "NA";

    @Autowired
    private SensorsAnalytics sensorsAnalytics;

    public void registerSetProfile(SensorsRegisterSetProfileReq req) {
        if (StringUtils.isBlank(req.getDistinctId())) {
            logger.warn("registerSetProfile|注册设置profile参数错误，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_MOBILE.getCode(), req.getMobile());
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REG_CHANNEL_BIG.getCode(),
                this.determineBigRegChannel(req));
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_SOURCE.getCode(),
                req.getSource() == null ? "" : req.getSource());
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REG_CHANNEL.getCode(),
                req.getRegChannel() == null ? "" : req.getRegChannel());
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_KEYWORD.getCode(),
                req.getKeyword() == null ? "" : req.getKeyword());
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_MOBILE.getCode(),
                req.getReferrerMobile() == null ? "" : req.getReferrerMobile());
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_UID.getCode(),
                req.getReferrerUid() == null ? "" : req.getReferrerUid());
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_EVENT.getCode()
                , SensorsDataEventEnum.SET_PROFILE_REGISTER.getCode());

        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("registerSetProfile|注册设置profile写神策日志异常,req={}", req, e);
        }
    }

    public void updateReferrerSetProfile(SensorsUpdateReferrerSetProfileReq req) {
        if (StringUtils.isBlank(req.getDistinctId())
                || StringUtils.isBlank(req.getReferrerMobile())) {
            logger.warn("updateReferrerSetProfile|更新推荐人设置profile写神策日志异常，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_REFERRER_MOBILE.getCode(),
                req.getReferrerMobile());
        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("updateReferrerSetProfile|更新推荐人设置profile写神策日志异常,req={}", req, e);
        }
    }

    /**
     * 用户绑卡后设置profile
     *
     * @param req
     */
    public void bindCardSetProfile(SensorsBindCardSetProfileReq req) {
        if (StringUtils.isBlank(req.getDistinctId())
                || StringUtils.isBlank(req.getBankName())) {
            logger.warn("bindCardSetProfile|绑卡设置profile参数错误，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_BANKNAME.getCode(), req.getBankName());
        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("bindCardSetProfile|绑卡设置profile写神策日志异常,req={}", req, e);
        }

    }

    /**
     * 用户实名认证后设置profile
     *
     * @param req
     */
    public void certSetProfile(SensorsCertSetProfileReq req) {
        if (StringUtils.isBlank(req.getDistinctId())
                || StringUtils.isBlank(req.getName())
                || StringUtils.isBlank(req.getCertNo())) {
            logger.warn("certSetProfile|实名认证设置profile参数错误，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_NAME.getCode(), req.getName());
        String certNo = req.getCertNo();
        String birthdayStr = IdentityCardUtils.extractBirthday(certNo);
        if (StringUtils.isNotBlank(birthdayStr)) {
            int birthdayYear = Integer.parseInt(birthdayStr.substring(0, 4));
            int age = Integer.parseInt(DateUtils.format(new Date(), "yyyy")) - birthdayYear;
            profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_AGE.getCode(), age);
        }
        Integer gender = IdentityCardUtils.extractGender(certNo);
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_GENDER.getCode(),
                Gender.findByIndex(gender).getDescription());
        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("certSetProfile|实名认证设置profile写神策日志异常,req={}", req, e);
        }

    }

    /**
     * 用户级别更新后设置profile
     *
     * @param req
     */
    public void updateLevelSetProfile(SensorsUpdateLevelSetProfileReq req) {
        if (StringUtils.isBlank(req.getDistinctId())
                || StringUtils.isBlank(req.getMemberLevel())) {
            logger.warn("updateLevelSetProfile|用户级别更新设置profile参数错误，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_MEMBER_LEVEL.getCode(), req.getMemberLevel());
        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("updateLevelSetProfile|用户级别更新设置profile写神策日志异常,req={}", req, e);
        }
    }

    /**
     * 理财师类别更新后设置profile
     *
     * @param req
     */
    public void updateSalemanSetProfile(SensorsUpdateSalemanSetProfileReq req) {
        if (StringUtils.isBlank(req.getDistinctId())) {
            logger.warn("updateSalemanSetProfile|理财师类别更新设置profile参数错误，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_SALEMAN_FLAG.getCode(), req.getSalemanFlag());
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_SALEMAN_TYPE.getCode()
                , req.getSalemanType() == null ? "" : req.getSalemanType().getName());
        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("updateSalemanSetProfile|理财师类别更新设置profile写神策日志异常,req={}", req, e);
        }
    }

    /**
     * 用户投资后设置profile
     *
     * @param req
     */
    public void investSetProfile(SensorsBaseReq req) {
        if (StringUtils.isBlank(req.getDistinctId())) {
            logger.warn("investSetProfile|用户投资后设置profile参数错误，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_EVENT.getCode()
                , SensorsDataEventEnum.SET_PROFILE_INVEST.getCode());
        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("investSetProfile|用户投资后设置profile写神策日志异常,req={}", req, e);
        }
    }

    /**
     * 用户回款后设置profile
     *
     * @param req
     */
    public void refundSetProfile(SensorsBaseReq req) {
        if (StringUtils.isBlank(req.getDistinctId())) {
            logger.warn("refundSetProfile|用户回款后设置profile参数错误，req={}", req);
            return;
        }

        Map<String, Object> profileMap = new HashMap<>();
        profileMap.put(SensorsDataUserFieldEnum.NODE_NAME_PROPERTIES_EVENT.getCode()
                , SensorsDataEventEnum.SET_PROFILE_REFUND.getCode());
        try {
            sensorsAnalytics.profileSet(req.getDistinctId(), true, profileMap);
        } catch (Exception e) {
            logger.warn("refundSetProfile|用户回款后设置profile写神策日志异常,req={}", req, e);
        }
    }

    private String determineBigRegChannel(SensorsRegisterSetProfileReq req) {
        if (StringUtils.isNotBlank(req.getReferrerMobile()) || StringUtils.isNotBlank(req.getReferrerUid())) {
            return BIG_REG_CHANNEL_LCS;
        }

        String regChannel = req.getRegChannel();
        if (StringUtils.isNotBlank(regChannel)) {
            final String prefix = "_";
            String regChannelTmp = regChannel.toUpperCase();
            if (regChannelTmp.contains(prefix + BIG_REG_CHANNEL_SP)) {
                return BIG_REG_CHANNEL_SP;
            } else if (regChannelTmp.contains(prefix + BIG_REG_CHANNEL_BD)) {
                return BIG_REG_CHANNEL_BD;
            } else if (regChannelTmp.contains(prefix + BIG_REG_CHANNEL_SF)) {
                return BIG_REG_CHANNEL_SF;
            } else if (regChannelTmp.contains(prefix + BIG_REG_CHANNEL_AC)) {
                return BIG_REG_CHANNEL_AC;
            }
        }
        return BIG_REG_CHANNEL_NA;
    }
}

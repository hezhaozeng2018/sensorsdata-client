package com.xiaoniuapp.dataanalysis.sensorsdata.enums;

import com.xiaoniuapp.common.domain.BaseEnum;

/**
 * @author Administrator
 * @date 2017/6/12
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public enum GiftTypeEnum implements BaseEnum {

    RATE_COUPON(1, "红包"),
    RED_PAPER(2, "加息券"),
    EXP_CASH(3, "理财金");


    private int index;

    private String name;


    GiftTypeEnum() {

    }

    GiftTypeEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return name;
    }

    /**
     * 返回枚举的名称
     *
     * @return
     */
    public String getName() {
        return name;
    }
}

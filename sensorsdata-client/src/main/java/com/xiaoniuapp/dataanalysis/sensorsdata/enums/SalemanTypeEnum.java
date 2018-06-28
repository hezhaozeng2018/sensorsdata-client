package com.xiaoniuapp.dataanalysis.sensorsdata.enums;

import com.xiaoniuapp.common.domain.BaseEnum;

/**
 * @author Administrator
 * @date 2017/6/12
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public enum SalemanTypeEnum implements BaseEnum {

    OUTER(1, "外部"),
    INNER(2, "内部");


    private int index;

    private String name;


    SalemanTypeEnum() {

    }

    SalemanTypeEnum(int index, String name) {
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

package com.xiaoniuapp.dataanalysis.sensorsdata.prehandle.prehandler;

/**
 * 预处理器的接口定义
 *
 * @author tangdengke
 * @date 2017/6/17
 * @copyright www.xiaoniuapp.com Inc. All rights reserved.
 */
public interface IPrehandler {

    /**
     * 对输入的数据进行预处理，处理失败返回null<br/>
     * data数据格式：<br/>
     * <pre>
     * {
     *     "time":1497836946947,
     *     "lib":
     *     {
     *        "$lib_method":"code","$lib_version":"2.0.10","$lib_detail":"com.xiaoniuapp.dataanalysis.sensorsdata.service.SensorsDataPointClient##getPoint##SensorsDataPointClient.java##50","$lib":"Java"
     *     },
     *     "distinct_id":"161164da-e699-4608-98df-f66f253fd3d3",
     *     "event":"getPoint",
     *     "properties":
     *     {
     *        "totalPointNum":30,"source":"test","remark":"竞猜赢得积分","$lib_version":"2.0.10","businessType":"10","pointNum":10,"$lib":"Java"
     *     },
     *     "type":"track"
     * }
     * </pre>
     * 其中，distinct_id为用户唯一标识，登录后为用户id；properties为上传的各个事件的属性
     * @param data
     * @return
     */
    String handle(String data);
}

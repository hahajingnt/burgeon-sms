package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
@Slf4j
public class BaseSmsReqDTO {

    @JSONField(name = "sign")
    private String sign;

    /**
     * 集团号
     */
    @JSONField(name = "group_id")
    private String groupId;

    @JSONField(name = "timestamp")
    private String timestamp;

    @JSONField(name = "cus_no")
    private String cusNo;

    /**
     * 使用的渠道
     */
    @JSONField(name = "sms_channel")
    private String smsChannel;

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}

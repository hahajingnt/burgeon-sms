package com.jackrain.nea.httpsms.modelvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class BaseSmsRespVO {

    /**
     * 参考枚举StatusCode
     */
    @JSONField(name = "status_code")
    private String statusCode;

    @JSONField(name = "err_msg")
    private String errMsg;

    /**
     * 使用的渠道
     */
    @JSONField(name = "sms_channel")
    private String smsChannel;

    public String toJSONString(){
       return JSON.toJSONString(this);
   }

}

package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class CustomSendSmsReqDTO extends BaseSmsReqDTO {

    /**
     * 接收短信的手机号码 逗号分隔
     */
    @JSONField(name = "phone_numbers")
    private String phoneNumbers;

    /**
     * 短信内容 需包含签名名称 eg【xxx】
     */
    @JSONField(name = "content")
    private String content;

    /**
     * 发送时间 格式yyyy-MM-dd HH:mm:ss
     */
    @JSONField(name = "time")
    private String time;

    /**
     * 扩展号
     * 助通 纯数字，最多8位。
     */
    @JSONField(name = "ext")
    private Integer ext;

    /**
     * 用户自定义信息 在用户获取状态报告时返回
     */
    @JSONField(name = "extend")
    private String extend;

    @JSONField(name = "sms_type")
    private String smsType;

}

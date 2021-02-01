package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class SendSmsReqDTO extends BaseSmsReqDTO {

    /**
     * 接收短信的手机号码 逗号分隔
     */
    @JSONField(name = "phone_numbers")
    private String phoneNumbers;

    /**
     * 短信签名平台code
     */
    @JSONField(name = "platform_sign_code")
    private String platformSignCode;

    /**
     * 短信模板平台code
     */
    @JSONField(name = "platform_template_code")
    private String platformTemplateCode;

    /**
     * 外部流水扩展字段
     */
    @JSONField(name = "out_id")
    private String outId;

    /**
     * 上行短信扩展码
     */
    @JSONField(name = "sms_up_extend_code")
    private String smsUpExtendCode;

    /**
     * 短信模板变量对应的实际值 json格式
     */
    @JSONField(name = "template_param")
    private String templateParam;

    @JSONField(name = "template_code")
    private String templateCode;

    /**
     * 短信渠道
     */
    @JSONField(name = "sms_channel")
    private String smsChannel;

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

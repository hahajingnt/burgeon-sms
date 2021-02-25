package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class SendBatchSmsReqDTO extends BaseSmsReqDTO {

    /**
     * 接收短信的手机号码 json数组格式
     */
    @JSONField(name = "phone_numbers_json")
    private String phoneNumbersJson;

    /**
     * 短信签名code
     */
    @JSONField(name = "platform_sign_code_json")
    private String platformSignCodeJson;

    /**
     * 短信模板平台code
     */
    @JSONField(name = "platform_template_code")
    private String platformTemplateCode;

    /**
     * 上行短信扩展码
     */
    @JSONField(name = "sms_up_extend_code")
    private String smsUpExtendCode;

    /**
     * 短信模板变量对应的实际值 json数组格式
     */
    @JSONField(name = "template_param_json")
    private String templateParamJson;

    /**
     * 是否记账 Y或者N
     */
    @JSONField(name = "books")
    private String books;

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

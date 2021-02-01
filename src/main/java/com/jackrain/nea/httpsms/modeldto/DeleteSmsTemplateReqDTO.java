package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class DeleteSmsTemplateReqDTO extends BaseSmsReqDTO {

    /**
     * 短信模板CODE,平台唯一编码
     */
    @JSONField(name = "platform_template_code")
    private String platformTemplateCode;

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class ModifySmsTemplateReqDTO extends BaseSmsReqDTO {

    /**
     * 平台模板code
     */
    @JSONField(name = "platform_template_code")
    private String platformTemplateCode;

    /**
     *  签名编号 非必填 助通渠道需要
     */
    @JSONField(name = "platform_sign_code")
    private String platformSignCode;

    /**
     * 短信类型
     * 0--验证码
     * 1--短信通知
     * 2--推广短信
     * 3--国际/港澳台消息
     */
    @JSONField(name = "template_type")
    private String templateType;

    /**
     * 模板名称
     */
    @JSONField(name = "template_name")
    private String templateName;

    /**
     * 模板内容
     */
    @JSONField(name = "template_content")
    private String templateContent;

    /**
     * 短信模板申请说明
     */
    @JSONField(name = "remark")
    private String remark;

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

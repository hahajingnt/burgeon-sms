package com.jackrain.nea.httpsms.modelvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class QuerySmsTemplateRespVO extends BaseSmsRespVO {

    @JSONField(name = "response")
    private ResponseEntity response;

    @Data
    public class ResponseEntity {

        /**
         * 结果状态码
         */
        @JSONField(name = "result_code")
        private String resultCode;

        /**
         * 错误状态码
         */
        @JSONField(name = "err_code")
        private String errCode;

        /**
         * 错误信息
         */
        @JSONField(name = "err_msg")
        private String errMsg;

        /**
         * 请求ID
         */
        @JSONField(name = "request_id")
        private String requestId;

        /**
         * 短信模板CODE
         */
        @JSONField(name = "template_code")
        private String templateCode;

        /**
         * 短信模板的创建日期和时间
         */
        @JSONField(name = "create_date")
        private String createDate;

        /**
         * 审核备注
         */
        @JSONField(name = "reason")
        private String reason;

        /**
         * 模板内容
         */
        @JSONField(name = "template_content")
        private String templateContent;

        /**
         * 模板名称
         */
        @JSONField(name = "template_name")
        private String templateName;

        /**
         * 模板审核状态
         * 0--审核中
         * 1--审核通过
         * 2--审核失败
         */
        @JSONField(name = "template_status")
        private String templateStatus;

        /**
         * 短信类型
         * 0--验证码
         * 1--短信通知
         * 2--推广短信
         * 3--国际/港澳台消息
         */
        @JSONField(name = "template_type")
        private String templateType;
    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

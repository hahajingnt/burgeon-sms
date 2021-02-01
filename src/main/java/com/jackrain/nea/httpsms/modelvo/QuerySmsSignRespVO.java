package com.jackrain.nea.httpsms.modelvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class QuerySmsSignRespVO extends BaseSmsRespVO {

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
         * 审核备注
         */
        @JSONField(name = "reason")
        private String reason;

        /**
         * 签名审核状态
         * 0--审核中
         * 1--审核通过
         * 2--审核失败
         */
        @JSONField(name = "sign_status")
        private String signStatus;

        /**
         * 短信签名
         */
        @JSONField(name = "sign_name")
        private String signName;

        /**
         * 请求ID
         */
        @JSONField(name = "request_id")
        private String requestId;

        /**
         * 短信签名的创建日期和时间
         */
        @JSONField(name = "create_date")
        private String createDate;

    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

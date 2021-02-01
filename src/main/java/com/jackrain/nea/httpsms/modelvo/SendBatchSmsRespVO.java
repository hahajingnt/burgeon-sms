package com.jackrain.nea.httpsms.modelvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class SendBatchSmsRespVO extends BaseSmsRespVO {
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
         * 发送回执ID
         */
        @JSONField(name = "biz_id")
        private String bizId;

        /**
         * 请求ID
         */
        @JSONField(name = "request_id")
        private String requestId;

    }

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

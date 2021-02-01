package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class QuerySmsSignReqDTO extends BaseSmsReqDTO {

    /**
     * 签名全局唯一code
     */
    @JSONField(name = "platform_sign_code")
    private String platformSignCode;

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

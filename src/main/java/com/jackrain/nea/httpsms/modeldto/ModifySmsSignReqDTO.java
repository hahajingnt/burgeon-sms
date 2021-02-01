package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 14:54
 */
@Data
public class ModifySmsSignReqDTO extends BaseSmsReqDTO {
    /**
     * 签名全局唯一code
     */
    @JSONField(name = "platform_sign_code")
    private String platformSignCode;

    /**
     * 签名名称
     */
    @JSONField(name = "sign_name")
    private String signName;

    /**
     * 签名来源
     */
    @JSONField(name = "sign_source")
    private String signSource;

    /**
     * 短信签名申请说明
     */
    @JSONField(name = "remark")
    private String remark;

    /**
     * 签名文件
     * [{"fileSuffix":"","fileContents":""}]
     * [{签名的证明文件格式,签名的证明文件格式}]
     * fileSuffix当前支持jpg、png、gif、jpeg
     * fileContents不超过2MB
     */
    @JSONField(name = "sign_file")
    private JSONArray signFile;

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

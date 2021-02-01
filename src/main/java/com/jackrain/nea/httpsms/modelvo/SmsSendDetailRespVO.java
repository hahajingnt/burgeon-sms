package com.jackrain.nea.httpsms.modelvo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/11/4 15:36
 */
@Data
public class SmsSendDetailRespVO {

    /**
     * 短信内容
     */
    @JSONField(name = "content")
    private String content;

    /**
     * 运营商短信状态码
     */
    @JSONField(name = "err_code")
    private String errCode;

    /**
     * 外部流水扩展字段
     */
    @JSONField(name = "out_id")
    private String outId;

    /**
     * 接收短信的手机号码
     */
    @JSONField(name = "phone_num")
    private String phoneNum;

    /**
     * 短信接收日期和时间
     */
    @JSONField(name = "receive_date")
    private String receiveDate;

    /**
     * 短信发送日期和时间
     */
    @JSONField(name = "send_date")
    private String sendDate;

    /**
     * 短信发送状态
     * 1--等待回执
     * 2--发送失败
     * 3--发送成功
     */
    @JSONField(name = "send_status")
    private Long sendStatus;

    /**
     * 短信模板ID
     */
    @JSONField(name = "template_code")
    private String templateCode;

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}

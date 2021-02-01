package com.jackrain.nea.httpsms.modeldto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @Author:lin.jh
 * @Date:2020/10/29 15:39
 */
@Data
public class QuerySendDetailsReqDTO extends BaseSmsReqDTO {

    /**
     * 指定发送记录的的当前页码
     */
    @JSONField(name = "current_page")
    private Long currentPage;

    /**
     * 指定每页显示的短信记录数量
     */
    @JSONField(name = "page_size")
    private Long pageSize;

    /**
     * 接收短信的手机号码
     */
    @JSONField(name = "phone_number")
    private String phoneNumber;

    /**
     * 短信发送日期 yyyyMMdd
     */
    @JSONField(name = "send_date")
    private String sendDate;

    /**
     * 发送流水号
     */
    @JSONField(name = "biz_id")
    private String bizId;

    @Override
    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

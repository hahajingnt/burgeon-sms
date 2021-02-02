package com.jackrain.nea.httpsms.api;

import com.jackrain.nea.httpsms.modeldto.*;
import com.jackrain.nea.httpsms.modelvo.*;

public interface SmsApi {
    /**
     * 查询发送详情信息
     *
     * @param querySendDetailsReqDTO
     * @return
     */
    QuerySendDetailsRespVO querySendDetails(QuerySendDetailsReqDTO querySendDetailsReqDTO) throws Exception;

    /**
     * 单条发送短信
     *
     * @param sendSmsReqDTO
     * @return
     */
    SendSmsRespVO sendSms(SendSmsReqDTO sendSmsReqDTO) throws Exception;

    /**
     * 批量发送短信
     *
     * @param sendBatchSmsReqDTO
     * @return
     */
    SendBatchSmsRespVO sendBatchSms(SendBatchSmsReqDTO sendBatchSmsReqDTO) throws Exception;

    /**
     * 自定义短信发送
     *
     * @param customSendSmsReqDTO
     * @return
     */
     CustomSendSmsRespVO customSendSms(CustomSendSmsReqDTO customSendSmsReqDTO) throws Exception;

    /**
     * 新增模板
     *
     * @param addSmsTemplateReqDTO
     * @return
     */
    AddSmsTemplateRespVO addSmsTemplate(AddSmsTemplateReqDTO addSmsTemplateReqDTO) throws Exception;

    /**
     * 更新模板
     *
     * @param modifySmsTemplateReqDTO
     * @return
     */
    ModifySmsTemplateRespVO modifySmsTemplate(ModifySmsTemplateReqDTO modifySmsTemplateReqDTO) throws Exception;

    /**
     * 查询模板
     *
     * @param querySmsTemplateReqDTO
     * @return
     */
    QuerySmsTemplateRespVO querySmsTemplate(QuerySmsTemplateReqDTO querySmsTemplateReqDTO) throws Exception;

    /**
     * 删除模板
     *
     * @param deleteSmsTemplateReqDTO
     * @return
     */
    DeleteSmsTemplateRespVO deleteSmsTemplate(DeleteSmsTemplateReqDTO deleteSmsTemplateReqDTO) throws Exception;

    /**
     * 添加签名
     *
     * @param addSmsSignReqDTO
     * @return
     */
    AddSmsSignRespVO addSmsSign(AddSmsSignReqDTO addSmsSignReqDTO) throws Exception;

    /**
     * 修改签名
     *
     * @param modifySmsSignReqDTO
     * @return
     */
    ModifySmsSignRespVO modifySmsSign(ModifySmsSignReqDTO modifySmsSignReqDTO) throws Exception;

    /**
     * 查询签名
     *
     * @param querySmsSignReqDTO
     * @return
     */
    QuerySmsSignRespVO querySmsSign(QuerySmsSignReqDTO querySmsSignReqDTO) throws Exception;

    /**
     * 删除签名
     *
     * @param deleteSmsSignReqDTO
     * @return
     */
    DeleteSmsSignRespVO deleteSmsSign(DeleteSmsSignReqDTO deleteSmsSignReqDTO) throws Exception;

}

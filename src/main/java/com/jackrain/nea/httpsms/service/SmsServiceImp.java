package com.jackrain.nea.httpsms.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.nea.httpsms.api.SmsApi;
import com.jackrain.nea.httpsms.config.RestTemplateIn;
import com.jackrain.nea.httpsms.modeldto.*;
import com.jackrain.nea.httpsms.modelvo.*;
import com.jackrain.nea.httpsms.util.Constant;
import com.jackrain.nea.httpsms.util.RestTemplateUtil;
import com.jackrain.nea.httpsms.util.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URLEncoder;

@Component
@Slf4j
public class SmsServiceImp implements SmsApi {

    @Value("${r3.sms.url}")
    private String baseUrl;

    private final RestTemplateUtil restTemplateUtil;

    public SmsServiceImp(RestTemplateUtil restTemplateUtil) {
        this.restTemplateUtil = restTemplateUtil;
    }

    @Override
    public QuerySendDetailsRespVO querySendDetails(QuerySendDetailsReqDTO querySendDetailsReqDTO) throws Exception{
        JSONObject jsonObject = JSONObject.parseObject(querySendDetailsReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        querySendDetailsReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_querySendDetails,jsonObject.toJSONString());
        return JSON.parseObject(result,QuerySendDetailsRespVO.class);
    }

    @Override
    public SendSmsRespVO sendSms(SendSmsReqDTO sendSmsReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(sendSmsReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        sendSmsReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_sendSms,sendSmsReqDTO.toJSONString());
        return JSON.parseObject(result,SendSmsRespVO.class);
    }

    @Override
    public SendBatchSmsRespVO sendBatchSms(SendBatchSmsReqDTO sendBatchSmsReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(sendBatchSmsReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        sendBatchSmsReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_sendBatchSms,jsonObject.toJSONString());
        return JSON.parseObject(result,SendBatchSmsRespVO.class);
    }

    @Override
    public CustomSendSmsRespVO customSendSms(CustomSendSmsReqDTO customSendSmsReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(customSendSmsReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        customSendSmsReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_customSendSms,jsonObject.toJSONString());
        return JSON.parseObject(result,CustomSendSmsRespVO.class);
    }

    @Override
    public AddSmsTemplateRespVO addSmsTemplate(AddSmsTemplateReqDTO addSmsTemplateReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(addSmsTemplateReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        addSmsTemplateReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_addSmsTemplate,jsonObject.toJSONString());
        return JSON.parseObject(result,AddSmsTemplateRespVO.class);
    }

    @Override
    public ModifySmsTemplateRespVO modifySmsTemplate(ModifySmsTemplateReqDTO modifySmsTemplateReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(modifySmsTemplateReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        modifySmsTemplateReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_modifySmsTemplate,jsonObject.toJSONString());
        return JSON.parseObject(result,ModifySmsTemplateRespVO.class);
    }

    @Override
    public QuerySmsTemplateRespVO querySmsTemplate(QuerySmsTemplateReqDTO querySmsTemplateReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(querySmsTemplateReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        querySmsTemplateReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_querySmsTemplate,jsonObject.toJSONString());
        return JSON.parseObject(result,QuerySmsTemplateRespVO.class);
    }

    @Override
    public DeleteSmsTemplateRespVO deleteSmsTemplate(DeleteSmsTemplateReqDTO deleteSmsTemplateReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(deleteSmsTemplateReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        deleteSmsTemplateReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_deleteSmsTemplate,jsonObject.toJSONString());
        return JSON.parseObject(result,DeleteSmsTemplateRespVO.class);
    }

    @Override
    public AddSmsSignRespVO addSmsSign(AddSmsSignReqDTO addSmsSignReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(addSmsSignReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        addSmsSignReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_addSmsSign,jsonObject.toJSONString());
        return JSON.parseObject(result,AddSmsSignRespVO.class);
    }

    @Override
    public ModifySmsSignRespVO modifySmsSign(ModifySmsSignReqDTO modifySmsSignReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(modifySmsSignReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        modifySmsSignReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_modifySmsSign,jsonObject.toJSONString());
        return JSON.parseObject(result,ModifySmsSignRespVO.class);
    }

    @Override
    public QuerySmsSignRespVO querySmsSign(QuerySmsSignReqDTO querySmsSignReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(querySmsSignReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        querySmsSignReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_querySmsSign,jsonObject.toJSONString());
        return JSON.parseObject(result,QuerySmsSignRespVO.class);
    }

    @Override
    public DeleteSmsSignRespVO deleteSmsSign(DeleteSmsSignReqDTO deleteSmsSignReqDTO) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(deleteSmsSignReqDTO.toJSONString());
        String sign = putSign(jsonObject);
        deleteSmsSignReqDTO.setSign(sign);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_deleteSmsSign,jsonObject.toJSONString());
        return JSON.parseObject(result,DeleteSmsSignRespVO.class);
    }

    /**
     * 获取sign
     * @param jsonObject
     * @throws Exception
     */
    private String putSign(JSONObject jsonObject) throws Exception{
        String developKey = jsonObject.getString("developKey");
        jsonObject.remove("developKey");
        String sign = null;
        sign = SignUtils.getSign(jsonObject,developKey);

        jsonObject.put("sign",sign);
        return sign;
    }

}

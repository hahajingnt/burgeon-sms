package com.jackrain.nea.httpsms.api;

import com.alibaba.fastjson.JSONObject;
import com.jackrain.nea.httpsms.util.Constant;
import com.jackrain.nea.httpsms.util.RestTemplateUtil;
import com.jackrain.nea.httpsms.util.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsDemo {

    @Value("${r3.sms.url}")
    private String baseUrl;

    private final RestTemplateUtil restTemplateUtil;

    public SmsDemo(RestTemplateUtil restTemplateUtil) {
        this.restTemplateUtil = restTemplateUtil;
    }

    /**
     * 查询发送详情信息
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject querySendDetails(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_querySendDetails,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 单条发送短信
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject sendSms(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_sendSms,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 批量发送短信
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject sendBatchSms(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_sendBatchSms,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 自定义短信发送
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject customSendSms(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_customSendSms,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }


    /**
     * 新增模板
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject addSmsTemplate(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_addSmsTemplate,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 更新模板
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject modifySmsTemplate(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_modifySmsTemplate,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 查询模板
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject querySmsTemplate(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_querySmsTemplate,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 删除模板
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject deleteSmsTemplate(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_deleteSmsTemplate,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 添加签名
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject addSmsSign(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_addSmsSign,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 修改签名
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject modifySmsSign(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_modifySmsSign,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 查询签名
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject querySmsSign(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_querySmsSign,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 删除签名
     * @param jsonObject
     * @return
     * @throws Exception
     */
    public JSONObject deleteSmsSign(JSONObject jsonObject) throws Exception {
        putSign(jsonObject);
        String result = restTemplateUtil.doPostApi(baseUrl + Constant.SMS_deleteSmsSign,jsonObject.toJSONString());
        return JSONObject.parseObject(result);
    }

    /**
     * 获取sign
     * @param jsonObject
     * @throws Exception
     */
    private void putSign(JSONObject jsonObject) throws Exception{
        String developKey = jsonObject.getString("developKey");
        jsonObject.remove("developKey");
        String sign = SignUtils.getSign(jsonObject,developKey);
        jsonObject.put("sign",sign);
    }
}

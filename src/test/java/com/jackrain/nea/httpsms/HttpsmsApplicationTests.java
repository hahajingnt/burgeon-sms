package com.jackrain.nea.httpsms;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jackrain.nea.httpsms.api.SmsDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpsmsApplication.class)
class HttpsmsApplicationTests {

    @Autowired
    private SmsDemo smsDemo;

    private final static String developKey = "hdghfjdydbdnj7s6sghj";

    @Test
    void contextLoads() {
    }

    @Test
    void querySendDetails() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone_number","15951815424"); //需查询的手机号
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("send_date","20201215");  //需查询的发送日期
        jsonObject.put("page_size",10);  //分页参数
        jsonObject.put("current_page",1); //分页参数
        jsonObject.put("developKey",developKey);  //签名用的key
        JSONObject jsonResult = smsDemo.querySendDetails(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void sendSms() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone_numbers","15951815424"); //发送的手机号
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("platform_sign_code","SIGN_2012251879581011"); //签名名称
        jsonObject.put("platform_template_code","TEMPLATE_2012281105638218"); //模板编号
        //模板参数 注意这里类型是string
        jsonObject.put("template_param","{\"code\":\"11112222222222\"}");
        jsonObject.put("developKey",developKey); //签名用的key
        JSONObject jsonResult = smsDemo.sendSms(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void sendBatchSms() throws Exception{
        JSONObject jsonObject = new JSONObject();
        //注意这里类型是string
        jsonObject.put("phone_numbers_json","[\'15951815424\',\'17667931217\',\'15195953877\']"); //发送的手机号
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        //注意这里类型是string
        jsonObject.put("template_param","{\"code\":\"11112222222222\"}");
        //注意这里类型是string
        jsonObject.put("sign_code_json","[\'SIGN_2012251879581011\',\'SIGN_2012251879581011\',\'SIGN_2012251879581011\']"); //签名名称
        jsonObject.put("platform_template_code","TEMPLATE_2012281105638218"); //模板编号
        jsonObject.put("developKey",developKey); //签名用的key
        JSONObject jsonResult = smsDemo.sendBatchSms(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void addSmsTemplate() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("template_name","伯俊支付4"); //模板名称
        jsonObject.put("template_content","您正在申请手机注册伯俊云12345，验证码为：${code}，10分钟内有效1！"); //模板正文
        jsonObject.put("template_type",0); //模板类型 其中：0：验证码。1：短信通知。2：推广短信。3：国际/港澳台消息
        jsonObject.put("sms_channel","ALI_SMS"); //短信渠道
        jsonObject.put("remark","22222"); //备注
        jsonObject.put("developKey",developKey); //签名用的key
        JSONObject jsonResult = smsDemo.addSmsTemplate(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void modifySmsTemplate() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("template_name","伯俊支付4"); //模板名称
        jsonObject.put("template_content","您正在申请手机注册伯俊云123123，验证码为：${code}，60分钟内有效！"); //模板正文
        jsonObject.put("template_type",0); //模板类型 其中：0：验证码。1：短信通知。2：推广短信。3：国际/港澳台消息
        jsonObject.put("platform_template_code","TEMPLATE_2101080533493045"); //平台模板编码
        jsonObject.put("remark","22222"); //备注
        jsonObject.put("developKey",developKey); //签名用的key
//        jsonObject.put("sms_channel","zhut_sms");
        JSONObject jsonResult = smsDemo.modifySmsTemplate(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void querySmsTemplate() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("platform_template_code","TEMPLATE_2101081888165768123"); //平台模板编号
        jsonObject.put("developKey",developKey); //签名用的key
        jsonObject.put("sms_channel","zhut_sms");
        JSONObject jsonResult = smsDemo.querySmsTemplate(jsonObject);

        log.info(jsonResult.toJSONString());
    }

    @Test
    void deleteSmsTemplate() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("platform_template_code","TEMPLATE_2012281105638210"); //模板编码
        jsonObject.put("developKey",developKey); //签名用的key
        JSONObject jsonResult = smsDemo.deleteSmsTemplate(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void addSmsSign() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp);//当前时间
        jsonObject.put("sign_name","测试123234123123"); //签名名称
        jsonObject.put("sms_channel","ALI_SMS"); //短信渠道
        jsonObject.put("remark","222222"); //备注
        jsonObject.put("sign_source",0); //签名来源。其中：0：企事业单位的全称或简称。1：工信部备案网站的全称或简称。2：APP应用的全称或简称。3：公众号或小程序的全称或简称。4：电商平台店铺名的全称或简称。5：商标名的全称或简称
        jsonObject.put("developKey",developKey); //签名用的key
        //签名数组 包含多个签名文件
        JSONArray signFileArray = new JSONArray();
        //一个签名文件
        JSONObject signFileJSON = new JSONObject();
        //图片格式
        signFileJSON.put("fileSuffix","jpg");
        signFileJSON.put("fileType","1");
        //图片通过base64转码后的字符串
        signFileJSON.put("fileContents","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");
        signFileArray.add(signFileJSON);
        jsonObject.put("sign_file",signFileArray);
        JSONObject jsonResult = smsDemo.addSmsSign(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void modifySmsSign() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("platform_sign_code","SIGN_2101151772132299"); //签名平台编码
        jsonObject.put("remark","asdsadsadzxczxczxc"); //备注
        jsonObject.put("sign_source",4); //签名来源。其中：0：企事业单位的全称或简称。1：工信部备案网站的全称或简称。2：APP应用的全称或简称。3：公众号或小程序的全称或简称。4：电商平台店铺名的全称或简称。5：商标名的全称或简称
        jsonObject.put("developKey",developKey); //签名用的key
        jsonObject.put("sms_channel","ALI_SMS");
        //签名数组 包含多个签名文件
        JSONArray signFileArray = new JSONArray();
        //一个签名文件
        JSONObject signFileJSON = new JSONObject();
        //图片格式
        signFileJSON.put("fileSuffix","jpg");
        signFileJSON.put("fileType","1");
        //图片通过base64转码后的字符串
        signFileJSON.put("fileContents","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");
        signFileArray.add(signFileJSON);
        jsonObject.put("sign_file",signFileArray);
        JSONObject jsonResult = smsDemo.modifySmsSign(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void querySmsSign() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("sign_code","SIGN_2012251879581011"); //签名平台编码
        jsonObject.put("developKey",developKey); //签名用的key
        JSONObject jsonResult = smsDemo.querySmsSign(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void deleteSmsSign() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("platform_sign_code","SIGN_2101150990944807"); //签名平台编码
        jsonObject.put("developKey",developKey); //签名用的key
        jsonObject.put("sms_channel","ZHUT_SMS"); //短信渠道
        JSONObject jsonResult = smsDemo.deleteSmsSign(jsonObject);
        log.info(jsonResult.toJSONString());
    }

    @Test
    void customSendSms() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("phone_numbers","13917954629"); //发送的手机号
        jsonObject.put("cus_no","640A947719AA748AE77FD788B98374FA"); //商户编号
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());
        jsonObject.put("timestamp",timestamp); //当前时间
        jsonObject.put("content","【伯俊测试】你好，世界"); //签名名称
        jsonObject.put("developKey",developKey); //签名用的key
        JSONObject jsonResult = smsDemo.customSendSms(jsonObject);
        log.info(jsonResult.toJSONString());
    }

}

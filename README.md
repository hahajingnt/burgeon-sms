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
        signFileJSON.put("fileContents","iVBORw0KGgoAAAANSUhEUgAAAPoAAABQCAYAAAAwa2i1AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAACBTSURBVHhe7d2Hlx3FsQbw9189TBSIKBA5Z4NIApGDI9kmmSRykEgiiiySsXHCYJLBYHISUUJk,...");
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
        signFileJSON.put("fileContents","iVBORw0KGgoAAAANSUhEUgAAAPoAAABQCAYAAAAwa2i1AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAACBTSURBVHhe7d2Hlx3FsQbw9189TBSIKBA5Z4NIApGDI9kmmSRykEgiiiySsXHCYJLBYHISUUJkBEII...");
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

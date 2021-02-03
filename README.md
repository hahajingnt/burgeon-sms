
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HttpsmsApplication.class)
class HttpsmsApplicationTests {


   @Autowired
    private SmsApi smsApi;

    private final static String developKey = "hdghfjdydbdnj7s6sghj";

    @Test
    void contextLoads() {
    }

    @Test
    void querySendDetails() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        QuerySendDetailsReqDTO querySendDetailsReqDTO = new QuerySendDetailsReqDTO();
        querySendDetailsReqDTO.setPhoneNumber("15951815424");
        querySendDetailsReqDTO.setCusNo("640A947719AA748AE77FD788B98374FA");
        querySendDetailsReqDTO.setTimestamp(timestamp);
        querySendDetailsReqDTO.setSendDate("20201215");
        querySendDetailsReqDTO.setPageSize(10l);
        querySendDetailsReqDTO.setCurrentPage(1l);
        querySendDetailsReqDTO.setDeveloperKey(developKey);
        querySendDetailsReqDTO.setSmsChannel("ALI_SMS");
        QuerySendDetailsRespVO vo = smsApi.querySendDetails(querySendDetailsReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void sendSms() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        SendSmsReqDTO sendSmsReqDTO = new SendSmsReqDTO();
        sendSmsReqDTO.setPhoneNumbers("15706193653");
        sendSmsReqDTO.setCusNo("EDBA26E1FE2D45FC091FC489FB1D57DC");
        sendSmsReqDTO.setTimestamp(timestamp);
        sendSmsReqDTO.setPlatformSignCode("SIGN_2101181002441780");
        sendSmsReqDTO.setPlatformTemplateCode("TEMPLATE_2101221411474592");


        sendSmsReqDTO.setTemplateParam("{\"code\":\"11112222222222\"}");


        sendSmsReqDTO.setSmsChannel("ZHUT_SMS");
        SendSmsRespVO vo = smsApi.sendSms(sendSmsReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void sendBatchSms() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        SendBatchSmsReqDTO sendBatchSmsReqDTO = new SendBatchSmsReqDTO();
        sendBatchSmsReqDTO.setPhoneNumbersJson("[\'15951815424\',\'17667931217\',\'15195953877\']");
        sendBatchSmsReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        sendBatchSmsReqDTO.setTimestamp(timestamp);
        sendBatchSmsReqDTO.setTemplateParam("{\"code\":\"11112222222222\"}");
        sendBatchSmsReqDTO.setSignCodeJson("[\'SIGN_2101151651186646\',\'SIGN_2012251879581011\',\'SIGN_2012251879581011\']");
        sendBatchSmsReqDTO.setPlatformTemplateCode("TEMPLATE_2101152135241650");
        sendBatchSmsReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        sendBatchSmsReqDTO.setSmsChannel("ZHUT_SMS");
        SendBatchSmsRespVO vo = smsApi.sendBatchSms(sendBatchSmsReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void addSmsTemplate() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());

        AddSmsTemplateReqDTO addSmsTemplateReqDTO = new AddSmsTemplateReqDTO();
        addSmsTemplateReqDTO.setCusNo("640A947719AA748AE77FD788B98374FA");
        addSmsTemplateReqDTO.setTimestamp(timestamp);
        addSmsTemplateReqDTO.setTemplateName("测试1502");
        addSmsTemplateReqDTO.setTemplateContent("测试001");
        addSmsTemplateReqDTO.setTemplateType("0");
        addSmsTemplateReqDTO.setSmsChannel("ALI_SMS");
        addSmsTemplateReqDTO.setRemark("22222");
        addSmsTemplateReqDTO.setDeveloperKey(developKey);
        AddSmsTemplateRespVO vo = smsApi.addSmsTemplate(addSmsTemplateReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void modifySmsTemplate() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        ModifySmsTemplateReqDTO modifySmsTemplateReqDTO = new ModifySmsTemplateReqDTO();
        modifySmsTemplateReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        modifySmsTemplateReqDTO.setTimestamp(timestamp);
        modifySmsTemplateReqDTO.setTemplateName("伯俊支付4111123");
        modifySmsTemplateReqDTO.setTemplateContent("您正在申请手机注册伯俊云1234567123，验证码为：${code}，10分钟内有效2！");
        modifySmsTemplateReqDTO.setTemplateType("0");
        modifySmsTemplateReqDTO.setPlatformTemplateCode("TEMPLATE_2101152135241650");
        modifySmsTemplateReqDTO.setPlatformSignCode("SIGN_2101151651186646");
        modifySmsTemplateReqDTO.setRemark("22222");
        modifySmsTemplateReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        modifySmsTemplateReqDTO.setSmsChannel("ZHUT_SMS");
        ModifySmsTemplateRespVO vo = smsApi.modifySmsTemplate(modifySmsTemplateReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void querySmsTemplate() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        QuerySmsTemplateReqDTO querySmsTemplateReqDTO = new QuerySmsTemplateReqDTO();
        querySmsTemplateReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        querySmsTemplateReqDTO.setTimestamp(timestamp);
        querySmsTemplateReqDTO.setPlatformTemplateCode("TEMPLATE_2101152135241650");
        querySmsTemplateReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        querySmsTemplateReqDTO.setSmsChannel("ZHUT_SMS");
        QuerySmsTemplateRespVO vo = smsApi.querySmsTemplate(querySmsTemplateReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void deleteSmsTemplate() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        DeleteSmsTemplateReqDTO deleteSmsTemplateReqDTO = new DeleteSmsTemplateReqDTO();
        deleteSmsTemplateReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        deleteSmsTemplateReqDTO.setTimestamp(timestamp);
        deleteSmsTemplateReqDTO.setPlatformTemplateCode("TEMPLATE_2101150355225193");
        deleteSmsTemplateReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        deleteSmsTemplateReqDTO.setSmsChannel("ZHUT_SMS");
        DeleteSmsTemplateRespVO vo = smsApi.deleteSmsTemplate(deleteSmsTemplateReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void addSmsSign() throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        AddSmsSignReqDTO addSmsSignReqDTO = new AddSmsSignReqDTO();
        addSmsSignReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        addSmsSignReqDTO.setTimestamp(timestamp);
        addSmsSignReqDTO.setSignName("伯俊test1234");
        addSmsSignReqDTO.setRemark("测试");
        addSmsSignReqDTO.setSignSource("0");
        addSmsSignReqDTO.setSmsChannel("ZHUT_SMS");
        //签名数组 包含多个签名文件
        JSONArray signFileArrays = new JSONArray();
        //一个签名文件
        JSONObject signFileJSONs = new JSONObject();
        //图片格式
        signFileJSONs.put("fileSuffix","jpg");
        signFileJSONs.put("fileType","1");
        //图片通过base64转码后的字符串
        signFileJSONs.put("fileContents","base64转码后的字符串");
        signFileArrays.add(signFileJSONs);
        addSmsSignReqDTO.setSignFile(signFileArrays);
        addSmsSignReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        AddSmsSignRespVO vo = smsApi.addSmsSign(addSmsSignReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void modifySmsSign() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        ModifySmsSignReqDTO modifySmsSignReqDTO = new ModifySmsSignReqDTO();
        modifySmsSignReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        modifySmsSignReqDTO.setTimestamp(timestamp);
        modifySmsSignReqDTO.setSignName("伯俊奶茶");
        modifySmsSignReqDTO.setRemark("伯俊支付验证码专用");
        modifySmsSignReqDTO.setPlatformSignCode("SIGN_2101151651186646");
        modifySmsSignReqDTO.setSignSource("0");
        modifySmsSignReqDTO.setSmsChannel("ZHUT_SMS");
        JSONArray array = new JSONArray();
        JSONObject object = new JSONObject();
        //图片格式
        object.put("fileSuffix","jpg");
        object.put("fileType","1");
        object.put("fileContents","base64转码后的字符串");
        array.add(object);
        modifySmsSignReqDTO.setSignFile(array);
        modifySmsSignReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        ModifySmsSignRespVO vo = smsApi.modifySmsSign(modifySmsSignReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void querySmsSign() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        QuerySmsSignReqDTO querySmsSignReqDTO = new QuerySmsSignReqDTO();
        querySmsSignReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        querySmsSignReqDTO.setTimestamp(timestamp);
        querySmsSignReqDTO.setPlatformSignCode("SIGN_2101151651186646");
        querySmsSignReqDTO.setSmsChannel("ZHUT_SMS");
        querySmsSignReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        QuerySmsSignRespVO vo = smsApi.querySmsSign(querySmsSignReqDTO);
        log.info(vo.toJSONString());
    }

    @Test
    void deleteSmsSign() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());


        DeleteSmsSignReqDTO deleteSmsSignReqDTO = new DeleteSmsSignReqDTO();
        deleteSmsSignReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        deleteSmsSignReqDTO.setTimestamp(timestamp);
        deleteSmsSignReqDTO.setPlatformSignCode("SIGN_2101150483780209");
        deleteSmsSignReqDTO.setSmsChannel("ZHUT_SMS");
        deleteSmsSignReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        DeleteSmsSignRespVO vo = smsApi.deleteSmsSign(deleteSmsSignReqDTO);

        log.info(vo.toJSONString());
    }

    @Test
    void customSendSms() throws Exception{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = simpleDateFormat.format(new Date());

        CustomSendSmsReqDTO customSendSmsReqDTO = new CustomSendSmsReqDTO();
        customSendSmsReqDTO.setCusNo("9B5EE3243AF0C297038CDEB40968A39F");
        customSendSmsReqDTO.setTimestamp(timestamp);
        customSendSmsReqDTO.setPhoneNumbers("15706193653");
        customSendSmsReqDTO.setSmsChannel("ZHUT_SMS");
        customSendSmsReqDTO.setContent("测试");

        Date nowDate = new Date();
        String sendTime = simpleDateFormat.format(new Date(nowDate.getTime() + 60*12*1000));
        customSendSmsReqDTO.setTime(sendTime);
        customSendSmsReqDTO.setDeveloperKey("aebd7ebe48a94cd08790c678514d2eda");
        CustomSendSmsRespVO vo = smsApi.customSendSms(customSendSmsReqDTO);
        log.info(vo.toJSONString());
    }

}

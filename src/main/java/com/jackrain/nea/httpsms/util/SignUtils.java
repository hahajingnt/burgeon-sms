package com.jackrain.nea.httpsms.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 *
 *
 * @author: z.c
 * @since: 2020/11/20
 * create at : 2020/11/20 11:23 AM
 *
 */
@Slf4j
public class SignUtils {

    public static String getSign(JSONObject body,String key) throws Exception {
        //参数排序
        Hashtable hashtable = new Hashtable();
        body.keySet().forEach(p -> {
            Object paramValue = body.get(p);
            if (paramValue == null) {
                return;
            }
            if (paramValue instanceof JSONObject){
                //排序
                JSONObject paramValueSorted = sortedJSONObejct((JSONObject) paramValue);
                hashtable.put(p, paramValueSorted.toJSONString());
            }else if (paramValue instanceof JSONArray){
                //排序
                JSONArray paramValueArray = (JSONArray) paramValue;
                for (int i = 0; i < paramValueArray.size(); i++) {
                    JSONObject sortedObejct = sortedJSONObejct(paramValueArray.getJSONObject(i));
                    paramValueArray.set(i, sortedObejct);
                }
                hashtable.put(p, paramValueArray.toJSONString());
            }else{
                String paramValueStr = paramValue.toString();
                if (StringUtils.isNotEmpty(paramValueStr)) {
                    hashtable.put(p, paramValueStr);
                }
            }
        });
        StringBuilder paramStr = new StringBuilder();
        Map.Entry[] sortHashtable = SortHashtable.getSortedHashtableByKey(hashtable);
        for (Map.Entry entry : sortHashtable) {
            if ("sign".equals(entry.getKey())) {
                //sign不参与签名
                continue;
            }
            paramStr.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        paramStr = new StringBuilder(paramStr.substring(0, paramStr.length() - 1) + key);
        log.info("被签名的字符串："+paramStr.toString());
        String md5Str = getMD5(paramStr.toString());
        log.info("签名："+ md5Str);
        return md5Str;
    }

    /*
     * 对JSON对象里面的元素排序
     * */
    public static JSONObject sortedJSONObejct(JSONObject param) {
        Hashtable hashtable = new Hashtable();
        param.keySet().forEach(p -> {
            Object paramValue = param.get(p);
            if (paramValue != null) {
                String paramValueStr = paramValue.toString();
                if (StringUtils.isNotEmpty(paramValueStr)) {
                    hashtable.put(p, paramValueStr);
                }
            }
        });
        Map.Entry[] sortHashtable = SortHashtable.getSortedHashtableByKey(hashtable);
        JSONObject jsonObject = new JSONObject(true);
        for (int i = 0; i < sortHashtable.length; i++) {
            jsonObject.put(sortHashtable[i].getKey().toString(), sortHashtable[i].getValue());
        }
        return jsonObject;
    }

    /**
     * 对字符串md5加密
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) throws Exception {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // md5的值用16进制表示,返回结果为32位字符串
            return getFormattedText(md.digest());
        } catch (Exception e) {
            throw new Exception("MD5加密出现错误");
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (byte aByte : bytes) {
            buf.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[aByte & 0x0f]);
        }
        return buf.toString();
    }

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

}

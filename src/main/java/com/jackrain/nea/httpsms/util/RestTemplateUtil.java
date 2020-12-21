package com.jackrain.nea.httpsms.util;

import com.jackrain.nea.httpsms.config.RestTemplateIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: RestTemplate
 * @Author: ak47
 * @CreateDate: 2020/11/9 15:30
 * @Version: 1.0
 */
@Slf4j
@Component
public class RestTemplateUtil extends RestTemplate {

    private final RestTemplateIn restTemplateIn;

    public RestTemplateUtil(RestTemplateIn restTemplateIn) {
        this.restTemplateIn = restTemplateIn;
    }

    public String doGetApi(String url) {
        if (restTemplateIn == null) {
            log.error("RestTemplateService--error-->{}", "restTemplate is null");
            return null;
        }
        String ret = restTemplateIn.getRestTemplate().getForEntity(url, String.class).getBody();

        log.debug("RestTemplateService--ret-->{}", ret);
        return ret;
    }

    public String doPostApi(String url, String body) {
        String resultStr = null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "*/*");
        headers.add("Content-Type", "application/json;charset=utf-8");
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        log.debug("[doPostApi]request={}", request.toString());
        if (restTemplateIn == null) {
            log.error("[doPostApi]error={}", "restTemplate is null");
            return null;
        }
        ResponseEntity<String> resp;
        try {
            resp = restTemplateIn.getRestTemplate().postForEntity(url, request, String.class);
            resultStr = resp.getBody();
        } catch (Exception e) {
            log.error("[doPostApi] exception with", e);
        }
        log.debug("[doPostApi] result={}", resultStr);
        return resultStr;
    }
}

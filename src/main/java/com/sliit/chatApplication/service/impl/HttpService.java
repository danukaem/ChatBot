package com.sliit.chatApplication.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Date;

@Service
public class HttpService {

    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders httpHeaders;

    ResponseEntity sendHttpGetUrlConnection(String url) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setDate(new Date().getTime());
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(url, httpHeaders);
            ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
            return exchange;

        } catch (HttpServerErrorException | HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode().value()).body(e.getResponseBodyAsString());
        }
    }

//    ResponseEntity sentHttpPostConnection(String url,Object obj){
//
//        restTemplate.exchange(url,HttpMethod.POST,)
////        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(url, obj, String.class);
////        return stringResponseEntity;
//    }


    public ResponseEntity sentHttpPostConnection(String url, String jsonData)  {
        this.httpHeaders = new HttpHeaders();
        try {
            HttpEntity<String> httpEntity = new HttpEntity<>(jsonData, httpHeaders);
            return restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            return ResponseEntity.status(e.getStatusCode().value()).body(e.getResponseBodyAsString());
        }

    }


    public ResponseEntity sentHttpPostConnection(String url, Object jsonData)  {
        this.httpHeaders = new HttpHeaders();
        try {
            HttpEntity<Object> httpEntity = new HttpEntity<>(jsonData, httpHeaders);
            return restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            return ResponseEntity.status(e.getStatusCode().value()).body(e.getResponseBodyAsString());
        }

    }

}

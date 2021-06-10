package com.example.resttemplatelearn.controller;

import com.example.resttemplatelearn.params.RequestParam;
import com.example.resttemplatelearn.params.ResponseParam;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author : ZH
 * @date : 2021/6/9
 */
@RestController
@RequestMapping("query")
public class RestTemplateutil {

    private final RestTemplate restTemplate;

    public RestTemplateutil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/queryGet")
    public void queryGet(){

        //get请求不带参数-有返回值
        //ResponseParam responseParam = restTemplate.getForObject("http://yapi.pcep.cloud/mock/181/test", ResponseParam.class);
        //System.out.println(responseParam.getTest());

        //get请求带参数，有返回值
        RequestParam requestParam=new RequestParam();
        requestParam.setName("aa");
        requestParam.setAge("12");
        ResponseParam responseParam = restTemplate.getForObject("http://yapi.pcep.cloud/mock/181/test", ResponseParam.class,requestParam);
        System.out.println(responseParam.getTest());
    }


    @GetMapping("/queryPost")
    public void queryPost(){

        //post请求带参数有返回值
        RequestParam requestParam=new RequestParam();
        requestParam.setName("aa");
        requestParam.setAge("12");
        ResponseParam responseParam = restTemplate.postForObject("http://yapi.pcep.cloud/mock/181/test",requestParam,ResponseParam.class);
        System.out.println(responseParam.getTest());
    }


    @RequestMapping("/handle")
    public void handle(RequestEntity<String> request) {
        HttpMethod method = request.getMethod();
        URI url = request.getUrl();
        String body = request.getBody();

        System.out.println(method);
        System.out.println(url);
        System.out.println(body);

    }
}

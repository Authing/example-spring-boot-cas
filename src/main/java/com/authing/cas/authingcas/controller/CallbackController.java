package com.authing.cas.authingcas.controller;

import cn.hutool.http.HttpUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class CallbackController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String getTicket(String ticket) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("service", "http://localhost:9999/");
        paramMap.put("ticket", ticket);
        String result = HttpUtil.get("https://cjtjls-demo.authing.cn/cas-idp/61319680ea8b30c9ca9ca071/serviceValidate", paramMap);
        return result;
    }

}

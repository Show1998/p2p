package com.caipeiyan.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegisterController {
    @RequestMapping("/loan/page/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/loan/checkPhone")
    public @ResponseBody Map<String,Object> checkPhone(String phone){

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result", 0);
        return resultMap;
    }
}

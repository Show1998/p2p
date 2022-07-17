package com.caipeiyan.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/loan/page/login")
    public String toLogin(){
        return "login";
    }
}

package com.caipeiyan.p2p.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoanController {
    @RequestMapping("/loan/loan")
    public String toLoanPage(Integer ptype){
        System.out.println(ptype);
        return "loan";
    }
}

package com.caipeiyan.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.caipeiyan.p2p.service.loan.LoanInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Reference(interfaceClass = LoanInfoService.class,version = "1.0.0",check = false,timeout = 15000)
    LoanInfoService loanInfoService;

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request){

        //查询历史收益率
        double avgRate = loanInfoService.queryAvgRate();
        request.setAttribute("avgRate", avgRate);


        return "index";
    }
}

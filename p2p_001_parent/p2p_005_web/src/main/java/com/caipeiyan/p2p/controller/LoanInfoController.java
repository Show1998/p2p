package com.caipeiyan.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.caipeiyan.p2p.pojo.loan.BidInfo;
import com.caipeiyan.p2p.pojo.loan.LoanInfo;
import com.caipeiyan.p2p.service.loan.BidInfoService;
import com.caipeiyan.p2p.service.loan.LoanInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoanInfoController {

    @Reference(interfaceClass = LoanInfoService.class,version = "1.0.0",check = false,timeout = 15000)
    LoanInfoService loanInfoService;
    @Reference(interfaceClass = BidInfoService.class,version = "1.0.0",check = false,timeout = 15000)
    BidInfoService bidInfoService;

    @RequestMapping("/loan/loanInfo")
    public String loanInfo(
            @RequestParam(value = "productId",required = true) Integer productId,
            Model model
    ){
        LoanInfo loanInfo = loanInfoService.queryProductById(productId);
        model.addAttribute("loanInfo",loanInfo);
        List<BidInfo> bidInfos = bidInfoService.queryConsumerByProductId(productId);
        model.addAttribute("bidInfoList",bidInfos);

        return "loaninfo";
    }
}

package com.caipeiyan.p2p.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.caipeiyan.p2p.Constants;
import com.caipeiyan.p2p.pojo.loan.LoanInfo;
import com.caipeiyan.p2p.service.loan.BidInfoService;
import com.caipeiyan.p2p.service.loan.LoanInfoService;
import com.caipeiyan.p2p.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Reference(interfaceClass = LoanInfoService.class,version = "1.0.0",check = false,timeout = 15000)
    LoanInfoService loanInfoService;

    @Reference(interfaceClass = UserService.class,version = "1.0.0",check = false,timeout = 15000)
    UserService userService;

    @Reference(interfaceClass = BidInfoService.class,version = "1.0.0",check = false,timeout = 15000)
    BidInfoService bidInfoService;

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest request){

        //查询历史收益率
        double avgRate = loanInfoService.queryAvgRate();
        request.setAttribute(Constants.AVG_RATE, avgRate);
        //查询注册总人数
        int amountOfUser = userService.queryAmountOfUser();
        request.setAttribute(Constants.AMOUNT_OF_USER, amountOfUser);
        //查询投资总金额
        Double bidMoney = bidInfoService.queryBidMoney();
        request.setAttribute(Constants.BID_MONEY, bidMoney);
        //产品展示
        Map<String,Integer> paramMap = new HashMap<>();
        paramMap.put("paramType", 0);
        paramMap.put("pageNumber", 0);
        paramMap.put("pageSize", 1);
        List<LoanInfo> loanInfoX = loanInfoService.queryProduct(paramMap);
        paramMap.put("paramType",1);
        paramMap.put("pageSize", 4);
        List<LoanInfo> loanInfoY = loanInfoService.queryProduct(paramMap);
        paramMap.put("paramType",2);
        paramMap.put("pageSize", 8);
        List<LoanInfo> loanInfoZ = loanInfoService.queryProduct(paramMap);
        request.setAttribute("loanInfoX",loanInfoX);
        request.setAttribute("loanInfoY",loanInfoY);
        request.setAttribute("loanInfoZ",loanInfoZ);
        return "index";
    }
}

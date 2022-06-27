package com.caipeiyan.p2p.service.loan;

import com.alibaba.dubbo.config.annotation.Service;
import com.caipeiyan.p2p.mapper.loan.LoanInfoMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service(interfaceClass = LoanInfoService.class,version = "1.0.0",timeout = 15000)
public class LoanInfoServiceImpl implements LoanInfoService{
    @Resource
    LoanInfoMapper loanInfoMapper;
    @Override
    public double queryAvgRate() {
        return loanInfoMapper.selectAvgRate();
    }
}

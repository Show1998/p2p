package com.caipeiyan.p2p.service.loan;

import com.alibaba.dubbo.config.annotation.Service;
import com.caipeiyan.p2p.Constants;
import com.caipeiyan.p2p.mapper.loan.LoanInfoMapper;
import com.caipeiyan.p2p.pojo.loan.LoanInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = LoanInfoService.class,version = "1.0.0",timeout = 15000)
public class LoanInfoServiceImpl implements LoanInfoService{
    @Resource
    LoanInfoMapper loanInfoMapper;

    @Resource
    RedisTemplate<Object,Object> redisTemplate;

    @Override
    public double queryAvgRate() {
        //先从redis中获取数据
        Double avgRate = (Double) redisTemplate.opsForValue().get(Constants.AVG_RATE);
        if(ObjectUtils.allNull(avgRate)){
            synchronized (this){
                avgRate = (Double) redisTemplate.opsForValue().get(Constants.AVG_RATE);
                if(ObjectUtils.allNull(avgRate)){
                    avgRate = loanInfoMapper.selectAvgRate();
                    redisTemplate.opsForValue().set(Constants.AVG_RATE, avgRate, 60, TimeUnit.MINUTES);
                }
            }
        }
        return avgRate;
    }

    @Override
    public List<LoanInfo> queryProduct(Map<String, Object> map) {
        return loanInfoMapper.selectProduct(map);
    }
}

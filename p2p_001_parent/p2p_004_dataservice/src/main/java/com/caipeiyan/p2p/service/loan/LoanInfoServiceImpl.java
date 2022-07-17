package com.caipeiyan.p2p.service.loan;

import com.alibaba.dubbo.config.annotation.Service;
import com.caipeiyan.p2p.Constants;
import com.caipeiyan.p2p.mapper.loan.LoanInfoMapper;
import com.caipeiyan.p2p.pojo.common.PageAndVo;
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
                    redisTemplate.opsForValue().set(Constants.AVG_RATE, avgRate, 60, TimeUnit.SECONDS);
                }
            }
        }
        return avgRate;
    }

    @Override
    public List<LoanInfo> queryProduct(Map<String, Object> map) {
        return loanInfoMapper.selectProduct(map);
    }

    @Override
    public Integer queryAmountOfProdunt(Map<String, Object> map){
        return loanInfoMapper.selectAmountOfProduct(map);
    }

    @Override
    public PageAndVo queryProductByPage(Map<String, Object> map) {
        List<LoanInfo> loanInfos = this.queryProduct(map);
        Integer integer = this.queryAmountOfProdunt(map);
        PageAndVo<LoanInfo> pageAndVo = new PageAndVo<>(loanInfos,integer);
        return pageAndVo;
    }

    @Override
    public LoanInfo queryProductById(Integer id) {
        return loanInfoMapper.selectByPrimaryKey(id);
    }

}

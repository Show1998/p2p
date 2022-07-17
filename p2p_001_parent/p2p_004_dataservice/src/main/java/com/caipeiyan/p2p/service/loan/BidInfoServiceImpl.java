package com.caipeiyan.p2p.service.loan;

import com.alibaba.dubbo.config.annotation.Service;
import com.caipeiyan.p2p.Constants;
import com.caipeiyan.p2p.mapper.loan.BidInfoMapper;
import com.caipeiyan.p2p.pojo.loan.BidInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = BidInfoService.class,timeout = 15000,version = "1.0.0")
public class BidInfoServiceImpl implements BidInfoService {
    @Resource
    BidInfoMapper bidInfoMapper;
    @Resource
    RedisTemplate redisTemplate;
    @Override
    public Double queryBidMoney() {
        Double bidMoney = (Double) redisTemplate.opsForValue().get(Constants.BID_MONEY);
        if(ObjectUtils.allNull(bidMoney)){
            synchronized (this){
                bidMoney = (Double) redisTemplate.opsForValue().get(Constants.BID_MONEY);
                if (ObjectUtils.allNull(bidMoney)){
                    bidMoney = bidInfoMapper.selectBidMoney();
                    redisTemplate.opsForValue().set(Constants.BID_MONEY, bidMoney,60, TimeUnit.SECONDS);
                }
            }
        }
        return bidMoney;
    }

    @Override
    public List<BidInfo> queryConsumerByProductId(Integer id) {
        return bidInfoMapper.selectConsumerById(id);
    }
}

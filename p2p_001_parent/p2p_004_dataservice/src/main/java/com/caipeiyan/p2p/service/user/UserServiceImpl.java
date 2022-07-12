package com.caipeiyan.p2p.service.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.caipeiyan.p2p.Constants;
import com.caipeiyan.p2p.mapper.user.UserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service(interfaceClass = UserService.class , version = "1.0.0" ,timeout = 15000)
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Resource
    RedisTemplate<Object,Object> redisTemplate;

    @Override
    public int queryAmountOfUser() {
        Integer amountOfUser = (Integer) redisTemplate.opsForValue().get(Constants.AMOUNT_OF_USER);
        if (!ObjectUtils.allNotNull(amountOfUser)){
            synchronized (this){
                amountOfUser = (Integer) redisTemplate.opsForValue().get(Constants.AMOUNT_OF_USER);
                if (!ObjectUtils.allNotNull(amountOfUser)){
                   amountOfUser =  userMapper.selectAmountOfUser();
                   redisTemplate.opsForValue().set(Constants.AMOUNT_OF_USER, amountOfUser);
                }
            }
        }
        return amountOfUser;
    }
}

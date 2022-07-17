package com.caipeiyan.p2p.service.loan;

import com.caipeiyan.p2p.pojo.loan.BidInfo;

import java.util.List;

public interface BidInfoService {
    Double queryBidMoney();

    List<BidInfo> queryConsumerByProductId(Integer id);
}

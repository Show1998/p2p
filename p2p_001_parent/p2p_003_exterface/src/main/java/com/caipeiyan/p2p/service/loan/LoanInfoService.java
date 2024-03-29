package com.caipeiyan.p2p.service.loan;

import com.caipeiyan.p2p.pojo.common.PageAndVo;
import com.caipeiyan.p2p.pojo.loan.LoanInfo;

import java.util.List;
import java.util.Map;

public interface LoanInfoService {
    double queryAvgRate();

    List<LoanInfo> queryProduct(Map<String,Object> map);

    Integer queryAmountOfProdunt(Map<String, Object> map);

    PageAndVo queryProductByPage(Map<String, Object> map);

    LoanInfo queryProductById(Integer id);
}

package com.caipeiyan.p2p.mapper.loan;

import com.caipeiyan.p2p.pojo.loan.LoanInfo;

import java.util.List;
import java.util.Map;

public interface LoanInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    int insert(LoanInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    int insertSelective(LoanInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    LoanInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    int updateByPrimaryKeySelective(LoanInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_loan_info
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    int updateByPrimaryKey(LoanInfo record);

    /**
     * 查询所有产品的平均年化收益率
     * @return
     */
    double selectAvgRate();

    List<LoanInfo> selectProduct(Map<String,Object> map);

    Integer selectAmountOfProduct(Map<String,Object> map);
}

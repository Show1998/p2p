package com.caipeiyan.p2p.pojo.loan;

import com.caipeiyan.p2p.pojo.user.User;

import java.io.Serializable;
import java.util.Date;

public class BidInfo implements Serializable {

    private static final long serialVersionUID = -8167759774190860832L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.id
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.loan_id
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    private Integer loanId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.uid
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bid_money
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    private Double bidMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bid_time
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    private Date bidTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_bid_info.bid_status
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    private Integer bidStatus;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.id
     *
     * @return the value of b_bid_info.id
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.id
     *
     * @param id the value for b_bid_info.id
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.loan_id
     *
     * @return the value of b_bid_info.loan_id
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public Integer getLoanId() {
        return loanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.loan_id
     *
     * @param loanId the value for b_bid_info.loan_id
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.uid
     *
     * @return the value of b_bid_info.uid
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.uid
     *
     * @param uid the value for b_bid_info.uid
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bid_money
     *
     * @return the value of b_bid_info.bid_money
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public Double getBidMoney() {
        return bidMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bid_money
     *
     * @param bidMoney the value for b_bid_info.bid_money
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public void setBidMoney(Double bidMoney) {
        this.bidMoney = bidMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bid_time
     *
     * @return the value of b_bid_info.bid_time
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public Date getBidTime() {
        return bidTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bid_time
     *
     * @param bidTime the value for b_bid_info.bid_time
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column b_bid_info.bid_status
     *
     * @return the value of b_bid_info.bid_status
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public Integer getBidStatus() {
        return bidStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_bid_info.bid_status
     *
     * @param bidStatus the value for b_bid_info.bid_status
     *
     * @mbggenerated Mon Jun 27 00:09:40 CST 2022
     */
    public void setBidStatus(Integer bidStatus) {
        this.bidStatus = bidStatus;
    }
}

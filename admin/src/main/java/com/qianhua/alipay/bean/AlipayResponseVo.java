package com.qianhua.alipay.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AlipayResponseVo extends CommonResponseJson implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支付宝交易号
     */
    private String trade_no;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 收款支付宝账号对应的支付宝唯一用户号
     * 以2088开头的纯16位数字
     */
    private String seller_id;

    /**
     * 交易金额
     */
    private BigDecimal total_amount;

}

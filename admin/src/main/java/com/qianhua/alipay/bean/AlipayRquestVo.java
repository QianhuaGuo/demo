package com.qianhua.alipay.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AlipayRquestVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户订单号,64个字符以内、可包含字母、数字、下划线；需保证在商户端不重复
     */
    private String out_trade_no;

    /**
     * 销售产品码，与支付宝签约的产品码名称。
     * 注：目前仅支持FAST_INSTANT_TRADE_PAY
     */
    private String product_code = "FAST_INSTANT_TRADE_PAY";

    /**
     * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]。
     */
    private String total_amount;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 订单描述
     */
    private String body;

    /**
     * 绝对超时时间，格式为yyyy-MM-dd HH:mm:ss
     */
    private String time_expire;

    /**
     * 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
     * 该参数数值不接受小数点， 如 1.5h，可转换为 90m
     */
    private String timeout_express = "90m";

    /**
     * 订单包含的商品列表信息，json格式，其它说明详见商品明细说明
     */
    private GoodsDetail goods_detail;


}

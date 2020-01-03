package com.qianhua.alipay.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class GoodsDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    private String goods_id;

    private String goods_name;

    private Integer quantity;

    private BigDecimal price;
}

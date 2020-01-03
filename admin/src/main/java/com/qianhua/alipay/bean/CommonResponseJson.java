package com.qianhua.alipay.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponseJson {

    @JsonProperty("code")
    private String code;

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("sub_code")
    private String sub_code;

    @JsonProperty("sub_msg")
    private String sub_msg;

    @JsonProperty("sign")
    private String sign;

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

}

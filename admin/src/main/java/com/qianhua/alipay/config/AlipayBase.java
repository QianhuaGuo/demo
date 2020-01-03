package com.qianhua.alipay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "ali")
@Component
//@Data
public class AlipayBase {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public String appid;

    // 商户私钥，您的PKCS8格式RSA2私钥
    public String merchantprivatekey;

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public String alipaypublickey;

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public String notifyurl;

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public String returnurl;

    // 签名方式
    public String signtype;

    // 字符编码格式
    public String charset;

    // 支付宝网关
    public String gatewayurl;

    // 支付宝网关
    public String logpath;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMerchantprivatekey() {
        return merchantprivatekey;
    }

    public void setMerchantprivatekey(String merchantprivatekey) {
        this.merchantprivatekey = merchantprivatekey;
    }

    public String getAlipaypublickey() {
        return alipaypublickey;
    }

    public void setAlipaypublickey(String alipaypublickey) {
        this.alipaypublickey = alipaypublickey;
    }

    public String getNotifyurl() {
        return notifyurl;
    }

    public void setNotifyurl(String notifyurl) {
        this.notifyurl = notifyurl;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public void setReturnurl(String returnurl) {
        this.returnurl = returnurl;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatewayurl() {
        return gatewayurl;
    }

    public void setGatewayurl(String gatewayurl) {
        this.gatewayurl = gatewayurl;
    }

    public String getLogpath() {
        return logpath;
    }

    public void setLogpath(String logpath) {
        this.logpath = logpath;
    }

    @Override
    public String toString() {
        return "AlipayBase{" +
                "appid='" + appid + '\'' +
                ", merchantprivatekey='" + merchantprivatekey + '\'' +
                ", alipaypublickey='" + alipaypublickey + '\'' +
                ", notifyurl='" + notifyurl + '\'' +
                ", returnurl='" + returnurl + '\'' +
                ", signtype='" + signtype + '\'' +
                ", charset='" + charset + '\'' +
                ", gatewayurl='" + gatewayurl + '\'' +
                ", logpath='" + logpath + '\'' +
                '}';
    }
}

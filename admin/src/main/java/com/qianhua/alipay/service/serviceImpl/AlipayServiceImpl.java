package com.qianhua.alipay.service.serviceImpl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianhua.alipay.bean.AlipayRquestVo;
import com.qianhua.alipay.config.AlipayBase;
import com.qianhua.alipay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("alipayService")
public class AlipayServiceImpl implements AlipayService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AlipayBase alipayBase;

    @Override
    public String pay(AlipayRquestVo alipayRquestVo) {
        try {
            String json = objectMapper.writeValueAsString(alipayRquestVo);
            AlipayClient alipayClient = new DefaultAlipayClient(
                    alipayBase.getGatewayurl(),
                    alipayBase.getAppid(),
                    alipayBase.getMerchantprivatekey(),
                    "json",
                    alipayBase.getCharset(),
                    alipayBase.getAlipaypublickey(),
                    alipayBase.getSigntype()
            );

            AlipayTradePagePayRequest alipayTradePagePayRequest = new AlipayTradePagePayRequest();
            alipayTradePagePayRequest.setNotifyUrl(alipayBase.getNotifyurl());
            alipayTradePagePayRequest.setBizContent(json);
            String result = alipayClient.pageExecute(alipayTradePagePayRequest).getBody();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

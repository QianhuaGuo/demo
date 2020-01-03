package com.qianhua.alipay;

import com.qianhua.alipay.bean.AlipayResponseVo;
import com.qianhua.alipay.bean.AlipayRquestVo;
import com.qianhua.alipay.config.AlipayBase;
import com.qianhua.alipay.service.AlipayService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
@ComponentScan(basePackages = {"com.qianhua.alipay.*"})
public class AlipayTest {

    @Autowired
    private AlipayBase alipayBase;
    @Autowired
    private AlipayService alipayService;

    @Autowired

    @Before
    public void init() {

    }

    @Test
    public void createOrder() {
        System.out.println("alipayBase:" + alipayBase.toString());
        String alipayResponseVo = alipayService.pay(new AlipayRquestVo());
        System.out.println("alipayResponseVo:" + alipayResponseVo);
    }
}

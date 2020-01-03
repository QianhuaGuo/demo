package com.qianhua.alipay.service;

import com.qianhua.alipay.bean.AlipayResponseVo;
import com.qianhua.alipay.bean.AlipayRquestVo;

public interface AlipayService {

    String pay(AlipayRquestVo alipayRquestVo);
}

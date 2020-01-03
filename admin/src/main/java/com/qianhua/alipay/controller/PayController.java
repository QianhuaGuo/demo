package com.qianhua.alipay.controller;

import com.qianhua.alipay.bean.AlipayRquestVo;
import com.qianhua.alipay.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alipay")
public class PayController {

    @Autowired
    public AlipayService alipayService;


    @GetMapping("/pay")
    public String pay() {
        AlipayRquestVo alipayRquestVo = new AlipayRquestVo();
        alipayRquestVo.setOut_trade_no(UUID.randomUUID().toString().replace("-", ""));
        alipayRquestVo.setSubject("哈哈哈");
        alipayRquestVo.setBody("测试订单");
        alipayRquestVo.setTotal_amount("0.01");

        return alipayService.pay(alipayRquestVo);
    }

    @GetMapping("/notify")
    public String paynotify() {
        return "SUCCESS";
    }

    public static void main(String[] args) throws Exception{
//        String s = "zhaoxiaofnag%40eims.com.cn";
//        String des = URLDecoder.decode(s,"UTF-8");
//        System.out.println(des);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());

        //去重
        List<Integer> dis = numbers.stream().distinct().sorted().collect(Collectors.toList());

        IntSummaryStatistics statistics = numbers.stream().mapToInt((x)->x).summaryStatistics();

//        System.out.println(statistics);

        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        System.exit(0);
    }
}

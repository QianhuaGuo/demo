package com.example.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Soundbank;
import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ThreadDemo {

    @Data
    public static class Goods{
        public Long id;
        public String name;
        public Long price;

        public Goods(Long id,String name,Long price){
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public static String getNmae(Long id,String name){
            System.out.println(id+":"+name);
            return id+":"+name;
        }


    }

    // JSON输出工具
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public enum LOG_TYPE {
        PARAM, DEFAULT
    }

    public static <T> T toBean(String json, Class<? extends T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json工具
     *
     * @param obj
     * @author Moon Yang
     * @since 2018-03-23
     */
    public static String toJson(Object obj) {
        String log = "";
        if (obj == null)
            return log;

        try {
            log = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return log;
    }

    /**
     * json工具
     *
     * @param obj
     * @author Moon Yang
     * @since 2018-03-23
     */
//    public static void printLog(LOG_TYPE type, Object obj) {
//        if (obj == null)
//            return;
//
//        try {
//            String log = objectMapper.writeValueAsString(obj);
//            switch (type) {
//                case PARAM:
//                    LOGGER.info("【方法参数】：{}", log);
//                    break;
//                default:
//                    LOGGER.info(log);
//                    break;
//            }
//        } catch (Exception e) {
//            LOGGER.error("日志输出异常：", e);
//        }
//    }

    public static String getId(){
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
        int random = (int)((Math.random()*9+1)*100000);
        return date+random;
    }



    public static void main(String[] args) throws Exception{

//        Goods goods1
//        String regx = "^\\d{15}|\\d{18}|\\d{20}$";
//        String s = "111111111111111";
//        String s2 = "111111111111111111";
//        String s3 = "11111111111111111111";
//        String s4 = "111111111111111111111";
//        System.out.println(Pattern.matches(regx,s));
//        System.out.println(Pattern.matches(regx,s2));
//        System.out.println(Pattern.matches(regx,s3));
//        System.out.println(Pattern.matches(regx,s4));
//        System.out.println("come in");
//        Class c = Class.forName("com.example.core.Goods");
//        Field[] fields = c.getDeclaredFields();
////        for (Field f : fields){
////            System.out.println("xx:"+f.getName());
////        }
////        System.out.println(c.getDeclaredFields());
////        Class<Goods> c = Goods.class;
//        Method method = c.getMethod("getAllNmae",Long.class,String.class);
//        Parameter[] parameters = method.getParameters();
//        System.out.println("length = "+parameters.length);
//        int index = 1;
//        System.out.println("come here");
//        // 遍历所有参数
//        for (Parameter p : parameters)
//        {
//            System.out.println("xxx"+p.getName());
//            System.out.println("hhh"+p.getType());
//            if (p.isNamePresent())
//            {
//                System.out.println("---第" + index++ + "个参数信息---");
//                System.out.println("参数名：" + p.getName());
//                System.out.println("形参类型：" + p.getType());
//                System.out.println("泛型类型：" + p.getParameterizedType());
//            }
//        }


//        List<Goods> goodsList  = new ArrayList<Goods>();
//        goodsList.add(new Goods(1L,"苹果11",7000L));
//        goodsList.add(new Goods(2L,"华为mate30pro",666L));
//        goodsList.add(new Goods(3L,"小米MIX阿尔法",19999L));
//        goodsList.add(new Goods(1L,"苹果12",7000L));
//        goodsList.add(new Goods(2L,"华为mate31pro",666L));
//        goodsList.add(new Goods(3L,"小米MIX11阿尔法",19999L));
//
//        int[] arr = {1,2,3,4,5};
//        String[] strings = {"aa","bb","cc"};
//        for (;;){
//            System.out.println(strings);
//        }


//        List<Long> goodsIdList = goodsList.stream().map(goods -> {return goods.getId();}).collect(Collectors.toList());
//        System.out.println(goodsIdList);
//        StringBuilder goodsIds=new StringBuilder();
//        for (Long goodsId : goodsIdList){
//            goodsIds.append(goodsId+",");
//        }
//        System.out.println(goodsIds.substring(0,goodsIds.length()-1));

//        Iterator<Goods> it = goodsList.iterator();
//        while (it.hasNext()){
//            Goods goods = it.next();
//            if ("苹果11".equals(goods.getName())){
////                goodsList.remove(goods);
//                it.remove();
//            }
//        }
//        System.out.println(ThreadDemo.toJson(goodsList));

//        Map<Long,List<Goods>> map = new HashMap<>();
//        map = goodsList.stream().collect(Collectors.groupingBy(Goods::getId));
//        List<Goods> list = new ArrayList<>();
//        map.forEach((k,v)->{
//            System.out.println("k:"+k);
//            System.out.println("v:"+v);
//            for (Goods goods : v){
//                list.add(goods);
//            }
//        });


//        排序(抽出price字段排序 )
//        List<Long> list = goodsList.stream().map(Goods::getPrice).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
//        for (Goods goods : list){
//            System.out.println(goods.getId()+","+goods.getName()+","+goods.getPrice());
//        }

//        goodsList = goodsList.stream().sorted(Comparator.comparing(Goods::getPrice).reversed()).collect(Collectors.toList());
//        for (Goods goods : goodsList){
//            System.out.println(goods.getPrice());
//        }

//        BigDecimal s = new BigDecimal(0.116);
//        BigDecimal ss = s.divide(new BigDecimal(100)).setScale(4,BigDecimal.ROUND_DOWN).stripTrailingZeros();
//        System.out.println("ss:"+ss);
//
//        if (s.compareTo(BigDecimal.ZERO) ==0 || s.compareTo(BigDecimal.ZERO) == -1 || s.compareTo(new BigDecimal(100))==0 || s.compareTo(new BigDecimal(100)) ==1){
//            System.out.println("只能取0-100之间的数");
//        }
//        System.out.println("ok");
//
//        if (new BigDecimal(12.11).compareTo(new BigDecimal(12.12)) == 1){
//            System.out.println("最小规格销售价不能大于最小规格市场价");
//        }

//        System.out.println(s.compareTo(new BigDecimal(100)));
//        Object[] objects = goodsList.toArray(new Goods[goodsList.size()]);
//        for (int i = 0;i<objects.length;i++){
//            System.out.println(objects);
//        }
//        System.out.println(objects.length);
//        Thread1 t = new Thread1();
//        new Thread(t,"t1").start();
//        new Thread(t,"t2").start();
//        new Thread(t,"t3").start();
//        System.out.println(new Date().getTime());
//        System.out.println(UUID.randomUUID().toString());

//        System.out.println(new Date().getTime()/1000);
//        System.out.println(System.currentTimeMillis()/1000);

//        BigDecimal b = new BigDecimal("2.225667").setScale(3, BigDecimal.ROUND_DOWN);
//        System.out.println(b);

//        List<Long> ids = new ArrayList<>();
//        ids.add(12L);
//        ids.add(13L);
//        ids.add(12L);
//        ids.add(null);
//        ids.add(null);
//        ids = ids.stream().distinct().collect(Collectors.toList());
//        for (Long id : ids){
//            System.out.println(id);
//        }

//        for (int i = 0;i<10;i++){
//            System.out.println(getId());
//        }

//        System.out.println("xxx:"+(int)((Math.random()*9+1)*100000));
//        System.out.println(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
//        System.out.println(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
//        System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString());
//        int i =            (int)((Math.random()*9+1)*1000);
//        System.out.println((int)((Math.random()*9+1)*1000));

//        String regx = "(^[0]{1}|^[1-9]{1,2})(\\.\\d{1})?";
//        BigDecimal b = new BigDecimal(12.1);
////        b.setScale(1,BigDecimal.ROUND_HALF_UP);
//        System.out.println("b:"+b);
//        System.out.println(Pattern.matches(regx,b.toString()));
//        String str = "100mg/支 ,200mg/支 ,300mg/支,200mg/支 ";
//        String[] s = str.split(",");
//        List<String> l = Arrays.asList(s);
//        List<String> ss = l.stream().distinct().collect(Collectors.toList());
//        List<String> sss = Arrays.asList(s).stream().distinct().collect(Collectors.toList());
//        for (String x :sss){
//            System.out.println("s:"+x);
//        }

//        String emailReg = "^([a-z0-9A-Z_]+)+[a-z0-9A-Z_]\\@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
//        String emailRegx = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
//        String email = "sdfsed_1231__@qq.com";
//        Boolean b = Pattern.matches(emailReg,email);
//        System.out.println(b);

//        String regx = "(^[0]{1}|^[1-9]{1,2})(\\.\\d{1})?";
//        System.out.println(Pattern.matches(regx,"0.1"));

        BigDecimal bigDecimal = new BigDecimal(0.1000);
        String s = new String(bigDecimal.toString().substring(0,bigDecimal.toString().indexOf('.')+5));
        System.out.println(s);
        System.out.println(new BigDecimal(s).stripTrailingZeros());
    }

    //bean:接口；methodName:方法名；params:参数集合；paramClass:参数的Class;     result:方法返回值
    public static Object executeReflectMethod(Object bean,String methodName,Object[] params,Class<?> paramClass) throws Exception{
        Method serviceMethod= null;
        if(null==paramClass || 0==params.length){
            serviceMethod=bean.getClass().getMethod(methodName,null);
        }else{
            serviceMethod = bean.getClass().getMethod(methodName,paramClass);
        }
        Object result = serviceMethod.invoke(bean,params);

        return result;
    }
}

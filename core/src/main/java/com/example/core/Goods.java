package com.example.core;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class Goods {
    public Long id;
    public String name;
    public BigDecimal price;

    public Goods(Long id,String name,BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getAllNmae(Long id,String name){
        System.out.println(id+":"+name);
        return id+":"+name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) &&
                Objects.equals(price, goods.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, id);
    }

    public static void main(String[] args) {
        Goods g1 = new Goods(1L,"哈哈000",new BigDecimal(10000.00));
        Goods g2 = new Goods(1L,"哈是是是哈",new BigDecimal(10000));

        Boolean b = g1.equals(g2);
        System.out.println("b========"+b);
    }
}

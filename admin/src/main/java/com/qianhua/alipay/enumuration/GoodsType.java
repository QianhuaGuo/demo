package com.qianhua.alipay.enumuration;


public enum GoodsType implements IntEnum{

    PHONE(1),

    FOOD(2),

    TV(3),

    COMPUTER(4),

    TEA(5);

    private int value;

    GoodsType(int value){
        this.value = value;
    }

    public static GoodsType valueOf(int value){
        for (GoodsType goodsType : GoodsType.values()){
            if (goodsType.value == value){
                return goodsType;
            }
        }
        return null;
    }

    @Override
    public int getIntValue() {
        return value;
    }

    public static void main(String[] args) {
        for (GoodsType goodsType : GoodsType.values()){
            System.out.println("goodsType intValue:"+goodsType.value);
            System.out.println("goodsType getIntValue:"+goodsType.getIntValue());
            System.out.println("======================================");
        }

        GoodsType goodsType = GoodsType.valueOf("COMPUTER");
        System.out.println(goodsType.value);

        GoodsType goodsType1 = GoodsType.valueOf(3);
        System.out.println(goodsType);
    }
}

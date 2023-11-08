package com.example.pets.entity;

import com.example.pets.R;

import java.util.ArrayList;

public class GoodsInfo {

    public int id;
    /**
     * 名称
     */
    public String name;
    /**
     * 描述
     */
    public String description;
    /**
     * 价格
     */
    public float price;
    /**
     * 大图的保存路径
     */
    public String picPath;
    /**
     * 大图的资源编号
     */
    public int pic;

    /**
     * 声明一个手机商品的名称数组
     */
    private static String[] mNameArray = {
            "蓝猫", "哈士奇", "宠物蛇", "斑点狗", "宠物蜥蜴", "橘猫"
    };
    /**
     * 声明一个手机商品的描述数组
     */
    private static String[] mDescArray = {
            "纯种英短蓝猫幼猫 幼崽 矮脚蓝猫 活物",
            "纯种哈士奇 幼犬 西伯利亚雪橇犬 三火蓝眼二哈 中大型犬活体宠物 真狗",
            "宠物蛇 赤炼  温顺喜人，必入！！！！",
            "纯种大麦町 幼犬 斑点狗大麦町犬 斑点狗幼犬 宠物狗&幼犬&活体宠物狗",
            "豹纹守宫蜥蜴 活物 新手入门 懒人宠物 可爱爬虫 易养异宠 小型温顺幼体",
            "纯种英短 金渐层 猫咪活体 蓝金渐层幼猫 赛级血统宠物猫 ny12色金渐层"
    };
    /**
     * 声明一个手机商品的价格数组
     */
    private static float[] mPriceArray = {6299, 4999, 3999, 2999, 2998, 2399};
    /**
     * 声明一个手机商品的大图数组
     */
    private static int[] mPicArray = {
            R.drawable.iphone, R.drawable.huawei, R.drawable.xiaomi,
            R.drawable.oppo, R.drawable.vivo, R.drawable.rongyao
    };

    /**
     * 获取默认的手机信息列表
     */
    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.id = i;
            info.name = mNameArray[i];
            info.description = mDescArray[i];
            info.price = mPriceArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }
}


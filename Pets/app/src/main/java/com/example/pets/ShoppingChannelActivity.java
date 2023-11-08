package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.adapter.GoodsAdapter;
import com.example.pets.datebase.ShoppingDBHelper;
import com.example.pets.entity.GoodsInfo;
import com.example.pets.utils.ToastUtil;

import java.util.List;

public class ShoppingChannelActivity extends AppCompatActivity implements View.OnClickListener, GoodsAdapter.AddCartListener {

    /**
     * 声明一个商品数据库的帮助器对象
     */
    private ShoppingDBHelper mDBHelper;
    private TextView tv_count;
    private GridView gv_channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_channel);
        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText("宠物市场");

        tv_count = findViewById(R.id.tv_count);
        gv_channel = findViewById(R.id.gv_channel);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.iv_cart).setOnClickListener(this);

        mDBHelper = ShoppingDBHelper.getInstance(this);
        mDBHelper.openReadLink();
        mDBHelper.openWriteLink();

        // 从数据库查询出商品信息，并展示
        showGoods();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 查询购物车商品总数，并展示
        showCartInfoTotal();
    }

    /**
     * 查询购物车商品总数，并展示
     */
    private void showCartInfoTotal() {
        int count = mDBHelper.countCartInfo();
        MyApplication.getInstance().goodsCount = count;
        tv_count.setText(String.valueOf(count));
    }

    private void showGoods() {
        // 查询商品数据库中的所有商品记录
        List<GoodsInfo> list = mDBHelper.queryAllGoodsInfo();
        GoodsAdapter adapter = new GoodsAdapter(this, list,this);
        gv_channel.setAdapter(adapter);
    }

    /**
     *  把指定编号的商品添加到购物车
     * @param goodsId
     * @param goodsName
     */

    @Override
    public void addToCart(int goodsId, String goodsName) {
        // 购物车商品数量+1
        int count = ++MyApplication.getInstance().goodsCount;
        tv_count.setText(String.valueOf(count));
        mDBHelper.insertCartInfo(goodsId);
        ToastUtil.show(this, "已添加一只" + goodsName + "到购物车");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDBHelper.closeLink();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                // 点击了返回图标，关闭当前页面
                finish();
                break;
            case R.id.iv_cart:
                // 点击了购物车图标
                // 从商场页面跳到购物车页面
                Intent intent = new Intent(this, ShoppingCartActivity.class);
                // 设置启动标志，避免多次返回同一页面的
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
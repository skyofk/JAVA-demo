package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FunctionActivity2 extends AppCompatActivity {
    private ImageView mIvHead;
    private SlideMenu slideMenu;
    private Button mBtnBuy;
    private Button mBtnShoppingCart;

    private  Button mBtnsidego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function2);

        mIvHead=findViewById(R.id.iv_head);
        slideMenu=findViewById(R.id.slideMenu);
        mBtnBuy=findViewById(R.id.btn_main_1);
        mBtnShoppingCart=findViewById(R.id.btn_main_2);
        mBtnsidego=findViewById(R.id.btn_mainside_1);

        //初始化ListView控件
        ListView listView=findViewById(R.id.lv);
        //创建一个Adapter的实例
        MyBaseAdapter mAdapter=new MyBaseAdapter();
        //设置Adapter
        listView.setAdapter(mAdapter);



        mIvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideMenu.switchMenu();
            }
        });

          setlistener();

    }

    private void setlistener(){
        OnClick onClick=new OnClick();

        mBtnBuy.setOnClickListener(onClick);
        mBtnShoppingCart.setOnClickListener(onClick);
        mBtnsidego.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent=null;
            switch (v.getId()){
                case R.id.btn_main_1:
                    intent=new Intent(FunctionActivity2.this,ShoppingChannelActivity.class);
                    break;
                case R.id.btn_main_2:
                    intent=new Intent(FunctionActivity2.this,Buy.class);
                    break;
                case R.id.btn_mainside_1:
                    intent=new Intent(FunctionActivity2.this,Buy.class);
                    break;
            }
            startActivity(intent);
        }
    }
    private String[] titles={"纯种哈士奇","斑点狗","蓝猫","橘猫","宠物蜥蜴","宠物蛇"};
    private String[] prices={"4999元","2999元","6299元","2399元","2998元","3999元"};
    //图片集合
    private  int[] icons={R.mipmap.huawei,R.mipmap.oppo,R.mipmap.iphone,
            R.mipmap.rongyao,R.mipmap.vivo,R.mipmap.xiaomi};

    class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount(){       //得到item的总数
            return titles.length;
        }

        @Override
        public Object getItem(int position){
            return titles[position]; //返回item的数据对象
        }
        @Override
        public long getItemId(int position){
            return position;         //返回item的id
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){//获取item中的View视图
            ViewHolder holder;
            if(convertView==null){
                convertView=View.inflate(FunctionActivity2.this,R.layout.list_item, null);
                holder=new ViewHolder();
                holder.title=convertView.findViewById(R.id.title);
                holder.price=convertView.findViewById(R.id.price);
                holder.iv=convertView.findViewById(R.id.iv);
                convertView.setTag(holder);
            }else{
                holder=(ViewHolder)convertView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setImageResource(icons[position]);
            return convertView;
        }
    }
    class ViewHolder{
        TextView title;
        TextView price;
        ImageView iv;
    }
}
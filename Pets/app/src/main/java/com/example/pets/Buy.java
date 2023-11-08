package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;

import android.os.Bundle;

public class Buy extends AppCompatActivity {

//    //需要适配的数据
//    private String[] titles={"纯种哈士奇","藏獒","蓝猫","中华田园犬","加菲猫","纯白猫"};
//    private String[] prices={"1800元","2000元","3000元","3500元","1000元","2800元"};
//    //图片集合
//    private  int[] icons={R.mipmap.touxiang,R.mipmap.touxiang,R.mipmap.touxiang,
//            R.mipmap.touxiang,R.mipmap.touxiang,R.mipmap.touxiang};
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_buy);
//        //初始化ListView控件
//        ListView listView=findViewById(R.id.lv);
//        //创建一个Adapter的实例
//        MyBaseAdapter mAdapter=new MyBaseAdapter();
//        //设置Adapter
//        listView.setAdapter(mAdapter);
//    }
//    class MyBaseAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount(){       //得到item的总数
//            return titles.length;
//        }
//
//        @Override
//        public Object getItem(int position){
//            return titles[position]; //返回item的数据对象
//        }
//        @Override
//        public long getItemId(int position){
//            return position;         //返回item的id
//        }
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent){//获取item中的View视图
//            ViewHolder holder;
//            if(convertView==null){
//                convertView=View.inflate(Buy.this,R.layout.list_item, null);
//                holder=new ViewHolder();
//                holder.title=convertView.findViewById(R.id.title);
//                holder.price=convertView.findViewById(R.id.price);
//                holder.iv=convertView.findViewById(R.id.iv);
//                convertView.setTag(holder);
//            }else{
//                holder=(ViewHolder)convertView.getTag();
//            }
//            holder.title.setText(titles[position]);
//            holder.price.setText(prices[position]);
//            holder.iv.setImageResource(icons[position]);
//            return convertView;
//        }
//    }
//    class ViewHolder{
//        TextView title;
//        TextView price;
//        ImageView iv;
//    }


    private Button mBtnGo;
    private Button mBtnZhuXiao;

    private ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        mBtnGo=findViewById(R.id.btn_wode_1);
        mBtnZhuXiao=findViewById(R.id.btn_wode_2);
        fanhui=findViewById(R.id.iv_yh_setting);
        setlistener();
    }
    private void setlistener(){
        Buy.OnClick onClick=new OnClick();
        mBtnGo.setOnClickListener(onClick);
        mBtnZhuXiao.setOnClickListener(onClick);
        fanhui.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent=null;
            switch (v.getId()){
                case R.id.btn_wode_1:
                    intent=new Intent(Buy.this,ShoppingChannelActivity.class);
                    break;
                case R.id.btn_wode_2:
                    intent=new Intent(Buy.this,MainActivity.class);
                    break;
                case R.id.iv_yh_setting:
                    intent=new Intent(Buy.this,FunctionActivity2.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
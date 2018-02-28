package com.bignerdranch.android.firstquiz;

import java.util.ArrayList;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class RecyclerviewActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> list = new ArrayList<>();




     //item的局部刷新
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        list = getData();
        initData(list);

        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null){
        int getposition =  bundle.getInt("Position");
        String getdata = bundle.getString("Date");
        list = bundle.getStringArrayList("List");
        list.set(getposition, getdata);
        mAdapter.notifyItemChanged(getposition);
        initData(list);
        }

        initView();


        //设置监听器，实现onItemClickListener和onItemLongClickListener的接口
        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            //通过bundle封装数据
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(RecyclerviewActivity.this, ItemShowActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Date", list.get(position));
                bundle1.putInt("Position", position);
                bundle1.putStringArrayList("List", list);
                intent.putExtras(bundle1);
                startActivity(intent);
                finish();
                }

        });
        mRecyclerView.setAdapter(mAdapter);
    }


    private void initData(ArrayList<String> List) {

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new MyAdapter(List);

    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);
    }


    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        Intent intent0 = getIntent();
        for(int i = 0; i < 100; i++) {
            data.add(temp+ "  "+ i);
        }
        return data;

    }




    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(RecyclerviewActivity.this, QuizActivity.class );
        startActivity(intent);
        finish();
    }






}

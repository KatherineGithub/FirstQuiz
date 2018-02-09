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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initData();
        initView();



        //设置监听器，实现onItemClickListener和onItemLongClickListener的接口

        mAdapter = new MyAdapter(getData());
        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(RecyclerviewActivity.this, ItemShowActivity.class);
                intent.putExtra("EXTRA_MESSAGE", getData().get(position));
                startActivity(intent);
                finish();
            }
        });

        mRecyclerView.setAdapter(mAdapter);






    }




    private void initData() {
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new MyAdapter(getData());
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

package com.bignerdranch.android.firstquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemShowActivity extends AppCompatActivity {

    int getposition;
    ArrayList<String> list = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_show);

        Bundle bundle = this.getIntent().getExtras();
        String message1 = bundle.getString("Date");
        getposition =  bundle.getInt("Position");
        list = bundle.getStringArrayList("List");
        EditText editText = (EditText) findViewById(R.id.itemShow);
        editText.setText(message1);
        //光标显示在文字后面
        Editable able = editText.getText();
        int position = able.length();
        Selection.setSelection(able,position);
    }


    //捕获后退键
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent= new Intent(ItemShowActivity.this, RecyclerviewActivity.class );
        EditText editText = (EditText) findViewById(R.id.itemShow);
        String message = editText.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("Date", message);
        bundle.putInt("Position", getposition);
        bundle.putStringArrayList("List",list);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}

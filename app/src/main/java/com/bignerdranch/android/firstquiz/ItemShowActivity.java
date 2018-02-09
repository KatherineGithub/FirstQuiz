package com.bignerdranch.android.firstquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.widget.EditText;
import android.widget.TextView;

public class ItemShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_show);



        Intent intent=getIntent();
        String message1="just for test";

        // Get the Intent that started this activity and extract the string
        message1 = intent.getStringExtra("EXTRA_MESSAGE");

        // Capture the layout's TextView and set the string as its text
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
        startActivity(intent);
        finish();
    }
}

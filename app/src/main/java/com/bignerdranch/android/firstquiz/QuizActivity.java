package com.bignerdranch.android.firstquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;

public class QuizActivity extends AppCompatActivity {

    String EXTRA_MESSAGE = "this is the first value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent0 = getIntent();


        // Get the Intent that started this activity and extract the string
       if (intent0.hasExtra("EXTRA_MESSAGE1")) {
            String message0 = intent0.getStringExtra("EXTRA_MESSAGE1");
            // Capture the layout's TextView and set the string as its text
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(message0);
           Editable able = editText.getText();
           int position = able.length();
           Selection.setSelection(able,position);

        }
    }

    //submit的功能
    public void clickButtonDialog(View view) {
        subMessage();
    }

    //called when the user taps the Submit button
    public void subMessage() {
        //do something in response to button
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Hello,  " + message + "!")//设置对话框内容
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {//设置对话框[肯定]按钮

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                        //finish();//结束当前Activity
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {//设置对话框[否定]按钮

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                        //finish();//结束当前Activity
                    }
                });
        builder.create().show();//创建对话框并且显示该对话框

    }

    //next的功能
    public void nextMessage(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        Intent intent = new Intent(QuizActivity.this, NextActivity.class);
        intent.putExtra("EXTRA_MESSAGE", message);
        startActivityForResult(intent, 1); //1 为requestCode，传值的标志，就像一个商标，表示是这个箱子
        finish();
    }



    //接收来自NextActivity的返回值
    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2){
            Bundle b = data.getExtras();
            String message0 = "just for test";
            message0 =b.getString("EXTRA_MESSAGE1");
            // Capture the layout's TextView and set the string as its text
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(message0);


        }
    }*/

    //TextRecyclerView的功能
    public void Recyclerview(View view) {

        Intent intent = new Intent(QuizActivity.this, RecyclerviewActivity.class);
        startActivity(intent);
        finish();
    }




}
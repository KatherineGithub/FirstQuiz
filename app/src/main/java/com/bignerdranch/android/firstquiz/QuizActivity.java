package com.bignerdranch.android.firstquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class QuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

//submit的功能
    public void clickButtonDialog(View view){
        subMessage();
    }

    //called when the user taps the Submit button
    public void subMessage() {
        //do something in response to button
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Hello,  "+ message+"!")//设置对话框内容
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {//设置对话框[肯定]按钮

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                        //finish();//结束当前Activity
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {//设置对话框[否定]按钮

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();//关闭对话框
                        finish();//结束当前Activity
                    }
                });
        builder.create().show();//创建对话框并且显示该对话框

    }






}

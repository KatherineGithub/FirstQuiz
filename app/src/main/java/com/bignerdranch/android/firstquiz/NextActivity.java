package com.bignerdranch.android.firstquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class NextActivity extends AppCompatActivity {



    String EXTRA_MESSAGE1="this is the first value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent=getIntent();
        String message1="just for test";

        // Get the Intent that started this activity and extract the string
        message1 = intent.getStringExtra("EXTRA_MESSAGE");

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Hello,  "+ message1+"!");

        // Capture the layout's TextView and set the string as its text
        EditText editText = (EditText) findViewById(R.id.editText4);
        editText.setText(message1);


    }

   public void onBackPressed() {
        super.onBackPressed();
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        String message2 = editText4.getText().toString();
        Intent intent1= new Intent(NextActivity.this, QuizActivity.class );
        //EXTRA_MESSAGE1 = intent1.getString(message2);
       // intent1.getStringExtra("EXTRA_MESSAGE1");
        intent1.putExtra("EXTRA_MESSAGE1", message2);
        startActivity(intent1);
        finish();
    }


    //获取NextActivity的数据进行封装
  //  @Override
    /* public void onBackPressed() {
        super.onBackPressed();
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        String message2 = editText4.getText().toString();
        Intent intent1= new Intent(NextActivity.this, QuizActivity.class );
        Bundle bundle = new Bundle();
        bundle.putString("EXTRA_MESSAGE1", message2);
        setResult(2, intent1);
        finish();
    }*/




}

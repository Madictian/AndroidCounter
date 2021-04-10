package com.example.myapplication;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.example.myapplication.extra.REPLY";
    public static final String EXTRA_REPLY_COUNT = "com.example.myapplication.extra.REPLY_COUNT";

    private EditText pwTwo;
    int countOver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = (TextView) findViewById(R.id.text_header);
        TextView textReader = (TextView) findViewById(R.id.textReader);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        countOver = intent.getIntExtra(MainActivity.EXTRA_COUNT, 0);
        textView.setText(String.valueOf(countOver));
        textReader.setText(message);

        pwTwo = (EditText) findViewById(R.id.pwToSendTwo);
        Button sendTwo = (Button) findViewById(R.id.sendTwo);
        sendTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countOver++;
                replyMessage();
            }
        });

    }
    public void replyMessage(){
        Log.d(LOG_TAG, "Button Clicked");
        Intent ReplyIntent = new Intent(this, MainActivity.class);
        int carryCount = countOver;
        String reply = pwTwo.getText().toString();
        ReplyIntent.putExtra(EXTRA_REPLY_COUNT, carryCount);
        ReplyIntent.putExtra(EXTRA_REPLY, reply);
        startActivity(ReplyIntent);
        finish();
    }
}
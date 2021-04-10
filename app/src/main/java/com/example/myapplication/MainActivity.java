package com.example.myapplication;

import android.content.Intent;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.databinding.ActivityMainBinding;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.myapplication.extra.MESSAGE";
    public static final String EXTRA_COUNT = "com.example.myapplication.extra.COUNT";


    private EditText pwOne;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView replyView = (TextView) findViewById(R.id.replyView);
        TextView mainReader = (TextView) findViewById(R.id.mainReader);
        Intent replyIntent = getIntent();
        String message = replyIntent.getStringExtra(SecondActivity.EXTRA_REPLY);
        counter = replyIntent.getIntExtra(SecondActivity.EXTRA_REPLY_COUNT, 0);
        replyView.setText(message);
        mainReader.setText(String.valueOf(counter));
        pwOne = (EditText) findViewById(R.id.pwToSendOne);
        Button send = (Button) findViewById(R.id.sendOne);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                sendMessage();
            }
        });

    }
    public void sendMessage(){
        Log.d(LOG_TAG, "Button Clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        String message =pwOne.getText().toString();
        int count = counter;
        intent.putExtra(EXTRA_COUNT, count);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
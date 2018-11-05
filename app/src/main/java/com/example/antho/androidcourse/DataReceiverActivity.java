package com.example.antho.androidcourse;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DataReceiverActivity extends AppCompatActivity {

    private TextView mTextMessageRecevied;

    public static final String EXTRA_REPLY = "com.example.antho.androidcourse";

    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_receiver);

        Intent intent = getIntent();

        String message = intent.getStringExtra(DataPassActivity.EXTRA_MESSAGE); //Just a key

        this.mTextMessageRecevied = findViewById(R.id.text_message);

        mTextMessageRecevied.setText(message);
    }


    public void returnReply(View view) {
        mReply = findViewById(R.id.reply_text_edit);

        String reply = mReply.getText().toString();

        Intent replyIntent = new Intent();

        replyIntent.putExtra(DataReceiverActivity.EXTRA_REPLY, reply);

        setResult(RESULT_OK, replyIntent);

        finish();
    }
}

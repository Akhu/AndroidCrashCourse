package com.example.antho.androidcourse;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DataPassActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.antho.androidcourse.extra.MESSAGE";

    private final String LOG_TAG = DataPassActivity.class.getSimpleName();

    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pass);

        mMessageEditText = findViewById(R.id.edit_text_long_message);

        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "button clicked !");
        String message = mMessageEditText.getText().toString();

        Intent intent = new Intent(this,DataReceiverActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);

        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                assert data != null;
                mReplyTextView.setText(data.getStringExtra(DataReceiverActivity.EXTRA_REPLY));
                mReplyTextView.setVisibility(View.VISIBLE);

            }
        }
    }
}

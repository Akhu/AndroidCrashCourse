package com.example.antho.androidcourse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.show_count); //Binding view and variable
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);

        toast.show();
    }

    @SuppressLint("SetTextI18n")
    public void countUp(View view) {
        mCount++;

        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }


    public void gotoActivity(View view) {
        Log.v(LOG_TAG, String.valueOf(view.getId()));

        switch (getResources().getResourceEntryName(view.getId())){
            case "button_data_activity":
                Intent intent = new Intent(this, DataPassActivity.class);
                startActivity(intent);
                break;
            case "button_scroll_activity":
                Intent intent2 = new Intent(this, ScrollTextActivity.class);
                startActivity(intent2);
                break;
            default:
                    break;
        }


    }
}

package com.example.antho.androidcourse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

public class ImplicitIntentActivity extends AppCompatActivity {

    private EditText mOpenWebSiteEditText;

    public final String LOG_TAG = ImplicitIntentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        mOpenWebSiteEditText = findViewById(R.id.website_edittext);
    }

    public void shareText(View view) {

    }

    public void openLocation(View view) {
    }

    public void openWebsite(View view) {
        String url = mOpenWebSiteEditText.getText().toString();

        Uri webpage = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else {
            Log.d(LOG_TAG, "Cannot satisfy activity intent");
        }
    }
}

package com.anita.libraryapplication.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.anita.libraryapplication.R;
import com.anita.libraryapplication.domain.booksystem.Books;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class MainActivity extends AppCompatActivity {
    private static Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickButtonListener(View v) {
        Intent intent = new Intent(this, ActivityChooseField.class);
        startActivity(intent);
        HttpRequestTask http = new HttpRequestTask();
        http.doInBackground();
    }


    private class HttpRequestTask extends AsyncTask<Void, Void, Books> {
        @Override
        protected Books doInBackground(Void... params) {
            try {
                final String url = "http://rest-service.guides.spring.io/greeting";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Books greeting = restTemplate.getForObject(url, Books.class);
                return greeting;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }


    }

}

package com.anita.libraryapplication.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.anita.libraryapplication.R;
import com.anita.libraryapplication.domain.booksystem.Books;
import com.anita.libraryapplication.factories.booksfactory.impl.UseBookFactory;
import com.anita.libraryapplication.repo.booksystem.impl.BookRepositoryImpl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class ActivityShowDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_db);
        final TextView lblList = (TextView) findViewById(R.id.txtDisplay);
        BookRepositoryImpl repo = new BookRepositoryImpl(this.getBaseContext());
        Set<Books> bookList = repo.findAll();
        ArrayList<Books> list = new ArrayList<>(bookList);
        int listSize = bookList.size();


        for (int x = 0; x < bookList.size(); x++) {
            lblList.append("\nBook Title: " + list.get(x).getBookTitle() +
                    "\nAuthor: " + list.get(x).getAuthor() +
                    "\nPages: " + list.get(x).getPages() +
                    "\nPublisher: " + list.get(x).getPublisher() +
                    "\nISBN: " + list.get(x).getiSBN() + "\n"
            );
        }
    }


    public void onClickHome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
/*
    private class HttpRequestTask extends AsyncTask<Void, Void, Books> {
        @Override
        protected Books doInBackground(Void... params) {
            try {
                final String url = "http://localhost:3306/pvtdroid";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Books book = restTemplate.getForObject(url, Books.class);
                return book;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }
*/

    }


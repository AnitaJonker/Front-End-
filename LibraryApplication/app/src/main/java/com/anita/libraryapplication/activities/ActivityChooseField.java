package com.anita.libraryapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.anita.libraryapplication.R;


public class ActivityChooseField extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_field);

    }

    //Add Books
    public void onClickAddBooksListener(View v)
    {
        Intent intent = new Intent(this, ActivityBooks.class);
        startActivity(intent);
    }


}

package com.anita.libraryapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.anita.libraryapplication.R;
import com.anita.libraryapplication.domain.booksystem.Books;


//RestTemplate.

public class ActivityBooks extends AppCompatActivity {

    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_books);
    }


    //Add Books
    public void onClickAddBooksListener(View v)
    {

        //Set values in textfields

        Intent intent = new Intent(this, ActivityDisplayBooks.class);
        String bookTitle = ((EditText)findViewById(R.id.txtBookTitle)).getText().toString();
        String author = ((EditText)findViewById(R.id.txtAuthor)).getText().toString();
        String publisher = ((EditText)findViewById(R.id.txtPub)).getText().toString();
        String pages = ((EditText)findViewById(R.id.txtPages)).getText().toString();
        String iSBN = ((EditText)findViewById(R.id.txtISBN)).getText().toString();

        Books book = new Books.Builder()
                .bookTitle(bookTitle)
                .author(author)
                .publisher(publisher)
                .pages(Integer.parseInt(pages))
                .iSBN(iSBN)
                .build();

        intent.putExtra("Books", book);
        startActivity(intent);

    }




}

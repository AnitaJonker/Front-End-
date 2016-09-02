package com.anita.libraryapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.anita.libraryapplication.R;
import com.anita.libraryapplication.domain.booksystem.Books;
import com.anita.libraryapplication.services.database.admin.InsertDB;


public class ActivityDisplayBooks extends AppCompatActivity {

Books book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_display_books);
        Bundle extras = getIntent().getExtras();
        book = (Books)extras.getSerializable("Books");

        //Display entered values
      ((TextView)findViewById(R.id.txtBookTitle)).setText(book.getBookTitle());
        ((TextView)findViewById(R.id.txtAuthor)).setText(book.getAuthor());
        ((TextView)findViewById(R.id.txtPages)).setText(book.getPages()+ " ");
        ((TextView)findViewById(R.id.txtPub)).setText(book.getPublisher());
        ((TextView)findViewById(R.id.txtISBN)).setText(book.getiSBN());

    }

public void btnSave(View v)
{
    InsertDB insertService = InsertDB.getInstance();
    insertService.addBook(this, book);
  //  Long id = InsertDB.getId();
    Intent intent = new Intent(this,ActivityShowDB.class);
   // intent.putExtra("ID", id);
    startActivity(intent);
}



}

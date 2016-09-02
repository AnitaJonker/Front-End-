package com.anita.libraryapplication.services.database.admin;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.anita.libraryapplication.domain.booksystem.Books;
import com.anita.libraryapplication.repo.booksystem.BookRepository;
import com.anita.libraryapplication.repo.booksystem.impl.BookRepositoryImpl;

import java.util.Set;



public class ShowDB extends Service {

   BookRepositoryImpl repo = new BookRepositoryImpl(this.getApplicationContext());

    private final IBinder adminBind = new myLocalBinder();

    public ShowDB() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return adminBind;
    }

    public class myLocalBinder extends Binder
    {
        public  ShowDB getService(){
            return ShowDB.this;
        }
    }

    public int getSize()
    {
        return repo.findAll().size();
    }


   public Set<Books> getAllBooks()
    {
        BookRepository books = new BookRepositoryImpl(getBaseContext());
        return  books.findAll();
    }
}

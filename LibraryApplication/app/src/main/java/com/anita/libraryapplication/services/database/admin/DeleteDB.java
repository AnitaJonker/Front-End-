package com.anita.libraryapplication.services.database.admin;

import android.app.IntentService;
import android.content.Intent;

import com.anita.libraryapplication.repo.booksystem.impl.BookRepositoryImpl;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DeleteDB extends IntentService {
    BookRepositoryImpl repo = new BookRepositoryImpl(this.getApplicationContext());


    private static final String TAG ="services.database";
    public DeleteDB() {
        super("DeleteDB");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        repo.deleteAll();
    }


}

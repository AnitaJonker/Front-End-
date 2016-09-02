package admin;

import android.content.Context;
import android.test.AndroidTestCase;

import com.anita.libraryapplication.domain.booksystem.Books;
import com.anita.libraryapplication.repo.booksystem.BookRepository;
import com.anita.libraryapplication.repo.booksystem.impl.BookRepositoryImpl;
import com.anita.libraryapplication.services.database.admin.InsertDB;

import junit.framework.Assert;

import java.util.Set;




/**
 * Created by Anita on 2016/05/12.
 */

/*
I used intent service to insert values since I am not receiving values back when inserting in the files.
 */

public class InsertDBTest extends AndroidTestCase{

    public void testInsert() throws Exception {


     InsertDB insertService = InsertDB.getInstance();
        Context context = getContext();
        BookRepository bookRepository = new BookRepositoryImpl(context);

        Books book = new Books.Builder()
                .bookTitle("Eat pray love")
                .author("Elizabeth Gilbert")
                .pages(300)
                .publisher("New York times")
                .iSBN("1231234")
                .build();

        insertService.addBook(this.mContext, book);

        Thread.sleep(5000);

        // READ ALL
        Set<Books> booksSetSet1 = bookRepository.findAll();
        Assert.assertTrue(booksSetSet1.size() > 0);

    }

}

package testBookSystem;


import com.anita.libraryapplication.domain.booksystem.Books;
import com.anita.libraryapplication.factories.booksfactory.impl.UseBookFactory;

import junit.framework.Assert;

import org.junit.Test;



/**
 * Created by Anita on 2016/04/16.
 */
public class TestBooks {

    @Test
    public void testBookAuthor() throws Exception {
        UseBookFactory bookFactory = new UseBookFactory();
        Assert.assertEquals(bookFactory.getBook("Adult").getAuthor(),"Elizabeth Gilbert");
    }

    @Test
    public void testSetBookAuthor() throws Exception {
        Books book = new Books.Builder()
                .author("Stephen King")
                .build();
        Assert.assertEquals(book.getAuthor(),"Stephen King");

    }

    @Test
    public void testObject() throws Exception {
        Books book = new Books.Builder()
                .author("Stephen King")
                .build();
        Assert.assertEquals(book.getAuthor(),"Stephen King");

    }


}

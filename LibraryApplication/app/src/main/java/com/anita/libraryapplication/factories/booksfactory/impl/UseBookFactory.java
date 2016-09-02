package com.anita.libraryapplication.factories.booksfactory.impl;


import com.anita.libraryapplication.domain.booksystem.Books;
import com.anita.libraryapplication.domain.booksystem.impl.AdultBook;
import com.anita.libraryapplication.domain.booksystem.impl.BookDetails;
import com.anita.libraryapplication.domain.booksystem.impl.Kid;
import com.anita.libraryapplication.domain.booksystem.impl.NonFiction;
import com.anita.libraryapplication.domain.booksystem.impl.Restricted;
import com.anita.libraryapplication.domain.booksystem.impl.YoungAdult;
import com.anita.libraryapplication.factories.booksfactory.BookFactory;

/**
 * Created by Anita on 2016/04/16.
 */
public class UseBookFactory implements BookFactory {


    //Books book;

    public Books getBook(String bookTitle) {
        BookDetails chain = setUpChain();
       return chain.handleRequest(bookTitle);
    }
    
    public static BookDetails setUpChain(){
        BookDetails adultBook = new AdultBook();
        BookDetails kidBook = new Kid();
        BookDetails nonFiction = new NonFiction();
        BookDetails restricted = new Restricted();
        BookDetails yA = new YoungAdult();
        adultBook.setNextBookType(kidBook);
        kidBook.setNextBookType(nonFiction);
        nonFiction.setNextBookType(restricted);
        restricted.setNextBookType(yA);
        return adultBook;
    }

}


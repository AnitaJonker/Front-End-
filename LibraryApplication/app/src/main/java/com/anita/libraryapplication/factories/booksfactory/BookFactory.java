package com.anita.libraryapplication.factories.booksfactory;

import com.anita.libraryapplication.domain.booksystem.Books;

/**
 * Created by Anita on 2016/04/16.
 */

public interface BookFactory {
    Books getBook(String bookTitle);
}

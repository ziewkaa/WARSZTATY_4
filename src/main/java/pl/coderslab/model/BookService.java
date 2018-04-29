package pl.coderslab.model;

import java.util.List;

public interface BookService {

    public List<Book> getList();
    public Book getBook(int id);
    public void addBook( String isbn, String title, String author, String publisher, String type);
    public void updateBook(int id, String isbn, String title, String author, String publisher, String type );
    public void deleteBook(int id );

}

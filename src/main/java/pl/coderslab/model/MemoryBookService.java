package pl.coderslab.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService  implements BookService {

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public Book getBook(int id) {

        Book toRead = new Book();
        for (Book book : list){
            if (book.getId() == id){
                toRead = book;
            }
        }
        return toRead;
    }

    public void addBook( String isbn, String title, String author, String publisher, String type) {
        Book book = new Book(isbn, title, author, publisher, type);
        list.add(book);
    }

    public void updateBook(int id, String isbn, String title, String author, String publisher, String type ) {
        Book book = list.get(id);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
    }

    public void deleteBook(int id ) {

        for (Book book : list){
            if (book.getId() == id){
                list.remove(book);
            }
        }
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}

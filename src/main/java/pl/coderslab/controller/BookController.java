package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookService;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> allBooks(){
        return bookService.getList();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.getBook(id);
    }

    @PostMapping("/books")
    @ResponseBody
    public List<Book> addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam  String type){
        bookService.addBook(isbn,  title, author, publisher, type);
        List<Book> books = (List<Book>) bookService;
        return books;
    }

    @PutMapping("/books/{id}")
    public List<Book> updateBook(@PathVariable int id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam  String type){
        bookService.updateBook(id, isbn,  title, author, publisher, type);
        List<Book> books = (List<Book>) bookService;
        return books;

    }

    @DeleteMapping("/books/{id}")
    public List<Book> deleteBook(@PathVariable int id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam  String type){
        bookService.deleteBook(id);
        List<Book> books = (List<Book>) bookService;
        return books;
    }



}

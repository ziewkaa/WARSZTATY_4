package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private MemoryBookService memoryBookService;


    @GetMapping("/books")
    public List<Book> allBooks(){
        return memoryBookService.getList();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        return memoryBookService.getBook(id);
    }

    @PostMapping("/books")
    @ResponseBody
    public List<Book> addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam  String type){
        memoryBookService.addBook(isbn,  title, author, publisher, type);
        List<Book> books = (List<Book>) memoryBookService;
        return books;
    }

    @PutMapping("/books/{id}")
    public List<Book> updateBook(@PathVariable int id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam  String type){
        memoryBookService.updateBook(id, isbn,  title, author, publisher, type);
        List<Book> books = (List<Book>) memoryBookService;
        return books;

    }

    @DeleteMapping("/books/{id}")
    public List<Book> deleteBook(@PathVariable int id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author, @RequestParam String publisher, @RequestParam  String type){
        memoryBookService.deleteBook(id);
        List<Book> books = (List<Book>) memoryBookService;
        return books;
    }



}

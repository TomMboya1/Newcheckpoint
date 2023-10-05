package Controller;

import Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Optional;

@Controller
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    public BookRepository bookRepository;

    @PostMapping("/id")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        try{Book saveBook = bookRepository.save(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("book saved successfull");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occored:" + e.getMessage());
        }


    }
    @GetMapping("/id")
    public Object getBookById(@PathVariable long id){
        try{
            Optional<Book> book = bookRepository.findById(id);
            if (book.isPresent()){
                return ResponseEntity.ok();
            }else {
                return ResponseEntity.notFound().build();
            }
            }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error occoured"+e.getMessage());
        }

        }

    @PutMapping("/id")
    public ResponseEntity<Book>updateBook(@PathVariable long id,@RequestBody Book book){
        try{Optional<Book> existi

        }

    }



}

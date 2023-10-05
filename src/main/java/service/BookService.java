package service;
import Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;





    @Service
    public class BookService {
        private final BookRepository bookRepository;

        @Autowired
        public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        public Book addBook(Book book) {
            // Implement logic to add a new book
            return bookRepository.save(book);
        }

        public Optional<Book> getBookById(Long id) {
            // Implement logic to retrieve a book by ID
            return bookRepository.findById(id);
        }

        public List<Book> getAllBooks() {
            // Implement logic to retrieve all books
            return bookRepository.findAll();
        }

        public Book updateBook(Long id, Book updatedBook) {
            // Implement logic to update book details
            Optional<Book> existingBook = bookRepository.findById(id);

            if (existingBook.isPresent()) {
                Book bookToUpdate = existingBook.get();
                bookToUpdate.setTitle(updatedBook.getTitle());
                bookToUpdate.setAuthor(updatedBook.getAuthor());
                bookToUpdate.setIsbn(updatedBook.getIsbn());
                bookToUpdate.setCopiesAvailable(updatedBook.getCopiesAvailable());
                return bookRepository.save(bookToUpdate);
            } else {
                throw new BookNotFoundException("Book with ID " + id + " not found");
            }
        }

        public void deleteBook(Long id) {
            // Implement logic to delete a book by ID
            Optional<Book> existingBook = bookRepository.findById(id);

            if (existingBook.isPresent()) {
                bookRepository.deleteById(id);
            } else {
                throw new BookNotFoundException("Book with ID " + id + " not found");
            }
        }
    }

}

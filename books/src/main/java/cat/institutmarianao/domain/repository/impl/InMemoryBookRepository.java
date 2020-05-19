package cat.institutmarianao.domain.repository.impl;

import cat.institutmarianao.domain.Book;
import cat.institutmarianao.domain.repository.BookRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;


@Repository
public class InMemoryBookRepository implements BookRepository {

    private final Map<String, Book> shows = new HashMap<String, Book>();

    public InMemoryBookRepository() {
        Book first = new Book("9788425343537", "Ildefonso Falcones", "La catedral del mar");
        Book second = new Book("9788467009477", "Jose Maria Peridis Perez", "La luz y el misterio de las catedrales");
                     
        shows.put("9788425343537", first);
        shows.put("9788467009477", second);
    }

    public List<Book> getAll() {
        return new ArrayList<Book>(shows.values());
    }

    public void add(Book book) {
        this.shows.put(book.getIsbn(), book);
    }

    public void update(Book book) {
        if(this.shows.containsKey(book.getIsbn())) {
            Book toUpdate = this.shows.get(book.getIsbn());
            toUpdate.setAuthor(book.getAuthor());
            toUpdate.setTitle(book.getTitle());
        }
    }

    public void delete(String isbn) {
        if(this.shows.containsKey(isbn)) {
            this.shows.remove(isbn);
        }
    }

    public Book get(String isbn) {
        return this.shows.get(isbn);
    }

    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<Book>();
        for (Book item : shows.values()) {
            if(item.getTitle().toUpperCase().contains(title.toUpperCase())) result.add(item);
        }
        return result;
    }
}

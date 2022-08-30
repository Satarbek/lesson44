package model;


import java.util.ArrayList;
import java.util.List;

public class BooksListModel {

    private SampleBook book = new SampleBook("Name", "Status", "Description", "Reader");
    private List<SampleBook> books = new ArrayList<>();

    public BooksListModel(){
        books.add(new SampleBook("War & Peace", "available"));
        books.add(new SampleBook("Silent Don", "unavailable"));
        books.add(new SampleBook("Pinocchio", "unavailable"));
        books.add(new SampleBook("Java", "unavailable"));
        books.add(new SampleBook("Mathematics", "available"));

    }

    public SampleBook getBook() {
        return book;
    }

    public List<SampleBook> getBooks() {
        return books;
    }
}

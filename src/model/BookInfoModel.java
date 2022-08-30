package model;

import java.util.ArrayList;
import java.util.List;

public class BookInfoModel {

    private SampleBook book = new SampleBook("Name", "Status", "Description", "Reader");
    private List<SampleBook> books = new ArrayList<>();

    public BookInfoModel(){
        books.add(new SampleBook("War & Peace", "available", "Epic novel by Leo Nikolayevich Tolstoy.", ""));
    }

    public SampleBook getBook() {
        return book;
    }

    public List<SampleBook> getBooks() {
        return books;
    }
}

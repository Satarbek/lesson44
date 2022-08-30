package model;

public class SampleUser {

    private String name;
    private String currentBook;
    private String oldBook;

    public String getName() {
        return name;
    }

    public String getCurrentBook() {
        return currentBook;
    }

    public String getOldBook() {
        return oldBook;
    }

    public SampleUser(String name, String currentBook, String oldBook) {
        this.name = name;
        this.currentBook = currentBook;
        this.oldBook = oldBook;
    }
}

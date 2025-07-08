package Book;

public abstract class Book {

    protected String ISBN;
    protected String title;
    protected int publishingYear;

    public Book(String ISBN, String title, int publishingYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishingYear = publishingYear;

    }
    public abstract void PrintBook();

    public abstract double GetBook(GetBookDto bookDto) throws Exception;


    public int GetPublishingYear() {
        return publishingYear;
    }

    public String GetISBN() {
        return ISBN;
    }




}

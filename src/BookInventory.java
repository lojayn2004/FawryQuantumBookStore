import java.util.ArrayList;
import Book.*;


public class BookInventory {
    private ArrayList<Book> _books;

    public BookInventory() {
        _books = new ArrayList<Book>();
    }


    public void AddBook(Book book) {
        _books.add(book);

    }

    public void RemoveOutDated(int year) {
        ArrayList<Book> _removedBooks = new ArrayList<Book>();
        for(Book book: _books) {
            if(book.GetPublishingYear() < year) {
                _removedBooks.add(book);
            }
        }

        for(Book book: _removedBooks) {
            _books.remove(book);
        }
    }

    public double BuyBook(GetBookDto bookDto) throws Exception {

        Book targetBook = GetBook(bookDto.ISBN);

        if(targetBook == null)
            throw new Exception("Book is Not Found \n");
        return targetBook.GetBook(bookDto);

    }

    public Book GetBook(String isbn) {
        for(Book book: _books) {
            if(isbn.equals(book.GetISBN())) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> GetAllBooks() {
        return _books;
    }

}

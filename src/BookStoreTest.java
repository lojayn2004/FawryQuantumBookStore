
import Book.*;
import Delivery.EmailDeliveryStrategy;
import Delivery.IDeliveryStrategy;
import Delivery.ShippingDeliveryStrategy;

import java.util.ArrayList;

public  class BookStoreTest {

    private static boolean TestAddBook(BookInventory bookInventory, Book book) {
        bookInventory.AddBook(book);
        Book targetBook = bookInventory.GetBook(book.GetISBN());
        return targetBook != null;
    }

    private static boolean TestRemoveBookBefore(BookInventory bookInventory, int year) {
        // Try to remove out dated
        bookInventory.RemoveOutDated(year);

        ArrayList<Book> allBooks = bookInventory.GetAllBooks();
        for(Book book: allBooks) {
            // If there  is still books with publishing year less that the year provided
            // then there must be a problem
           if(book.GetPublishingYear() < year) {
               return false;
           }
        }

        return true;
    }


    private static void TestBuyBook(BookInventory bookInventory, GetBookDto bookDto) throws Exception {

        double price = bookInventory.BuyBook(bookDto);
        System.out.printf("Book was bought successfully with price %.2f \n\n\n", price);

    }

    public static void TestBookStore() throws Exception {
        BookInventory bookInventory = new BookInventory();
        IDeliveryStrategy emailStrategy = new EmailDeliveryStrategy();
        IDeliveryStrategy shippingStrategy = new ShippingDeliveryStrategy();

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new DemoBook("C122", "Fitness", 2012));
        books.add(new DemoBook("C123", "C++ Best Practice", 2020));
        books.add(new EBook("C124", "Java", "pdf", 2015, 100.45, emailStrategy));
        books.add(new EBook("C125", "API Design", "pdf", 2017, 100.45, emailStrategy));

        books.add(new PaperBook("C126", "API Design", 20, 2018, 50, shippingStrategy));


        // Test Adding Book
        for(Book book: books) {
            boolean res = TestAddBook(bookInventory, book);
            if(!res)
                throw new Exception("Error Ocurred While Adding Book !");
            System.out.printf("Book with isbn %s is added Successfully\n", book.GetISBN());
        }

        // Test Remove Book
        boolean res = TestRemoveBookBefore(bookInventory,2013);
        if(!res)
            throw new Exception("Error Occurred While Removing Out Dated Books");

        System.out.println("Books After Removing Out Dated Books");
        ArrayList<Book> newBooks = bookInventory.GetAllBooks();

        for(Book book: newBooks)
            book.PrintBook();

        // Test Buy Book

        // 1- Testing Paper Book Dto
        GetBookDto paperBookDto = new GetBookDto();
        paperBookDto.ISBN = "C126";
        paperBookDto.quantity = 4;
        paperBookDto.address = "123 Street, Giza, Hadayek";

        TestBuyBook(bookInventory, paperBookDto);

        // 2- Testing Paper Book Dto
        GetBookDto eBookDto = new GetBookDto();
        eBookDto.ISBN = "C124";
        eBookDto.email = "lojaynk@gmail.com";

        TestBuyBook(bookInventory, eBookDto);

        // 3- Testing Demo Book
        System.out.println("Demo Book:  ");
        GetBookDto demoBook = new GetBookDto();
        demoBook.ISBN = "C123";

        TestBuyBook(bookInventory, demoBook);

        // 4- Testing Paper Book With InSufficient quantity
        GetBookDto paperBookDto02 = new GetBookDto();
        paperBookDto02.ISBN = "C126";
        paperBookDto02.quantity = 17;
        paperBookDto02.address = "123 Street, Giza, Hadayek";
        TestBuyBook(bookInventory, paperBookDto02);

    }

}

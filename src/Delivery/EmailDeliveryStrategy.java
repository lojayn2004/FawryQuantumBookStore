package Delivery;

import Book.*;

public class EmailDeliveryStrategy implements IDeliveryStrategy {


    @Override
    public void DeliverBook(Book book, GetBookDto getBookDto) {


        System.out.printf("Sending Book with isbn %s  to %s\n", book.GetISBN(), getBookDto.email);
        EmailService.SendBook(book, getBookDto.email);
    }
}

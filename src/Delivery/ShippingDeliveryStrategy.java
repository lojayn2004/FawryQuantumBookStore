package Delivery;

import Book.*;

public class ShippingDeliveryStrategy implements IDeliveryStrategy{

    @Override
    public void DeliverBook(Book book, GetBookDto getBookDto) {
        System.out.printf("Shipping Book with isbn %s to address %s\n", book.GetISBN(), getBookDto.address);

        ShippingService.SendBook(book, getBookDto.address, getBookDto.quantity);
    }
}

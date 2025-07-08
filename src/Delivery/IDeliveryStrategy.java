package Delivery;

import Book.*;

public interface IDeliveryStrategy {

    void DeliverBook(Book book, GetBookDto getBookDto);
}

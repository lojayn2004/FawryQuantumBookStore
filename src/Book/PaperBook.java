package Book;
import Delivery.IDeliveryStrategy;

public class PaperBook extends Book {

    private int avaliableQuantity;
    private double price;
    private IDeliveryStrategy deliveryStrategy;


    public PaperBook(String ISBN,
                     String title,
                     int avaliableQuantity,
                     int pusblishYear,
                     double price,
                     IDeliveryStrategy deliveryStrategy) {
        super(ISBN, title, pusblishYear);
        this.avaliableQuantity = avaliableQuantity;
        this.deliveryStrategy = deliveryStrategy;
        this.price = price;

    }


    @Override
    public void PrintBook() {
        System.out.println("Paper book:    ");
        System.out.printf("     ISBN: %s \n", ISBN);
        System.out.printf("     Title: %s \n", title);
        System.out.printf("     Publish Year: %d \n", publishingYear);
        System.out.printf("     Avaliable Quantity: %d \n", avaliableQuantity);

    }

    @Override
    public double GetBook(GetBookDto bookDto) throws Exception {
        if(bookDto.quantity > avaliableQuantity)
            throw new Exception("Doesn't Have enough Book copies");

        if(bookDto.address == null || bookDto.address.isEmpty())
            throw new Exception("Address not valid\n");

        avaliableQuantity -= bookDto.quantity;
        deliveryStrategy.DeliverBook(this, bookDto);

        return bookDto.quantity * price;
    }
}

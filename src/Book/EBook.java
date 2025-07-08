package Book;

import Delivery.IDeliveryStrategy;

public class EBook extends Book {
    private String fileType;
    private IDeliveryStrategy deliveryStrategy;
    private double price;


    public EBook(String ISBN,
                 String title,
                 String fileType,
                 int pusblishYear,
                 double price,
                 IDeliveryStrategy deliveryStrategy) {
        super(ISBN, title, pusblishYear);
        this.fileType = fileType;
        this.price = price;
        this.deliveryStrategy = deliveryStrategy;

    }


    @Override
    public void PrintBook() {
        System.out.println("Electronic book:    ");
        System.out.printf("     ISBN: %s \n", ISBN);
        System.out.printf("     Title: %s \n", title);
        System.out.printf("     Publish Year: %d \n", publishingYear);
        System.out.printf("     File Type: %s \n", fileType);


    }

    @Override
    public double GetBook(GetBookDto bookDto) throws Exception {
        if(bookDto.email == null || bookDto.email.isBlank() || bookDto.email.isEmpty())
            throw new Exception("Email address is not valid\n");

        deliveryStrategy.DeliverBook(this, bookDto);

        return price;
    }
}

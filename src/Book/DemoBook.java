package Book;

public class DemoBook extends Book {

    public DemoBook(String ISBN, String Title, int pusblishYear) {
        super(ISBN, Title, pusblishYear);

    }

    @Override
    public void PrintBook() {
        System.out.println("Demo book:    ");
        System.out.printf("     ISBN: %s %n", ISBN);
        System.out.printf("     Title: %s %n", title);
        System.out.printf("     Publish Year: %d %n", publishingYear);

    }

    @Override
    public double GetBook(GetBookDto bookDto) {
        String msg = "Demo Book %s is ready for you!\nYou Dont Have to buy Any Thing Demo Books Are Free\n";
        System.out.println(String.format(msg, title));
        return 0.0;
    }


}

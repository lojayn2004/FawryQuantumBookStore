

public class Main {
    public static void main(String[] args) {

        try {
            BookStoreTest.TestBookStore();
        }
        catch(Exception ex) {
            // Use Ascii to print red to screen
            System.out.println("\033[0;31m" + ex.getMessage() + "\033[0;31m");
        }
    }
}
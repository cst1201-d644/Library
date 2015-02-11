package lab1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rkhatchadourian
 */
public class Library {
    
    /**
     * The hour that every library opens.
     */
    private static final String OPENING_HOUR = "9am";
    
    /**
     * The hour that every library closes.
     */
    private static final String CLOSING_HOUR = "5pm";

    /**
     * This library's street address.
     */
    private String address;
    
    /**
     * This library's collection of books.
     */
    private List<Book> bookCollection = new ArrayList();
    
    /**
     * Prints the opening hours for all libraries.
     */
    public static void printOpeningHours() {
        System.out.println("The library is open from " + OPENING_HOUR + 
                " until " + CLOSING_HOUR + ".");
    }
    
    /**
     * Creates a new library with the given street address.
     * @param streetAddress The library's address.
     */
    public Library(String streetAddress) {
        address = streetAddress;
    }
    
    /**
     * Prints this library's address.
     */
    public void printAddress() {
        System.out.println(this.address);
    }
    
    /**
     * Adds a book to this library's collection.
     * @param book The book to add.
     */
    public void addBook(Book book) {
        this.bookCollection.add(book);
    }
    
    /**
     * Print all available books at this library.
     */
    public void printAvailableBooks() {
        //For each book in this library's book collection.
        for (Book book : this.bookCollection) {
            if (!book.isBorrowed()) //if the book is available.
                System.out.println(book.getTitle()); //print its title.
        }
    }
    
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
//        System.out.println("Borrowing The Lord of the Rings:");
//        firstLibrary.borrowBook("The Lord of the Rings");
//        firstLibrary.s("The Lord of the Rings");
//        secondLibrary.borrowBook("The Lord of the Rings");
//        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
//        System.out.println("Returning The Lord of the Rings:");
//        firstLibrary.returnBook("The Lord of the Rings");
//        System.out.println();

        // Print the titles of available from the first library
//        System.out.println("Books available in the first library:");
//        firstLibrary.printAvailableBooks();
    }
}

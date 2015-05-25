package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A representation of a library of books.
 * @author <a href="mailto:rkhatchadourian@citytech.cuny.edu">Raffi Khatchadourian</a>.
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
	private final String address;

	/**
	 * This library's collection of books.
	 */
	private final List<Book> bookCollection = new ArrayList<>();

	/**
	 * Prints the opening hours for all libraries.
	 */
	public static void printOpeningHours() {
		System.out.println("The library is open from " + OPENING_HOUR
			+ " until " + CLOSING_HOUR + ".");
	}

	/**
	 * Creates a new library with the given street address.
	 *
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
	 *
	 * @param book The book to add.
	 */
	public void addBook(Book book) {
		this.bookCollection.add(book);
	}

	/**
	 * Print all available books at this library.
	 */
	public void printAvailableBooks() {
		//Books in this library that are not borrowed.
		Stream<Book> availableBooks
			= this.bookCollection.stream().filter(b -> !b.isBorrowed());

		//The titles of all such books.
		Stream<String> bookTitles = availableBooks.map(Book::getTitle);

		//Print each of the titles.
		bookTitles.forEach(System.out::println);
	}

	/**
	 * Marks a book with the given title as borrowed. This method marks a
	 * book with the given title in this library as not available (i.e.,
	 * borrowed) if the book is owned by this library and is currently
	 * available.
	 *
	 * @param title The title of the book to mark as borrowed. A search is
	 * performed in this library for a book with the given title. If the
	 * book is available, it is marked as borrowed.
	 */
	public void borrowBook(String title) {
		//Books in this library with the given title.
		Stream<Book> booksWithTitle
			= this.bookCollection.stream().filter(b -> b.getTitle().equals(title));

		//Of these, pick the ones that are available.
		Stream<Book> availableBooks = booksWithTitle.filter(b -> !b.isBorrowed());

		//Pick one of the available books with the given title.
		Optional<Book> matchingBook = availableBooks.findAny();

		//If such a book is present, mark it as rented.
		matchingBook.ifPresent(Book::rented);
	}

	/**
	 * Marks a book with the given title as returned. This method marks a
	 * book with the given title in this library as available (i.e., not
	 * borrowed) if the book is owned by this library but is currently
	 * unavailable.
	 *
	 * @param title The title of the book to mark as returned. A search is
	 * performed in this library for a book with the given title. If the
	 * book is checked out, it is marked as returned.
	 */
	public void returnBook(String title) {
		//Books in this library with the given title.
		Stream<Book> booksWithTitle
			= this.bookCollection.stream().filter(b -> b.getTitle().equals(title));

		//Of these, pick the ones that are unavailable.
		Stream<Book> unavailableBooks = booksWithTitle.filter(b -> b.isBorrowed());

		//Pick one of the unavailable books with the given title.
		Optional<Book> matchingBook = unavailableBooks.findAny();

		//If such a book is present, mark it as returned.
		matchingBook.ifPresent(Book::returned);
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
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();

		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();

		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}
}

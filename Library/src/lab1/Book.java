package lab1;

/**
 * Represents a book.
 *
 * @author <a href="mailto:rkhatchadourian@citytech.cuny.edu>Raffi
 * Khatchadourian</a>.
 */
public class Book {

	/**
	 * This book's title.
	 */
	private final String title;

	/**
	 * True if this book is checked out and false otherwise.
	 */
	private boolean borrowed;

	/**
	 * Creates a new Book
	 *
	 * @param bookTitle
	 */
	public Book(String bookTitle) {
		this.title = bookTitle;
	}

	/**
	 * Marks the book as rented
	 */
	public void rented() {
		this.borrowed = true;
	}

	/**
	 * Marks the book as not rented
	 */
	public void returned() {
		this.borrowed = false;
	}

	/**
	 * Returns true if the book is rented, false otherwise.
	 *
	 * @return True if this book is rented and false otherwise.
	 */
	public boolean isBorrowed() {
		return this.borrowed;
	}

	/**
	 * Returns the title of this book.
	 *
	 * @return This book's title.
	 */
	public String getTitle() {
		return this.title;
	}

	public static void main(String[] arguments) {
		// Small test of the Book class
		Book example = new Book("The Da Vinci Code");
		System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
		example.rented();
		System.out.println("Borrowed? (should be true): " + example.isBorrowed());
		example.returned();
		System.out.println("Borrowed? (should be false): " + example.isBorrowed());
	}
}

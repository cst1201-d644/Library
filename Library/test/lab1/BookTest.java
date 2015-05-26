package lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raffi
 */
public class BookTest {

	private final Book instance = new Book("The Da Vinci Code");

	public BookTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of rented method, of class Book.
	 */
	@Test
	public void testRented() {
		System.out.println("rented");
		assertFalse(instance.isBorrowed());
		instance.rented();
		assertTrue(instance.isBorrowed());
	}

	/**
	 * Test of returned method, of class Book.
	 */
	@Test
	public void testReturned() {
		System.out.println("returned");
		instance.returned();
		assertFalse(instance.isBorrowed());
	}

	/**
	 * Test of getTitle method, of class Book.
	 */
	@Test
	public void testGetTitle() {
		System.out.println("getTitle");
		String expResult = "The Da Vinci Code";
		String result = instance.getTitle();
		assertEquals(expResult, result);
	}

}

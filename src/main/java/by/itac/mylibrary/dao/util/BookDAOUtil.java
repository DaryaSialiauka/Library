package by.itac.mylibrary.dao.util;

import java.io.File;

import by.itac.mylibrary.entity.Book;


public class BookDAOUtil {
	
	private final static int IDBOOK = 0;
	private final static int AUTHOR = 1;
	private final static int NAMEBOOK = 2;
	private final static int YEAR = 3;

	public final static String SEPARATOR = "__ __";
	public final static File file = new File("./resources/db-home-library.txt");

	public static Book strToBook(String str) {

		String[] temp;
		Book b = null;
		if (str != null) {
			temp = str.split(SEPARATOR);
			b = new Book(Integer.parseInt(temp[IDBOOK]), temp[AUTHOR], temp[NAMEBOOK], Integer.parseInt(temp[YEAR]));
		}
		return b;
	}
	

	public static String bookToStr(Book book) {
		return SEPARATOR + book.getAuthor() + SEPARATOR + book.getTitle() + SEPARATOR + book.getYear() + '\n';
	}
	
	

}

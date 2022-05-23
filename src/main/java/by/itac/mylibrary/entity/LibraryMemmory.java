package by.itac.mylibrary.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LibraryMemmory implements Serializable {

	private static final long serialVersionUID = 1L;

	private static boolean upToDate = false;
	private static List<Book> libraryList = new ArrayList<Book>();

	private LibraryMemmory() {

	}

	public static boolean isUpToDate() {
		return upToDate;
	}

	public static void setUpToDate(boolean upToDate) {
		LibraryMemmory.upToDate = upToDate;
	}

	public static List<Book> getLibraryList() {
		return libraryList;
	}

	public void setLibraryList(List<Book> libraryList) {
		LibraryMemmory.libraryList = libraryList;
	}

}

package by.itac.mylibrary.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.dao.util.DAOReadWrite;
import by.itac.mylibrary.entity.Book;

public class FileFindBookDAO implements FindBookDAO {

	public Book find(int id) throws DAOException {

		List<Book> bookList = DAOReadWrite.readLibrary();
		Book bookTemp = null;
		int i = 0;

		while (bookTemp == null && i < bookList.size()) {
			if (bookList.get(i).getId() == id) {
				bookTemp = bookList.get(i);
			}
			i++;
		}

		return bookTemp;
	}

	public List<Book> findByTitle(String title) throws DAOException {
		List<Book> bookList = DAOReadWrite.readLibrary();
		List<Book> bookReturn = new ArrayList<Book>();

		for (Book book : bookList) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				bookReturn.add(book);
			}
		}
		return bookReturn;
	}

	public List<Book> findByAuthor(String author) throws DAOException {
		List<Book> bookList = DAOReadWrite.readLibrary();
		List<Book> bookReturn = new ArrayList<Book>();

		for (Book book : bookList) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				bookReturn.add(book);
			}
		}
		return bookReturn;
	}

}

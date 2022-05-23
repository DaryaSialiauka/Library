package by.itac.mylibrary.dao.impl;

import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.dao.util.BookDAOUtil;
import by.itac.mylibrary.dao.util.DAOReadWrite;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.entity.LibraryMemmory;

public class FileCRUDBookDAO implements CRUDBookDAO {

	public void save(Book book) throws DAOException {
		int id = nextId();
		DAOReadWrite.writeLibrary((id + BookDAOUtil.bookToStr(book)), true);
		List<Book> bookList = DAOReadWrite.readLibrary();
		book.setId(id);
		bookList.add(book);
		LibraryMemmory.setUpToDate(false);
	}

	public void update(int id, Book book) throws DAOException {

		List<Book> bookList = DAOReadWrite.readLibrary();
		String str = "";

		boolean flag = false;

		int i = 0;

		for (Book bookTemp : bookList) {
			if (bookTemp.getId() == id) {
				bookTemp = book;
				flag = true;
			}
			str = str + ++i + BookDAOUtil.bookToStr(bookTemp);
		}
		if (flag) {
			DAOReadWrite.writeLibrary(str, false);
		}
	}

	public void delete(int id) throws DAOException {

		List<Book> bookList = DAOReadWrite.readLibrary();
		String str = "";
		boolean flag = false;

		int i = 0;

		for (Book booktemp : bookList) {
			if (booktemp.getId() != id) {
				str = str + ++i + BookDAOUtil.bookToStr(booktemp);
			} else {
				flag = true;
			}
		}
		if (flag) {
			DAOReadWrite.writeLibrary(str, false);
		}
	}

	private int nextId() throws DAOException {

		List<Book> bookList = DAOReadWrite.readLibrary();

		int id = 0;
		for (Book booktemp : bookList) {
			if (id < booktemp.getId()) {
				id = booktemp.getId();
			}
		}
		return id + 1;

	}

}

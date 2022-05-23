package by.itac.mylibrary.service.impl;

import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.DAOProvider;
import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.exception.ServiceException;

public class BookServiceImpl implements BookService {

	private DAOProvider provider = DAOProvider.getInstance();
	private CRUDBookDAO daoBook = provider.getBookDAO();
	private FindBookDAO daoFind = provider.getFindDAO();

	public String save(Book book) throws ServiceException {

		String response = "";
		try {
			if (daoFind.findByAuthor(book.getAuthor()).isEmpty() && daoFind.findByTitle(book.getTitle()).isEmpty()) {
				if (book.getYear() > 1900) {
					daoBook.save(book);
					response = "Saved";
				} else {
					response = "Year is incorrect";
				}
			} else {
				response = "The book is already in the library";
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return response;
	}

	public Object findByID(int id) throws ServiceException {
		Object response = null;
		if (id < 1) {
			response = "ID is incorrect";
		} else {
			try {
				response = daoFind.find(id);
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}
		return response;
	}

	@Override
	public String delete(int id) throws ServiceException {
		String response = "";
		if (id < 1) {
			response = "ID is incorrect";
		} else {
			try {
				daoBook.delete(id);
				response = "Deleted";
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}
		return response;
	}

	@Override
	public String update(int id, Book book) throws ServiceException {
		String response = "";
		if (id < 1) {
			response = "ID is incorrect";
		} else {
			try {
				daoBook.update(id, book);
				response = "Updated";
			} catch (DAOException e) {
				throw new ServiceException(e.getMessage(), e);
			}
		}
		return response;
	}

	@Override
	public List<Book> findByTitle(String title) throws ServiceException {
		List<Book> bookList = null;
		try {
			bookList = daoFind.findByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) throws ServiceException {
		List<Book> bookList = null;
		try {
			bookList = daoFind.findByAuthor(author);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return bookList;
	}

}

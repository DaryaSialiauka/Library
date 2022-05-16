package by.itac.mylibrary.service.impl;

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

	public void save(Book book) throws ServiceException {

		try {
			daoBook.save(book);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(), e);
		}

	}

	public Book findByID(int id) throws ServiceException {
		Book b = null;
		try {
			b = daoFind.find(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		return b;
	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			daoBook.delete(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

	@Override
	public void update(int id, Book book) throws ServiceException {
		try {
			daoBook.update(id, book);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e.getMessage(), e);
		}
		
	}

}

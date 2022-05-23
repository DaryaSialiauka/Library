package by.itac.mylibrary.service;


import java.util.List;

import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.exception.ServiceException;

public interface BookService {
	
	String save(Book book) throws ServiceException;
	String delete(int id) throws ServiceException;
	String update(int id, Book book) throws ServiceException;
	Object findByID(int id) throws ServiceException;
	List<Book> findByTitle(String title) throws ServiceException;
	List<Book> findByAuthor(String title) throws ServiceException;

}

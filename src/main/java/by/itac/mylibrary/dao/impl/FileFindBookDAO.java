package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import by.itac.mylibrary.dao.FindBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileFindBookDAO implements FindBookDAO {

	private final static String SEPARATOR = "__ __";
	private File file = new File("/home-library/src/main/resources/db-home-library.txt");

	public Book find(int id) throws DAOException {

		Book b;

		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			do {
				b = strToBook(br.readLine());
			} while (b.getId() != id && b!=null);
		} catch (FileNotFoundException e) {
			throw new DAOException("Not found library", e);
		} catch (IOException e) {
			throw new DAOException("Not found book", e);
		}
		return b;
	}

	public List<Book> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Book strToBook(String str) {

		String[] temp;
		Book b = null;
		if (str != null) {
			temp = str.split(SEPARATOR);
			b = new Book(Integer.parseInt(temp[0]), temp[1], temp[2], Integer.parseInt(temp[3]));
		}
		return b;
	}

}

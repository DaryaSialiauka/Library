package by.itac.mylibrary.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itac.mylibrary.dao.CRUDBookDAO;
import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;

public class FileCRUDBookDAO implements CRUDBookDAO {

	private final static String SEPARATOR = "__ __";
	private File file = new File("/home-library/src/main/resources/db-home-library.txt");

	public void save(Book book) throws DAOException {

		try (FileWriter writer = new FileWriter(file, true)) {
			writer.write(nextId() + SEPARATOR + bookToStr(book));
			writer.close();
		} catch (FileNotFoundException e) {
			throw new DAOException("Not found library", e);
		} catch (IOException e) {
			throw new DAOException("Not saved", e);
		}
	}

	public void update(int id, Book book) throws DAOException {

		Book btemp; 
		List<Book> temp = new ArrayList<Book>();

		int i = 0;

		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader);) {

			do {
				btemp = strToBook(br.readLine());
				if (btemp != null) {
					if (btemp.getId() == id) {
						btemp = book;
					}
					temp.add(btemp);
				}
			} while (btemp != null);

			br.close();
			reader.close();
		} catch (FileNotFoundException e) {
			throw new DAOException("Not found library", e);
		} catch (IOException e) {
			throw new DAOException("Not update", e);
		}

		try (FileWriter writer = new FileWriter(file, false);) {
			for (Book b : temp) {

				writer.write(++i + SEPARATOR + bookToStr(b));
			}
			writer.close();
		} catch (FileNotFoundException e) {
			throw new DAOException("Not found library", e);
		} catch (IOException e) {
			throw new DAOException("Not update", e);
		}

	}

	public void delete(Book book) {
		// TODO Auto-generated method stub

	}

	public void delete(int id) throws DAOException {

		Book btemp;
		List<Book> temp = new ArrayList<Book>();

		int i = 0;

		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader);) {

			do {
				btemp = strToBook(br.readLine());
				if (btemp != null && btemp.getId() != id) {
					temp.add(btemp);
				}
			} while (btemp != null);

			br.close();
			reader.close();

		} catch (FileNotFoundException e) {
			throw new DAOException("Not found library", e);
		} catch (IOException e) {
			throw new DAOException("Not deleted", e);
		}

		try (FileWriter writer = new FileWriter(file, false)) {
			for (Book book : temp) {
				writer.write(++i + SEPARATOR + bookToStr(book));
			}
			writer.close();
		} catch (FileNotFoundException e) {
			throw new DAOException("Not found library", e);
		} catch (IOException e) {
			throw new DAOException("Not deleted", e);
		}

	}

	public void updateStatus(int id, int newStatus) {
		// TODO Auto-generated method stub

	}

	private int nextId() throws DAOException {

		String str1 = "";
		String str2 = "";
		Book b = new Book();

		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader);) {
			while ((str1 = br.readLine()) != null) {
				str2 = str1;
			}
			br.close();
			reader.close();
		} catch (FileNotFoundException e) {
			throw new DAOException("Not found library", e);
		} catch (IOException e) {
			throw new DAOException("Not found ID", e);
		}
		if (!str2.equals("")) {
			b = strToBook(str2);
		}

		return b.getId() + 1;

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

	private static String bookToStr(Book book) {
		return book.getAuthor() + SEPARATOR + book.getName() + SEPARATOR + book.getYear() + '\n';
	}

}

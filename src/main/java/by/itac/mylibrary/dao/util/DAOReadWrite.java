package by.itac.mylibrary.dao.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.itac.mylibrary.dao.exception.DAOException;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.entity.LibraryMemmory;

public class DAOReadWrite {

	public static List<Book> readLibrary() throws DAOException {
		List<Book> libraryList = LibraryMemmory.getLibraryList();
		String tempLine = "";
		if (!LibraryMemmory.isUpToDate()) {
			try (FileReader reader = new FileReader(BookDAOUtil.file);
					BufferedReader bufferedreader = new BufferedReader(reader)) {
				libraryList.clear();
				while ((tempLine = bufferedreader.readLine()) != null) {
					libraryList.add(BookDAOUtil.strToBook(tempLine));
				}
				LibraryMemmory.setUpToDate(true);
			} catch (FileNotFoundException e1) {
				throw new DAOException("Not found library", e1);
			} catch (IOException e2) {
				throw new DAOException("Not readed", e2);
			}
		}
		return libraryList;
	}

	public static void writeLibrary(String str, boolean append) throws DAOException {
		try (FileWriter writer = new FileWriter(BookDAOUtil.file, append);) {
			writer.write(str);
			writer.close();
		} catch (FileNotFoundException e1) {
			throw new DAOException("Not found library", e1);
		} catch (IOException e2) {
			throw new DAOException("Not writed", e2);
		}
	}

}

package by.itac.mylibrary.controller.command.impl;

import java.util.List;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindByAuthor implements Command {

	@Override
	public String execute(String request) throws ServiceException {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		String response = "";
		List<Book> bookList = null;

		try {
			String str = request.replace(CommandName.FINDBYAUTHOR.toString(), "");

			bookList = bookService.findByAuthor(str.trim());

			if (!bookList.isEmpty()) {
				for (Book book : bookList) {
					response = response + book.toString() + '\n';
				}
			} else {
				response = "Book not found";
			}
		} catch (ServiceException e) {
			response = "Book not found";
			//log
		}

		return response;
	}

}

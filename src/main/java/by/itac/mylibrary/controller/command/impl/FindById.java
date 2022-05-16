package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class FindById implements Command {

	@Override
	public String execute(String request) throws ServiceException {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		String response = null;

		try {
			String str = request.replace(CommandName.FINDBYID.toString(), "");

			Book b = bookService.findByID(Integer.parseInt(str.trim()));

			response = b.toString();
		} catch (ServiceException e) {
			response = e.getMessage();
		}

		return response;
	}
}

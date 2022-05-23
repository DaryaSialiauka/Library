package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class DeleteById implements Command {

	public String execute(String request) throws ServiceException {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		String response = null;

		try {
			String str = request.replace(CommandName.DELETEBYID.toString(), "");

			response = bookService.delete(Integer.parseInt(str.trim()));
		} catch (ServiceException e) {
			response = "Not deleted";
			//log
		}

		return response;
	}
}

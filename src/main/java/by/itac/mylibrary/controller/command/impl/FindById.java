package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
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

			Object b = bookService.findByID(Integer.parseInt(str.trim()));

			if(b!=null) {
				response = b.toString();
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

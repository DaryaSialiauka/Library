package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class Update implements Command {

	@Override
	public String execute(String request) throws ServiceException {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		String response = null;

		Book b = strToBook(request);

		try {
			response = bookService.update(b.getId(), b);
		} catch (ServiceException e) {
			response = "Not updated";
			//log
		}

		return response;
	}

	private static Book strToBook(String str) {
		Book b = new Book();

		str = str.replace(CommandName.UPDATE.toString(), "");
		String[] temp = str.split(SEPARATORBOOK);

		b.setId(Integer.parseInt(temp[0].trim()));
		b.setAuthor(temp[1].trim());
		b.setTitle(temp[2].trim());
		b.setYear(Integer.parseInt(temp[3].trim()));

		return b;
	}

}

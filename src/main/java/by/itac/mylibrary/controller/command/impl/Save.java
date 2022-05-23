package by.itac.mylibrary.controller.command.impl;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.entity.Book;
import by.itac.mylibrary.service.BookService;
import by.itac.mylibrary.service.ServiceProvider;
import by.itac.mylibrary.service.exception.ServiceException;

public class Save implements Command {

	public String execute(String request) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService service = provider.getBookService();

		String response = null;

		Book b1 = strToBook(request);

		try {
			response = service.save(b1);
		} catch (ServiceException e) {
			response = "Not saved";
			//log
		}
		return response;
	}

	private static Book strToBook(String str) {
		Book b = new Book();

		str = str.replace(CommandName.SAVE.toString(), "");
		String[] temp = str.split(SEPARATORBOOK);

		b.setAuthor(temp[0].trim());
		b.setTitle(temp[1].trim());
		b.setYear(Integer.parseInt(temp[2].trim()));

		return b;
	}

}

package by.itac.mylibrary.controller;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.exception.ControllerException;
import by.itac.mylibrary.service.exception.ServiceException;

public final class Controller {

	private final CommandProvider provider = new CommandProvider();

	private final static char SEPARATOR = ' ';

	public String executeTask(String request) throws ControllerException {
		Command command = null;
		String name = null;

		name = request.substring(0, request.indexOf(SEPARATOR));
		try {
			command = provider.getCommand(name);
		} catch (ServiceException e) {
			throw new ControllerException("", e);
		}

		String response = "";
		try {
			response = command.execute(request);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			throw new ControllerException(e);
		}

		return response;
	}

}

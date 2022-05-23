package by.itac.mylibrary.controller.command;

import by.itac.mylibrary.service.exception.ServiceException;

public interface Command {
	
	public final static char SEPARATOR = ' ';
	public final static String SEPARATORBOOK = "_\\|_";
	public final static String SEPARATORVIEW = "_|_";
	public String execute(String request) throws ServiceException;
}

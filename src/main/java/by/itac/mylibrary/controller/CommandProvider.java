package by.itac.mylibrary.controller;

import java.util.HashMap;
import java.util.Map;

import by.itac.mylibrary.controller.command.Command;
import by.itac.mylibrary.controller.command.CommandName;
import by.itac.mylibrary.controller.command.impl.DeleteById;
import by.itac.mylibrary.controller.command.impl.FindByAuthor;
import by.itac.mylibrary.controller.command.impl.FindById;
import by.itac.mylibrary.controller.command.impl.FindByTitle;
import by.itac.mylibrary.controller.command.impl.Save;
import by.itac.mylibrary.controller.command.impl.Update;
import by.itac.mylibrary.service.exception.ServiceException;

public class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
	
	public CommandProvider() {
		repository.put(CommandName.SAVE, new Save());
		repository.put(CommandName.DELETEBYID, new DeleteById());
		repository.put(CommandName.UPDATE, new Update());
		repository.put(CommandName.FINDBYID, new FindById());
		repository.put(CommandName.FINDBYTITLE, new FindByTitle());
		repository.put(CommandName.FINDBYAUTHOR, new FindByAuthor());
	}
	
	Command getCommand(String name) throws ServiceException {
		Command command = null;
		CommandName commandName = null;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		command = repository.get(commandName);
		
		return command;
	}
}

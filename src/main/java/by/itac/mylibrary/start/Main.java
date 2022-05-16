package by.itac.mylibrary.start;

import java.io.IOException;

import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.controller.command.exception.ControllerException;

public class Main {

	public static void main(String[] args) throws IOException {

		Controller c = new Controller();
		String s = null;

		try {
			//s = c.executeTask("SAVE Robert Lafore_|_Data Structures and Algorithms in Java_|_2018");
			//s = c.executeTask("UPDATE 2_|_ Robert Lafore12345_|_Data Structures and Algorithms in Java _|_2018");
			//s = c.executeTask("DELETEBYID 2");
			s = c.executeTask("FINDBYID 2");

		} catch (ControllerException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s);

	}

}

package by.itac.mylibrary.start;

import java.io.IOException;

import by.itac.mylibrary.controller.Controller;
import by.itac.mylibrary.controller.command.exception.ControllerException;

public class Main {

	public static void main(String[] args) throws IOException {

		Controller c = new Controller();
		String s = "";

		try {
			//s = s + c.executeTask("SAVE Robert Lafore4_|_Data Structures and Algorithms in Java5_|_2018");
			//s = s + c.executeTask("UPDATE 1_|_ Robert Lafore12345_|_Data Structures and Algorithms in Java _|_2018");
			s = s + c.executeTask("DELETEBYID 5");
			//s = s + c.executeTask("FINDBYID 1");
			//s = s + c.executeTask("FINDBYTITLE code");
			//s = s + c.executeTask("FINDBYAUTHOR robert");

		} catch (ControllerException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(s);

	}

}

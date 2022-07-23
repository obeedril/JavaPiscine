package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

public class Program {
    public static void main(String[] args) {

        if (args.length != 2)
        {
            System.err.println("Wrong arguments");
            System.exit(-1);
        }

//        Logic image = new Logic("/resources/image.bmb");
        Logic image = new Logic();
        image.fullArr(args[0], args[1]);
    }
}

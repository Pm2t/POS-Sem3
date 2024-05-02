package se.kth.iv1350.possem3.startup;

import se.kth.iv1350.possem3.integration.CreateExternalSys;
import se.kth.iv1350.possem3.integration.Printer;
import se.kth.iv1350.possem3.controller.Controller;
import se.kth.iv1350.possem3.view.View;

/**
 * <code>Main</code>> starts the application and sets up the necessary components needed.
 */

public class Main {

    /**
     * <code>main</code> starts the application and sets up the necessary components needed to run it.
     * @param args This application does not use command line arguments.
     */

    public static void main(String[] args) {
        CreateExternalSys creator = new CreateExternalSys();
        Printer printer = new Printer();
        Controller controller = new Controller(creator, printer);
        View view = new View(controller);

        view.simulateApplication();
    }
}
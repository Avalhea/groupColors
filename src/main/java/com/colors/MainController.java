package com.colors;

public class MainController {

        public static void main(String[] args) {
            MainController controller = new MainController();
            controller.run();
    }

    public void run() {
        Data data = Initialisation.initialize();
        Processor.process(data);
    }
}

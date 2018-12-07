package Application;

import Controller.CarController;
import View.CarView;

public class Application {


    public static void main (String[] args){
        ModelIterator modelIterator = new ModelIterator();
        CarView view = new CarView("Title", modelIterator);
        CarController carController = new CarController(view, modelIterator);
        carController.startTimer();
    }
}

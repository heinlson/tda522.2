package Application;

import Controller.CarController;
import View.CarView;

public class Application {


    public static void main (String[] args){
        ModelIterator modelIterator = new ModelIterator();
        CarView view = new CarView("CarSim 1.0", modelIterator);
        CarController carController = new CarController(view, modelIterator);
        carController.startTimer();
    }
}

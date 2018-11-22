package Main;

import Model.CarModel.TalkingCar;

import java.awt.*;


/**
 * Class with main method for running program
 *
 */
public class GUI {

    //private static void createModel(){}

    /**
     * The main method.
     * @param args Unused.
     */
    public static void main(String[] args){
        TalkingCar yaay = new TalkingCar(4,50, Color.BLACK);
        yaay.talk();


    }


}

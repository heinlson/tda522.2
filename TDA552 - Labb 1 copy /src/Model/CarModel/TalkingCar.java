package Model.CarModel;

import Model.Car;
import Model.Point;

import java.awt.*;

/**
 * Class extending Vehicle, simulating a vehicle model capable of speech.
 * <p>
 * Overrides speedFactor method, and contains unique turnRate value specific for this class.
 * Also contains static string variable MSG, representing what the vehicle can say.
 * <p>
 * See class Vehicle.
 */
public class TalkingCar extends Car {
    private final static String MSG = "brum brum!"; //A fully formed sentence

    /**
     * Fel konstruktor, fixa?
     * @param nrDoors
     * @param enginePower
     * @param color
     */
    public TalkingCar(int nrDoors, double enginePower, Color color) {
        super(nrDoors, enginePower, color, new Model.Point(1,1), new Point(1,1), 2);
    }

    /**
     * See speedFactor method in class Vehicle.
     * <p>
     * Sets speedFactor to 1% of enginePower.
     * @return speedFactor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Prints MSG
     */
    public void talk(){
        System.out.println(MSG);
    }



}

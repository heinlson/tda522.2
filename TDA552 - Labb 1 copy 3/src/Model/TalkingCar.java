package Model;

import Model.Car;

import java.awt.*;

/**
 * Class extending Car, simulating a car model capable of speech.
 * <p>
 * Overrides speedFactor method, and contains unique turnRate value specific for this class.
 * Also contains static string variable MSG, representing what the car can say.
 * <p>
 * See class Car.
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
        super(nrDoors, enginePower, color);
    }

    /**
     * See speedFactor method in class Car.
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

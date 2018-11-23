package Model;

import Model.Car;

import java.awt.*;

import static java.lang.StrictMath.*;

/**
 * Class extending Car, simulating a car model.
 * <p>
 * Overrides speedFactor method, and contains unique turnRate value specific for this class.
 * Also contains a static variable trimFactor, not inherited from super.
 * <p>
 * See class Car.
 */
public class Volvo240 extends Car {
    private final static double trimFactor = 1.25; //used in determining degree of acceleration/retardation

    /**
     * Default constructor initializing all instance variables except trimFactor, which is already initialized.
     * <p>
     * Constructor sets currentSpeed to 0 by calling stopEngine method in super, and turnRate is set to a set value.
     * All other instance variables are initialized through constructor arguments.
     * <p>
     * See default constructor in super.
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param position
     * @param direction
     */
    public Volvo240(int nrDoors, double enginePower, Color color, Point position, Point direction) {
        super(nrDoors, enginePower, color, position, direction);
        setTurnRate(PI/3);

    }

    /**
     * Constructor for instancing objects with default position and direction
     * (currently set to coordinate (100,100), and direction up.
     * Calls default constructor in class, entering the parameter variables as arguments.
     * <p>
     * See default constructor in super.
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     */
    public Volvo240(int nrDoors, double enginePower, Color color) {
        this(nrDoors, enginePower, color, new Point(100,100), new Point(0,-1));
    }

    /**
     * See speedFactor method in class Car.
     * <p>
     * Sets speedFactor to trimFactor% of enginePower.
     * As in, if trimFactor is set to 1.25, speedFactor is set to 1.25% of enginePower.
     * @return speedFactor
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }



}

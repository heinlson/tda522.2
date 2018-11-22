package Model.CarModel;

import Model.Car;
import Model.Point;

import static java.lang.StrictMath.*;
import java.awt.*;

/**
 * Class extending Vehicle, simulating a vehicle model.
 * <p>
 * Overrides speedFactor method, and contains unique turnRate value specific for this class.
 * Also contains boolean variable turboOn, which is the only instance variable not inherited from super.
 * <p>
 * See class Vehicle.
 */
public class Saab95 extends Car {

    private boolean turboOn; //if true, increases degree of acceleration/retardation.

    /**
     * Default constructor initializing all instance variables.
     * <p>
     * Constructor sets currentSpeed to 0 by calling stopEngine method in super.
     * Furthermore, turboOn is set to false, and turnRate is set to a set value.
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
    public Saab95(int nrDoors, double enginePower, Color color, Model.Point position, Model.Point direction) {
        super(nrDoors, enginePower, color, position, direction, 3);
        turboOn = false;
        setTurnRate(PI/2);
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
    public Saab95(int nrDoors, double enginePower, Color color) {
        this(nrDoors, enginePower, color, new Model.Point(100,100), new Point(0,-1));
    }


    /**
     * Sets turboOn to true.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * Sets turboOn to false.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    /**
     * See speedFactor method in class Vehicle.
     * <p>
     * Sets speedFactor to 1% of enginePower.
     * In case of turboOn being true, sets speedFactor to 1.3% of enginePower.
     * @return speedFactor
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}

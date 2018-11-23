package Model.TransportModel;

import Model.Car;
import Model.CargoBed;
import Model.Point;
import Model.TransportVehicle;

import static java.lang.StrictMath.*;
import java.awt.*;

/**
 * Class extending Car, simulating a semi truck.
 * <p>
 * Overrides speedFactor() and move() methods from super.
 * Has a CargoBed.
 * <p>
 * See class Car.
 */
public class SemiTruck extends TransportVehicle {
    private CargoBed trailer = getCargoSpace();

    /**
     * Constructor
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param position
     * @param direction
     */
    public SemiTruck(int nrDoors, double enginePower, Color color, Model.Point position, Model.Point direction) {
        super(nrDoors, enginePower, color, position, direction, 8);
        setTurnRate(PI/5);
    }

    /**
     * See speedFactor method in super (class Vehicle).
     * @return speedFactor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    /**
     * Removes Car instance from last index in cargo space.
     */
    @Override
    public void unloadCar(){
        if(getRampExtended()){
            Car car = (Car) trailer.unloadCargo(trailer.size()-1);
            car.setPosition(new Point(this.getPosition().getX()+5,this.getPosition().getY()+5));
        }else {
            //does nothing yet
        }
    }


    /**
     * Calls move() method in super (Class TransportVehicle).
     *
     * See move() (in TransportVehicle).
     */
    @Override
    public void move(){
        super.move();
    }


}

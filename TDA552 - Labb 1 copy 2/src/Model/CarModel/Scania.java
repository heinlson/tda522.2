package Model.CarModel;

import Model.Car;
import Model.CargoBed;
import Model.Point;

import java.awt.*;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.multiplyExact;


/**
 * Class extending Car, simulating a truck of brand Scania.
 * <p>
 * Overrides speedFactor() and move() methods from super.
 * Has a CargoBed.
 * <p>
 * See class Car.
 */
public class Scania extends Car {
    private final CargoBed bed; //flatbed
    private int bedAngle; //Angle in degrees


    /**
     * Constructor. Initiates instance variables to values given in argument.
     * Sets angle of bed to 0, and turnRate to a set value.
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param position
     * @param direction
     */
    public Scania(int nrDoors, double enginePower, Color color, Model.Point position, Point direction) {
        super(nrDoors, enginePower, color, position, direction, 6);
        bed = new CargoBed();
        bedAngle=0;
        setTurnRate(PI/2);
    }


    /**
     * See speedFactor method in class Vehicle.
     * @return speedFactor
     */
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    /**
     * Sets angle of bed to argument (in degrees) given.
     * @param d
     */
    public void setBedAngle(int d){
        if(getCurrentSpeed() == 0){
            bedAngle=d;
        }else{
            //do nothing
        }
    }


    /**
     * If angle of bed is 0, calls move() function of super (abstract Class Vehicle)
     * See move() in Vehicle.
     */
    @Override
    public void move(){
        if (isAllowedToMove()){
        Scania.super.move();
        } else{
            //do nothing
            //system out med ett massage
        }
    }


    /**
     * If angle of bed is higher than 70, sets it to 70,
     * and if it's lower than 0, sets it to 0.
     */
    private void checkAngle(){
        if (bedAngle> 70){
            bedAngle=70;
        }else if (bedAngle < 0 ){
             bedAngle=0;
        }
    }


    /**
     * Checks if bed angle is at 0.
     * @return boolean value
     */
    private boolean isAllowedToMove(){
       return(bedAngle == 0);  //is angle 0?
    }



}

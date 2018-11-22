package Model;

import java.awt.*;
import static java.lang.StrictMath.*;

/**
 * Car is the abstract base class for all car models.
 * <p>
 * A car has a set amount of doors, color, position, direction of movement,
 * a set degree of turn rate unique for each model, current speed variable, and a set engine power.
 * <p>
 * The class mainly contains various methods for allowing movement of the vehicle,
 * including: a method move; methods for turning; starting and stopping the engine;
 * as well as methods used in changing the current speed.
 *
 */
public abstract class Car implements Movable {

    //Exception message used for restricting acceleration and retardation of vehicle
    //@see gas, brake and checkArgument methods
    final static String INVALID_ARG = "Invalid argument in gas or break method. Try values [0, 1]";

    //Appearance
    private final int nrDoors; // Number of doors on the car
    private Color color; // Color of the car

    /*
    Variables for movement
     */

    //Speed
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car

    //Location
    private final Point position = new Point(); //Current position.

    //Turning
    private final Point direction = new Point(); //Vector for direction (on Unit circle)
    private double turnRate; //degree of turn rate given in radians. Unique for each car model (i.e. subclasses)



   /*
   Constructors
    */

    /**
     * Default constructor initializing all instance variables except for turnRate,
     * which is instead initialized by each class extending Car.
     * <p>
     * Constructor sets currentSpeed to 0 by calling stopEngine method.
     * All other instance variables are initialized through constructor arguments.
     * Method checkDirection is used in constructor to correct direction given
     * in argument if needed.
     * <p>
     * See methods stopEngine and checkDirection.
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param position
     * @param direction
     */
    public Car(int nrDoors, double enginePower, Color color, Point position, Point direction){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.position.setPoints(position);
        this.direction.setPoints(direction);
        stopEngine();
        checkDirection();
    }


    /**
     * Constructor for instancing objects with default position and direction
     * (currently set to coordinate (100,100), and direction up.
     * Calls default constructor, entering the parameter variables as arguments.
     * <p>
     * See default constructor.
     *
     * @param nrDoors
     * @param enginePower
     * @param color
     */
    public Car(int nrDoors, double enginePower, Color color) {
        this(nrDoors,enginePower,color, new Point(100,100), new Point(0,-1));
    }



      /*
    Getters and setters
     */

    /**
     *
     * @return nrDoors
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     *
     * @return enginePower
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     *
     * @return currentSpeed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     *
     * @return color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets color of car to argument given (clr).
     * @param clr
     */
    public void setColor(Color clr){
        color = clr;
    }

    /**
     * Sets degree of turn rate to inputted value (given in radians).
     * @param turnRate
     */
    public void setTurnRate(double turnRate) {
        this.turnRate = turnRate;
    }

    /**
     *
     * @return turnRate
     */
    public double getTurnRate() { return turnRate; }


    /**
     *
     * @return direction
     */
    public Point getDirection() { return direction; }


    /**
     *
     * @return position
     */
    public Point getPosition() { return position; }

    /**
     *
     * Sets position of car to position given (pos)
     * @param pos
     */
    public void setPosition(Point pos){
        position.setPoints(pos);
    }

     /*
     Methods for setting and changing speed
     */

    /**
     * Sets currentSpeed to 0.1, simulating the engine starting.
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets currentSpeed to 0, simulating the engine being turned off.
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Abstract method used for setting a speed factor unique to each car model (i.e. class extending car).
     * Return value determines the degree of acceleration/retardation in methods increment/decrementSpeed.
     *
     * @return speedFactor
     */
    protected abstract double speedFactor();

    /**
     * Increments currentSpeed by speedFactor (see speedFactor method) multiplied by argument value.
     * Also prevents currentSpeed from exceeding enginePower.
     * @param amount
     */
    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;

        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        }

    }

    /**
     * Decrements currentSpeed by speedFactor (see speedFactor method) multiplied by argument value.
     * Also prevents currentSpeed from being less than 0.
     * @param amount
     */
    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;

        if(currentSpeed < 0){
            currentSpeed = 0;
        }
    }

    /**
     * Calls method incrementSpeed using value given as argument.
     * Also calls method checkArgument to see if given argument is acceptable (is in interval [0,1]).
     * <p>
     * See methods incrementSpeed and checkArgument.
     *
     * @param amount
     */
    public void gas(double amount){
        checkArgument(amount);
        incrementSpeed(amount);
    }

    /**
     * Calls method decrementSpeed using value given as argument.
     * Also calls method checkArgument to see if given argument is acceptable (is in interval [0,1]).
     * <p>
     * See methods decrementSpeed and checkArgument.
     *
     * @param amount
     */
    public void brake(double amount){
        checkArgument(amount);
        decrementSpeed(amount);
    }


    /*
    Methods for moving
     */

    /**
     * Sets x and y position of car to the respective coordinates of the direction vector multiplied by currentSpeed.
     */
    @Override
    public void move() {
        double nextX = position.getX() + direction.getX() *currentSpeed;
        double nextY = position.getY() + direction.getY() *currentSpeed;

        position.setPoints(nextX, nextY);
    }

    /**
     *  Method for changing car'semitruck direction to the left by the radians given by model of car.
     *
     */
    @Override
    public void turnLeft() {
        double nextX = direction.getX() *cos(turnRate)- direction.getY() *sin(turnRate);
        double nextY = direction.getX() *sin(turnRate)+ direction.getY() *cos(turnRate);

        direction.setPoints(nextX,nextY);
    }

    /**
     *  Method for changing car'semitruck direction to the right by the radians given by model of car.
     *
     */
    @Override
    public void turnRight() {
        double rightTurnRate = 2*PI-turnRate;

        double nextX = direction.getX() *cos(rightTurnRate)- direction.getY() *sin(rightTurnRate);
        double nextY = direction.getX() *sin(rightTurnRate)+ direction.getY() *cos(rightTurnRate);

        direction.setPoints(nextX,nextY);
    }


    /**
     * Method for correcting length of the direction vector using unit vectors
     *
     */
    private void checkDirection(){
        double dxSquared = pow(direction.getX(), 2);
        double dySquared = pow(direction.getY(),2);

        if(!(dxSquared + dySquared == 1)){
            double directionLength = sqrt(dxSquared + dySquared);
            //unitVector variable below corrects length of the direction vector
            Point unitVector = new Point(direction.getX()/directionLength, direction.getY()/directionLength);

            direction.setPoints(unitVector);
        }
    }



    /**
     * Method for throwing exception if double value in argument is outside of interval [0, 1]
     * @param argument  (double)
     *
     */
    private void checkArgument(double argument){
        if (argument < 0 || argument > 1){
            throw new RuntimeException(INVALID_ARG);
        }
    }





}

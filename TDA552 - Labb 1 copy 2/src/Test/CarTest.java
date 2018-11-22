package Test;

import Model.Car;
import Model.CarModel.Volvo240;
import Model.CargoBed;
import Model.Point;
import Model.TransportModel.SemiTruck;
import Model.Vehicle;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    Car car = new Volvo240(4, 100, Color.BLACK);


    /*
    @Test
    void getNrDoors() {
        assertEquals(vehicle.getNrDoors(), 4);
    }

    @Test
    void getEnginePower() {
        assertEquals(vehicle.getEnginePower(), 100);
    }

    @Test
    void getCurrentSpeed() {
            assertEquals(vehicle.getCurrentSpeed(), 0);
    }

    @Test
    void getColor() {
        assertEquals(vehicle.getColor(), Color.BLACK);
    }

    @Test
    void setColor() {
        vehicle.setColor(Color.RED);
        assertEquals(vehicle.getColor(), Color.RED);
    }

    @Test
    void getTurnRate(){
        assertEquals(vehicle.getTurnRate(), PI/3);
    }

    @Test
    void setTurnRate() {
        vehicle.setTurnRate(5.4);
        assertEquals(vehicle.getTurnRate(), 5.4);
    }

    @Test
    void startEngine() {
        vehicle.startEngine();
        assertEquals(vehicle.getCurrentSpeed(), 0.1);
    }

    @Test
    void stopEngine() {
        vehicle.stopEngine();
        assertEquals(vehicle.getCurrentSpeed(), 0);
    }

    @Test
    void speedFactor() {
        assertEquals(vehicle.speedFactor(), 1.25);
    }


    @Test
    void checkArgument() {

        try{
            vehicle.gas(2);
        } catch(RuntimeException e){
            System.out.println(e.getMessage().equals(Vehicle.INVALID_ARG));
        }


        try{
            vehicle.brake(4);
        } catch(RuntimeException e){
            System.out.println(e.getMessage().equals(Vehicle.INVALID_ARG));
        }
    }


    @Test
    void gas(){
        vehicle.gas(0.5);
        assertEquals(1.25*0.5, vehicle.getCurrentSpeed());

    }

    @Test
    void brake() {
        vehicle.gas(1);
        vehicle.brake(0.5);
        assertEquals(1.25*0.5, vehicle.getCurrentSpeed());

    }

    @Test
    void move() {
        vehicle.gas(1);

        vehicle.move();
        assertEquals(100+0*1.25 ,vehicle.getPosition().getX() );
        assertEquals(100+(-1)*1.25 ,vehicle.getPosition().getY() );


    }

    @Test
    void turnLeft() {
        vehicle.turnLeft();
        assertEquals(vehicle.getDirection().getX(), 0*cos(PI/3)-(-1)*sin(PI/3));
        assertEquals(vehicle.getDirection().getY(), 0*sin(PI/3)+(-1)*cos(PI/3));
    }

    @Test
    void turnRight() {
        vehicle.turnRight();
        assertEquals(vehicle.getDirection().getX(), 0*cos((5*PI)/3)-(-1)*sin((5*PI)/3));
        assertEquals(vehicle.getDirection().getY(), 0*sin((5*PI)/3)+(-1)*cos((5*PI)/3));
    }

    @Test
    void checkDirection(){
        Vehicle c = new Saab95(4, 100, Color.BLUE, new Point(10,10), new Point(1,1));

        //assertEquals(c.getDirection().getX(), sqrt(2)/2);
        //assertEquals(c.getDirection().getY(), sqrt(2)/2);

        Vehicle c2 = new Saab95(4, 100, Color.BLUE, new Point(10,10), new Point(0,2));

        assertEquals(c2.getDirection().getX(), 0);
        assertEquals(c2.getDirection().getY(), 1);
    }

    @Test
    void Constructor(){
        Vehicle c = new Saab95(4, 100, Color.BLUE);

    }*/




    //Labb 2
    Point p = new Point(1,1);

    SemiTruck semitruck = new SemiTruck(2, 100, Color.BLUE, p, p);
    String msg = "Is loaded vehicle correct after it's set to loadable?"; //TODO ändra msg
    String msg2 = "expected: true, actual: ";

    @Test
    void isLoadable(){
        System.out.println("Is vehicle loadable? expected: false, actual: " + semitruck.isLoadable(car));
    }


    @Test
    void loadCar(){
        //Allow for loading
        semitruck.extendRamp();

        //Make vehicle loadable
        car.setPosition(semitruck.getPosition());

        //Load vehicle
        semitruck.loadCar(car);

        //Check if all conditions are met
        System.out.println(msg +" "+ semitruck.getCargoSpace().get(0).toString().equals(car.toString()));

        assertEquals(semitruck.getCargoSpace().get(0).toString(), car.toString());


    }


    @Test
    void unloadCar(){
        //Allow for unloading
        semitruck.extendRamp();

        //Make vehicle loadable
        car.setPosition(semitruck.getPosition());


        //Load extra object to confirm that all is correct
        semitruck.getCargoSpace().addCargo(1);

        //Load vehicle
        semitruck.loadCar(car);

        //Unload vehicle which was just loaded, leaving a "1" in the cargo
        semitruck.unloadCar();

        //Check results
        if(semitruck.getCargoSpace().get(0).equals(1)){
            System.out.println("Unload is working as expected");
        }else{
            System.out.println("Object " + semitruck.getCargoSpace().get(0) + " should have been removed but wasn't");
        }


        assertEquals(semitruck.getCargoSpace().get(0),1);
    }


    //TODO add an additional vehicle to trailer to actually check if ALL cars move
    @Test
    void move(){
        //Allow for loading
        semitruck.extendRamp();

        //Make vehicle loadable
        car.setPosition(semitruck.getPosition());

        //Load vehicle
        semitruck.loadCar(car);

        //Perform action
        semitruck.move();

        //Check that vehicle has also moved
        System.out.println("move: " + msg2 + semitruck.getPosition().toString().equals(car.getPosition().toString()));

        assertEquals(semitruck.getPosition().toString(), car.getPosition().toString());

    }

}
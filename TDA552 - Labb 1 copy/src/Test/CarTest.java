package Test;

import Model.*;
import Model.Point;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.StrictMath.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    Car car = new Volvo240(4, 100, Color.BLACK);


    /*
    @Test
    void getNrDoors() {
        assertEquals(car.getNrDoors(), 4);
    }

    @Test
    void getEnginePower() {
        assertEquals(car.getEnginePower(), 100);
    }

    @Test
    void getCurrentSpeed() {
            assertEquals(car.getCurrentSpeed(), 0);
    }

    @Test
    void getColor() {
        assertEquals(car.getColor(), Color.BLACK);
    }

    @Test
    void setColor() {
        car.setColor(Color.RED);
        assertEquals(car.getColor(), Color.RED);
    }

    @Test
    void getTurnRate(){
        assertEquals(car.getTurnRate(), PI/3);
    }

    @Test
    void setTurnRate() {
        car.setTurnRate(5.4);
        assertEquals(car.getTurnRate(), 5.4);
    }

    @Test
    void startEngine() {
        car.startEngine();
        assertEquals(car.getCurrentSpeed(), 0.1);
    }

    @Test
    void stopEngine() {
        car.stopEngine();
        assertEquals(car.getCurrentSpeed(), 0);
    }

    @Test
    void speedFactor() {
        assertEquals(car.speedFactor(), 1.25);
    }


    @Test
    void checkArgument() {

        try{
            car.gas(2);
        } catch(RuntimeException e){
            System.out.println(e.getMessage().equals(Car.INVALID_ARG));
        }


        try{
            car.brake(4);
        } catch(RuntimeException e){
            System.out.println(e.getMessage().equals(Car.INVALID_ARG));
        }
    }


    @Test
    void gas(){
        car.gas(0.5);
        assertEquals(1.25*0.5, car.getCurrentSpeed());

    }

    @Test
    void brake() {
        car.gas(1);
        car.brake(0.5);
        assertEquals(1.25*0.5, car.getCurrentSpeed());

    }

    @Test
    void move() {
        car.gas(1);

        car.move();
        assertEquals(100+0*1.25 ,car.getPosition().getX() );
        assertEquals(100+(-1)*1.25 ,car.getPosition().getY() );


    }

    @Test
    void turnLeft() {
        car.turnLeft();
        assertEquals(car.getDirection().getX(), 0*cos(PI/3)-(-1)*sin(PI/3));
        assertEquals(car.getDirection().getY(), 0*sin(PI/3)+(-1)*cos(PI/3));
    }

    @Test
    void turnRight() {
        car.turnRight();
        assertEquals(car.getDirection().getX(), 0*cos((5*PI)/3)-(-1)*sin((5*PI)/3));
        assertEquals(car.getDirection().getY(), 0*sin((5*PI)/3)+(-1)*cos((5*PI)/3));
    }

    @Test
    void checkDirection(){
        Car c = new Saab95(4, 100, Color.BLUE, new Point(10,10), new Point(1,1));

        //assertEquals(c.getDirection().getX(), sqrt(2)/2);
        //assertEquals(c.getDirection().getY(), sqrt(2)/2);

        Car c2 = new Saab95(4, 100, Color.BLUE, new Point(10,10), new Point(0,2));

        assertEquals(c2.getDirection().getX(), 0);
        assertEquals(c2.getDirection().getY(), 1);
    }

    @Test
    void Constructor(){
        Car c = new Saab95(4, 100, Color.BLUE);

    }*/




    //Labb 2
    Model.Point p = new Point(100,100);
    SemiTruck semitruck = new SemiTruck(2, 100, Color.BLUE, p, p, new CargoBed(new ArrayList<>()));
    String msg = "Is loaded car correct after it's set to loadable?"; //TODO ändra msg
    String msg2 = "expected: true, actual: ";
    Scania scania = new Scania(2, 100, Color.BLUE, p, p, new ArrayList<>());

    @Test
    void move2(){
        scania.setBedAngle(3);
        scania.move();
    }

    @Test
    void isLoadable(){
        System.out.println("Is car loadable? expected: false, actual: " + semitruck.isLoadable(car));
    }


    @Test
    void loadCar(){
        //Allow for loading
        semitruck.extendRamp();

        //Make car loadable
        car.setPosition(semitruck.getPosition());

        //Load car
        semitruck.loadCar(car);

        //Check if all conditions are met
        System.out.println(msg +" "+ semitruck.getTrailer().get(0).toString().equals(car.toString()));

        assertEquals(semitruck.getTrailer().get(0).toString(),car.toString());


    }


    @Test
    void unloadCar(){
        //Allow for unloading
        semitruck.extendRamp();

        //Make car loadable
        car.setPosition(semitruck.getPosition());


        //Load extra object to confirm that all is correct
        semitruck.getTrailer().addCargo(1);

        //Load car
        semitruck.loadCar(car);

        //Unload car which was just loaded, leaving a "1" in the cargo
        semitruck.unloadCar();

        //Check results
        if(semitruck.getTrailer().get(0).equals(1)){
            System.out.println("Unload is working as expected");
        }else{
            System.out.println("Object " + semitruck.getTrailer().get(0) + " should have been removed but wasn't");
        }


        assertEquals(semitruck.getTrailer().get(0),1);
    }


    //TODO add an additional car to trailer to actually check if ALL cars move
    @Test
    void move(){
        //Allow for loading
        semitruck.extendRamp();

        //Make car loadable
        car.setPosition(semitruck.getPosition());

        //Load car
        semitruck.loadCar(car);

        //Perform action
        semitruck.move();

        //Check that car has also moved
        System.out.println("move: " + msg2 + semitruck.getPosition().toString().equals(car.getPosition().toString()));

        assertEquals(semitruck.getPosition().toString(),car.getPosition().toString());

    }

}
package Model;

import java.awt.*;

public class CarFerry implements Movable{
    private  SemiTruck parent;

    public void CarFerry(int enginePower, Color color, Point pos, Point dir, CargoBed deck){
        parent = new SemiTruck(0, enginePower, color, pos, dir, deck);
    }

    //Delegation
    public void extendRamp(){
        parent.extendRamp();
    }

    public void retractRamp(){
        parent.retractRamp();
    }

    public boolean isLoadable(Car car){
        return parent.isLoadable(car);
    }

    public void unloadCar(){
        parent.unloadCar();
    }

    public void loadCar(Car car){
        parent.loadCar(car);
    }

    @Override
    public void move() {
        parent.move();
    }

    @Override
    public void turnLeft() {
        parent.turnLeft();
    }

    @Override
    public void turnRight() {
        parent.turnRight();
    }
}

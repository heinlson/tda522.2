package Model;

import static java.lang.StrictMath.*;
import java.awt.*;

/**
 * långtradare
 */

//Redan lastad?
//Capacity
//Size (inte för stor)
//Constructor
//fingör
public class SemiTruck extends Car {
    private boolean rampIsExtended;

    private CargoBed trailer;

    public SemiTruck(int nrDoors, double enginePower, Color color, Point position, Point direction, CargoBed trailer) {
        super(nrDoors, enginePower, color, position, direction);
        this.trailer = trailer;
        rampIsExtended=false;
        setTurnRate(PI/5);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public CargoBed getTrailer(){
        return trailer;
    }

    public void extendRamp(){
        if(getCurrentSpeed()==0){
            rampIsExtended = true;
        }
    }

    public void retractRamp(){
        rampIsExtended = false;
    }

    public boolean isLoadable(Car car){
        if (rampIsExtended == true && this.getPosition() == car.getPosition()){
            return true;
        }else{
            return false;
        }
    }


    public void unloadCar(){
        if(rampIsExtended == true){
            Car car = (Car) trailer.unloadCargo();
            car.setPosition(new Point(this.getPosition().getX()+5,this.getPosition().getY()+5));
        }else {
            //does nothing yet
        }
    }

    public void loadCar(Car car){
        if(!(car.equals(this) && isLoadable(car))&& rampIsExtended == true){
            car.stopEngine();
            trailer.addCargo(car);
        }
    }

    @Override
    public void move(){
        super.move();
        for (int i = 0; i < trailer.size(); i++){
            Car car = (Car) trailer.get(i);
            car.setPosition(this.getPosition());
        }
    }











}

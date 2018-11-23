package Model;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.StrictMath.PI;


/**
 *
 */
public class Scania extends Car {
    private CargoBed bed;
    private int bedAngle;


    public Scania(int nrDoors, double enginePower, Color color, Point position, Point direction, ArrayList<Object> cargo) {
        super(nrDoors, enginePower, color, position, direction);
        bedAngle=0;
        setTurnRate(PI/2);
        //bed.addCargo(cargo);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    public void setBedAngle(int d){
        if(getCurrentSpeed() == 0){
            bedAngle=d;
        }else{
            //do nothing
        }
        checkAngle();
    }

    //Methods for pickUpBed
    @Override
    public void move(){
        if (isAllowedToMove()){
        Scania.super.move();
        } else{
            System.out.println(this + " Check angle of cargobed");
        }
    }



    private void checkAngle(){
        if (bedAngle> 70){
            bedAngle=70;
        }else if (bedAngle < 0 ){
             bedAngle=0;
        }
    }

    private boolean isAllowedToMove(){
       return(bedAngle == 0);  //is angle 0?
    }



}

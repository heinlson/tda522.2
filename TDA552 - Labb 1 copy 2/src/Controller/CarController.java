package Controller;
import Model.CarModel.*;
import Application.ModelIterator;
import Model.Vehicle;
import View.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

    private ModelIterator iterator;

    private int raiseAmount = 10; //Increments/Decrements flatbed with 10 degrees


    public CarController(CarView view, ModelIterator iterator){
        frame = view;
        this.iterator = iterator;
        setActionListeners();
    }

    public void startTimer(){
        timer.start();
    }

    //methods:



    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : iterator) {
                car.move();
                frame.getDrawPanel().repaint();
            }
        }
    }




    // Actionlisteners


    private void setActionListeners() {
        frame.getGasButton().addActionListener(e -> gas(frame.getGasAmount()));

        frame.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.getGasAmount());
            }
        });

        frame.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });


        frame.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });

        frame.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBedAngle(raiseAmount);
            }
        });


        frame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAllCars();
            }
        });


        frame.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAllCars();
            }
        });

        frame.getTalkButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speak();
            }
        });
    }




    //--------------Methods for user input-------------------------


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : iterator) {
            car.gas(gas);
        }

    }


    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : iterator){
            car.brake(brake);
        }
    }


    void setTurboOn(){
        for (Vehicle car : iterator){
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff(){
        for (Vehicle car : iterator){
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void setBedAngle(int amount){
        for (Vehicle car : iterator){
            if(car instanceof Scania){
                ((Scania) car).setBedAngle(amount);
            }
        }
    }

    void speak(){
        for (Vehicle car : iterator){
            if(car instanceof TalkingCar){
                ((TalkingCar) car).speak();
            }
        }
    }

    void startAllCars(){
        for (Vehicle car : iterator){
            car.startEngine();
        }
    }

    void stopAllCars(){
        for (Vehicle car : iterator){
            car.stopEngine();
        }
    }


}
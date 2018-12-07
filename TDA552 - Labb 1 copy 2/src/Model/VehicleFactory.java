package Model;


import Model.CarModel.*;

public class VehicleFactory {

    public static Volvo240 makeVolvo(){
        return new Volvo240();
    }

    public static Saab95 makeSaab(){
        return new Saab95();
    }

    public static Scania makeScania(){
        return new Scania();
    }

    public static TalkingCar makeTalkingCar() {
        return new TalkingCar();
    }


}

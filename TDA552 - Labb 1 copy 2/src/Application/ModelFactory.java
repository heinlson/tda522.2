package Application;

import Model.CarModel.Saab95;
import Model.CarModel.Scania;
import Model.CarModel.TalkingCar;
import Model.CarModel.Volvo240;
import Model.Vehicle;
import Model.VehicleFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ModelFactory {

    static List<Vehicle> createModel(){
        Random r = new Random();
        List<Vehicle> list = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            // Nämen se vilken fin kod
            list.add(r.nextBoolean() ? (r.nextBoolean() ? VehicleFactory.makeSaab() :  VehicleFactory.makeVolvo()) : (r.nextBoolean() ? VehicleFactory.makeScania() : VehicleFactory.makeScania()));
        }

        return list;
    }


}

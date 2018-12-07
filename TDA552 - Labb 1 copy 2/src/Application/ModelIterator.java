package Application;

import Model.Vehicle;

import java.util.Iterator;
import java.util.List;

public class ModelIterator implements Iterable<Vehicle> {

    private List<Vehicle> vehicles;

    public ModelIterator(){
        vehicles = ModelFactory.createModel();
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new Iterator<Vehicle>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < vehicles.size();
            }

            @Override
            public Vehicle next() {
                return vehicles.get(index++);
            }
        };
    }
}

package Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CargoBed {
    private ArrayList<Object> bed;


    public CargoBed(ArrayList<Object> bed) {
        this.bed = bed;
    }

    public void addCargo(Object o){
        bed.add(0, o);
    }

    public Object unloadCargo(){
        Object tmp = bed.get(0);
        bed.remove(0);
        return tmp;
    }

    public int size(){
        return bed.size();
    }

    public Object get(int i){
        return bed.get(i);
    }


}

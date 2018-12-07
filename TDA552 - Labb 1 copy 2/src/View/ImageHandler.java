package View;

import Application.ModelIterator;
import Model.Vehicle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Är public, för att, annars fungerar inte resten av koden!
class ImageHandler {

    private Map<Class, BufferedImage> classImageMap = new HashMap<>();
    private ModelIterator modelIterator;

    public ImageHandler(ModelIterator modelIterator ){
        this.modelIterator = modelIterator;
        initMap();
    }

    public Map<Class, BufferedImage> getClassImageMap() {
        return classImageMap;
    }

    public ModelIterator getModelIterator() {
        return modelIterator;
    }

    private void initMap(){
        for(Vehicle vehicle : modelIterator){
            if(!classImageMap.keySet().contains(vehicle.getClass())) {
                connectVehicleToImage(vehicle);
            }
        }
    }

    private void connectVehicleToImage(Vehicle vehicle){
        try{
            classImageMap.put(vehicle.getClass(),
                    ImageIO.read(new File("src\\pics\\" +
                            vehicle.getClass().getSimpleName() +
                            ".jpg")));
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }
}

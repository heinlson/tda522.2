package View;
import Model.CarModel.Car;
import Model.CarModel.Saab95;
import Model.CarModel.Scania;
import Model.CarModel.Volvo240;
import Model.Point;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //Used for rendering images
    private final Map<Car, Point> carPosition = new HashMap<>();
    private final Map<Class, BufferedImage> objectImage = new HashMap<>();
    private List<Car> cars = new ArrayList<>();


    //Image variables
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "src\\pic" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // Rememember to rightclick src New -> Package -> name: pic -> MOVE *.jpg to pic.
            // if you are starting in IntelliJ.
            // Linux users need to modify \ to / in path string
            volvoImage = ImageIO.read(new File("src\\pics\\Volvo240.jpg"));
            saabImage = ImageIO.read(new File("src\\pics\\Saab95.jpg"));
            scaniaImage = ImageIO.read(new File("src\\pics\\Scania.jpg"));

            objectImage.put(Volvo240.class, volvoImage);
            objectImage.put(Saab95.class, saabImage);
            objectImage.put(Scania.class, scaniaImage);

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    /**
     * Adds argument to car list if not already there, and maps the car instance to it's position
     * @param car
     *
     * See addCarToList() and mapCarToPosition()
     */
    void moveit(Car car){
        addCarToList(car);
        mapCarToPosition(car);
    }

    /**
     * Maps car to it's position
     * @param car
     */
    public void mapCarToPosition(Car car) {
        if(!carPosition.containsKey(car)){
            carPosition.put(car, car.getPosition());
        }
    }

    /**
     * Adds car to car list if not already there
     * @param car
     */
    private void addCarToList(Car car) {
        if(!cars.contains(car)) {
            cars.add(car);
        }
    }




    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderCar(g);
    }


    /**
     * Renders cars in car list to their current position on panel
     * @param g
     */
    private void renderCar(Graphics g) {
        for(Car car : cars){
            BufferedImage carImage = objectImage.get(car.getClass()); //Image of car
            int xPosition = (int)carPosition.get(car).getX();
            int yPosition = (int)carPosition.get(car).getY();

            g.drawImage(carImage, xPosition, yPosition, null);
;        }
    }
}
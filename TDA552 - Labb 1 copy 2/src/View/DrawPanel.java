package View;
import Application.ModelIterator;
import Model.Point;
import Model.Vehicle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //Used for rendering images
    private final Map<Vehicle, Point> carPositions = new HashMap<>();
    private List<Vehicle> cars = new ArrayList<>();
    private ImageHandler handler;





    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ModelIterator model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        handler = new ImageHandler(model);

        // Print an error message in case file is not found with a try/catch block


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        renderVehicle(g);
    }


    /**
     * Renders cars in car list to their current position on panel
     * @param g
     */
    private void renderVehicle(Graphics g) {
        for(Vehicle vehicle : handler.getModelIterator()){
            BufferedImage carImage = handler.getClassImageMap().get(vehicle.getClass()); //Image of vehicle
            int xPosition = (int) vehicle.getPosition().getX();
            int yPosition = (int) vehicle.getPosition().getY();

            g.drawImage(carImage, xPosition, yPosition, null);
;        }
    }
}
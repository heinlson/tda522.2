package View;
import Application.ModelIterator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarView extends JFrame{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;

    private int gasAmount = 0;

    private DrawPanel drawPanel;

    private JPanel controlPanel = new JPanel();

    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();

    private JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");
    private JButton talkButton = new JButton("Speak");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");

    public JButton getGasButton() {
        return gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public JButton getTurboOnButton() {
        return turboOnButton;
    }

    public JButton getTurboOffButton() {
        return turboOffButton;
    }

    public JButton getLiftBedButton() {
        return liftBedButton;
    }

    public JButton getLowerBedButton() {
        return lowerBedButton;
    }

    public JButton getTalkButton() {
        return talkButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    // Constructor
    public CarView(String framename, ModelIterator model){
        drawPanel = new DrawPanel(FRAME_WIDTH, FRAME_HEIGHT-240, model);
        initComponents(framename);

    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);

        //User input stuff
        setSpinnerModel(0, 0, 100, 1);
        setPanelLayout();

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * Creates spinner model with preferred start, min, max and step values
     */
    private void setSpinnerModel(int startValue, int minValue, int maxValue, int stepSize) {
        SpinnerModel spinnerModel = getSpinnerModel(startValue, minValue, maxValue, stepSize);
        updateSpinnerState(spinnerModel);
    }

    /**
     * Creates SpinnerModel instance with preferred start, min, max and step values
     * @return SpinnerModel instance
     */
    private SpinnerModel getSpinnerModel(int startValue, int minValue, int maxValue, int stepSize) {
        return new SpinnerNumberModel(startValue, //initial value
                minValue, //min
                maxValue, //max
                stepSize);
    }


    /**
     * Updates state of spinner model to match user input
     * @param spinnerModel
     */
    private void updateSpinnerState(SpinnerModel spinnerModel) {
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }


    /**
     * Sets layout of panels
     */
    private void setPanelLayout() {
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(talkButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);

        controlPanel.setPreferredSize(new Dimension((FRAME_WIDTH/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(FRAME_WIDTH/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(FRAME_WIDTH/5-15,200));
        this.add(stopButton);
    }



    public static int getFrameWidth() {
        return FRAME_WIDTH;
    }

    public static int getFrameHeight() {
        return FRAME_HEIGHT;
    }

}
package Model;

/**
 * Movable is the interface for methods used in moving instances.
 */
public interface Movable {

    //TODO clarify "move".
    /**
     * Method for updating position (based on attributes of instance).
     */
    void move();

    /**
     * Method for turning left.
     */
    void turnLeft();

    /**
     * Method for turning right.
     */
    void turnRight();

}

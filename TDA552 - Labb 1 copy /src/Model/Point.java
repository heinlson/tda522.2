package Model;


/**
 * Class for points (x and y), representing coordinates used for vectors and positions on the plane.
 *
 */
public class Point {
    private double x; //x coordinate
    private double y; //y coordinate

    /**
     * Constructor for initializing instances with an x and y coordinate.
     * @param x
     * @param y
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor for instancing objects without initializing coordinates.
     */
    public Point(){}

    /**
     * Sets x and y coordinates to be the same as the argument'semitruck coordinates.
     * @param p
     */
    public void setPoints(Point p){
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * Sets x and y coordinates to the x and y values given in argument.
     * @param x
     * @param y
     */
    public void setPoints(double x, double y){
        this.x = x;
        this.y = y;
    }


    /**
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return y
     */
    public double getY() {
        return y;
    }



    //new methodes for test
    public String toString(){
        return "( "+x+","+y+")";
    }

}

/**
 * This work is marked with CC0 1.0 Universal
 */
package shapes;

/**
 * Class to represent an Equilateral Triangle shape - contains 3 sides of equal length and
 * contains 3 vertices
 */

public class EquilateralTriangle extends Shape2D  {

    private double sideLength;

    /**
    * Constructor for Equilateral Triangle  shape object
    * @param centre The centre of the Equilateral Triangle represented as a Point object
    * @param sideLength The length of each side (all same as equilateral)
    */
    public EquilateralTriangle(Point centre, double sideLength) {
        super(centre);
        this.sideLength = sideLength;
    }


    private double[] calculateDxDy(Point aPoint) {
        double[] pointDiff = new double[2];
        pointDiff[0] = aPoint.getXCord() - this.centre.getXCord();
        pointDiff[1] = aPoint.getYCord() - this.centre.getYCord();
        return pointDiff;
    }
    @Override
    public boolean containsPoint(Point aApoint) {
        double[] pointDiff = calculateDxDy(aApoint);
        return pointDiff[1] <= (Math.sqrt(3) * (pointDiff[0] + this.sideLength / 3)) &&
                (pointDiff[1] <= -(Math.sqrt(3) * (pointDiff[0] - this.sideLength / 3))) &&
                (pointDiff[1] >= -(Math.sqrt(3) / 6) * this.sideLength);
    }

    @Override
    public Point[] getVertices() {
        Point[] vertices = new Point[3];
        vertices[0] = new Point(this.centre.getXCord(), this.centre.getYCord() + Math.sqrt(3)/3*this.sideLength);
        vertices[1] = new Point(this.centre.getXCord()- this.sideLength/2,
                this.centre.getYCord()-Math.sqrt(3)/6*this.sideLength);
        vertices[2] = new Point(this.centre.getXCord()+ this.sideLength/2,
                this.centre.getYCord()-Math.sqrt(3)/6*this.sideLength);
        return  vertices;  }

    @Override
    public double getArea() {
        return Math.sqrt(3)/4 * Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return 3*sideLength;
    }
}

import java.util.Date;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        super();
        side1 = 0.0;
        side2 = 0.0;
        side3 = 0.0;
    }

    public Triangle(String color, boolean filled, Date dateCreated, double side1, double side2, double side3) {
        super(color, filled, dateCreated);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea(){
        double s = (side1 + side2 + side3)/2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        return area;
    }
    
    public double getPerimeter(){
        return (side1 + side2 + side3);
    }

    @Override
    public String toString() {
        return "Triangulo: side1 = " + side1 + "side2 = " + side2 + "side3 = " + side3;
    }
}

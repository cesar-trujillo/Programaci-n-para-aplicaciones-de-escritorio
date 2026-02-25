import java.util.Date;

public class Circle extends GeometricObject {
    private double radius;

    public Circle() {
        super();
        radius = 0.0;
    }

    public Circle(String color, boolean filled, Date dateCreated, double radius) {
        super(color, filled, dateCreated);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.pow((Math.PI * radius), 2); 
    }

    public double getPerimeter(){
        return (2 * Math.PI * radius);
    }

    public double getDiameter(){
        return (2 * radius);
    }

    public void printCircle(){
        System.out.println("circulo");
    }
}

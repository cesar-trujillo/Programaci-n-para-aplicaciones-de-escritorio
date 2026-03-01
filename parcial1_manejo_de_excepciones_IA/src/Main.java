import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int side1, side2, side3;
        String color;
        boolean filled;
        Date date = null;

        System.out.println("Ingrese el primer lado: ");
        side1 = scanner.nextInt();
        System.out.println("Ingresa el segundo lado: ");
        side2 = scanner.nextInt();
        System.out.println("Ingrese el tercer lado: ");
        side3 = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Ingresa el color del triangulo: ");
        color = scanner.nextLine();

        System.out.println("Ingrese 'true' si el triangulo está relleno o 'false' si no lo está");
        filled = scanner.nextBoolean();

        Triangle triangulo = new Triangle(color, filled, date, side1, side2, side3);
        System.out.println("\nArea: " + triangulo.getArea());
        System.out.println("Perimetro: " + triangulo.getPerimeter());
        System.out.println("Color: " + triangulo.getColor());
        System.out.println("relleno: " + triangulo.isFilled());

        scanner.close();
    }
}

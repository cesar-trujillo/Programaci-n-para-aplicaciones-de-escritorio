import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class CrearDatasetFacultad {

    public static void main(String[] args) {

        String nombreArchivo = "salarios.txt";
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {

            for (int i = 1; i <= 1000; i++) {

                String nombre = "Nombre" + i;
                String apellido = "Apellido" + i;

                int tipoRango = random.nextInt(3);
                String rango;
                double salario = 0.0;

                switch (tipoRango) {
                    case 0:
                        rango = "asistente";
                        salario = 50000 + (80000 - 50000) * random.nextDouble();
                        break;
                    case 1:
                        rango = "associado";
                        salario = 60000 + (110000 - 60000) * random.nextDouble();
                        break;
                    default:
                        rango = "titular";
                        salario = 75000 + (130000 - 75000) * random.nextDouble();
                        break;
                }

                writer.printf("%s %s %s %.2f%n", nombre, apellido, rango, salario);
            }

            System.out.println("Archivo generado correctamente: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
            e.printStackTrace();
        }
    }
}
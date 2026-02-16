//################ CALCULADORA CON MANEJO DE EXCEPCIONES ##############
class Input {//clase para recibir la entrada de argumentos
    public String result(String[] args){

        // Check number of strings passed
        if (args.length != 3) {//verifica que haya tres argumentos
            throw new IllegalArgumentException("Usage: java Calculator operand1 operator operand2");
        }else{
            try {
                Integer.parseInt(args[0]); //verifica que se ingresen numeros
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Entrada Incorrecta: " + args[0]);
            }

            try {
                Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Entrada Incorrecta: " + args[2]);
            }
        }
        
        // The result of the operation
        int result = 0;

        // Determine the operator
        switch (args[1].charAt(0)) {//funcion principal de la calculadora
            case '+':
                result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                break;
            case '-':
                result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                break;
            case '.':
                result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                break;
            case '/':
                result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                break;
        }

        // Display result
        return ((args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result));

    }
}

public class CalculatorExc {
        /** Main method */
    public static void main(String[] args) { 

        try {
            Input entrada = new Input();
            System.out.println(entrada.result(args));//imprime el resultado de la operacion
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());//imprime mensajes en caso de excepciones
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
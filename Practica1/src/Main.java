// PASO 4
class NewExceptionClass {
    public String doException() throws Exception{ //puede cambiar el tipo de retorno
        //aqui va la excepcion
        return " "; //esto se puede quitar despues
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            NewExceptionClass excepcion = new NewExceptionClass(); //instancia de la nueva excepcion
            excepcion.doException();//se invoca el metodo de la excepcion
        } catch (Exception e) { //cambiar por el tipo de la nueva excepcion
            System.out.println(" "); //mensaje de la excepcion
        }
    }
}

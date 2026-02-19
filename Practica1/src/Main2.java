class AyB {
    public void a() throws Exception {
        if(true){
            throw new Exception("ha ocurrido una excepcion en el metodo a");
        }
    }

    public void b() throws Exception {
        try {
            a();
        } catch (Exception e) {
            throw new Exception("ha ocurrido una excepcion en el metodo b", e);
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        AyB excepcion = new AyB();

        try {
            excepcion.b();
        } catch (Exception e) {
            System.out.println("Stack Trace: ");
            e.printStackTrace();
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Conexion con = new Conexion();
        con.storeProcedure("CHEQ003", 17000);
        //CVista vista = new CVista();   
    }
    
}

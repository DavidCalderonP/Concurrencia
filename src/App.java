public class App {
    public static void main(String[] args) throws Exception {
        Conexion con = new Conexion();
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        for (int i = 0; i < 25; i++) {
            con.storeProcedure("CHEQ002", 1000);
            System.out.println("Transación No.: " + (i+1));
        }
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");

        //CVista vista = new CVista();   
    }

}

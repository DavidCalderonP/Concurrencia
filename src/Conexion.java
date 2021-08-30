import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    String url = "jdbc:sqlserver://25.3.226.97:1433;database=Cuentas",
           user = "sa",
           password =  "1234";

    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("La conexión falló");
            return null;
        }
        System.out.println("La conexión tuvo exito");
        return connection; 
    }

    public ResultSet query(String query){
        ResultSet res = null;
        try {
            Statement statement = connect().createStatement();
            res = statement.executeQuery(query);
            
            // System.out.println("NoCuenta\tImporte\t\tEstatus");
            // while(res.next()){
            //     System.out.println(res.getString(1) +"\t\t"+ res.getString(2) +"\t"+ res.getString(3));
            // }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        return res;
    }

    public void storeProcedure(String chequera, int retiro){
        try {
            CallableStatement clbleStmt = connect().prepareCall("{call sp_RetirarDinero(?,?)}");
            clbleStmt.setString(1, chequera);
            clbleStmt.setInt(2, retiro);
            clbleStmt.execute();
            System.out.println("Todo bien");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    --------------------------------------------------------------------------------------
create   procedure sp_RetirarDinero @Chequera varchar(50), @Cantidad money as 
        
begin	
                                                                                 
	begin tran
                                                                            
	DECLARE @FONDOS MONEY;
                                                                
	SET @FONDOS = (SELECT importe from cheques WITH (UPDLOCK) where nocuenta = @Chequera);

	PRINT @FONDOS
                                                                         
	if(@FONDOS<@Cantidad)
                                                                 
		BEGIN 
                                                                                
			RAISERROR('Fondos insuficientes',16,1);
                                               
			ROLLBACK TRAN
                                                                         
			RETURN
                                                                                
		END
                                                                                   
	BEGIN TRY
                                                                             
		UPDATE Cheques SET Importe = @FONDOS - @Cantidad where NoCuenta = @Chequera
           
		COMMIT TRAN
                                                                           
		RETURN 
                                                                               
	END TRY
                                                                               
	BEGIN CATCH
                                                                           
		RAISERROR('Algo salió mal.',16,1);
                                                    
		ROLLBACK TRAN
                                                                         
		RETURN
                                                                                
	END CATCH
                                                                             
END
    */
}

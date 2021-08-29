package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
       
    //Datos para conectar a la base de datos
    static String database = "Farmacia";
    static String user = "root";
    static String pass = "root";
    static String url = "jdbc:mysql://localhost:3306/" + database;
    
    //Invocamos la clase Connection de java para el MySQL
    Connection cone = null;
    
    //Constructor, validamos si el logramos conectar a la base de datos
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cone = DriverManager.getConnection(url, user, pass);
            if (cone != null) {
                System.out.println("Base de datos conectada");
            }
        }
        catch(Exception e){
            System.out.println("Error al intentar conectar a la base de datos " + this.database + " Detalle: " + e);
        }
    }
    
    public Connection conectar(){
        return cone;
    }
    
}

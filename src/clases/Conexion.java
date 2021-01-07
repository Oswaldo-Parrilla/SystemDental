package clases;
//Base de datos local
//libreria DB
import java.sql.*;

public class Conexion {
    //Conexion Local
    public static Connection conectar(){ //METODO para conectarte a la base de datos 
        try{  
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:33065/dental_system?useSSL=false", "root", "");
            return cn;
        } catch (SQLException e){
            System.out.println("Error en conexion local" + e);       
        }
        return(null);
    }
}


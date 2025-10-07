/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconexionjdbc;
//ESTA JAVA CLASS SE ENCARGARÁ DE REALIZAR LA CONEXIÓN CON MySQL Y EJECUTAR LA OPERACIÓN CRUD 

/**
 *
 * @author LENOVO
 */
import java.sql.*;
import java.sql.SQLException;
public class EjemploConexionJDBC {
    
    public static void main(String[] args){
        String usuario = "root";
        String password = "Root123$";
        String url = "jdbc:mysql://localhost:3306/pruebaWisechat";
        Connection conexion;
        
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.getLogger(EjemploConexionJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);  
            System.out.println("Conexión exitosa a la base de datos.");
            
            // Crear objeto de la clase OperacionesCRUD
            OperacionesCRUD operaciones = new OperacionesCRUD();

            // 🔹 Ejecutar cada operación CRUD
            operaciones.insertUsuario(conexion);
            operaciones.consultarUsuario(conexion);
            operaciones.actualizarUsuario(conexion);
            operaciones.eliminarUsuario(conexion);
            operaciones.consultarUsuario(conexion);
            
            
            
        } catch (SQLException ex) {
            System.getLogger(EjemploConexionJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            System.out.println("Error al conectar con la base de datos.");
        }
                
        
        
    }
};

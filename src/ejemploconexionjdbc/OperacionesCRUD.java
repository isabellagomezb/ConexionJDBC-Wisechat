/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploconexionjdbc;

/**
 *
 * @author LENOVO
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesCRUD {
    
    public void insertUsuario(Connection conexion){
        try {
            Statement statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIO(USER_NAME, USER_EMAIL, USER_PASSWORD) VALUES ('Valentina', 'valen58@gmail.com', 'marketing')");
            System.out.println("Usuario insertado correctamente.");
        }catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
    
    public void consultarUsuario(Connection conexion){
        try{
            Statement statement = conexion.createStatement();
            //Se va a hacer la consulta a través del select, el cual retorna valores desde la base de datos hacia la app
            //Pero esa info se necesita procesar para poder verla y ahí usamos el resultSet para recibir las respuestas, 
            //va a referenciar todo tipo de elementos
            ResultSet rs = statement.executeQuery("SELECT * FROM USUARIO"); 
            rs.next();
            do{
                System.out.println(rs.getInt("user_id")+ ") " + rs.getString("user_name") + " - " + rs.getString("user_email") + " - " + rs.getString("user_password") );
            } while (rs.next());
        }catch(SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }
    
    public void actualizarUsuario(Connection conexion){
        try{
            Statement statement = conexion.createStatement();
            statement.executeUpdate("UPDATE USUARIO SET USER_PASSWORD = 'Yola5896' WHERE USER_PASSWORD = '5896' ");
            System.out.println("Usuario actualizado correctamente.");
        }catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    
    public void eliminarUsuario(Connection conexion){
        try{
            Statement statement = conexion.createStatement();
            statement.executeUpdate("DELETE FROM USUARIO WHERE USER_NAME = 'Isabella' ");
            System.out.println("Usuario eliminado correctamente.");
        }catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
    
    
}


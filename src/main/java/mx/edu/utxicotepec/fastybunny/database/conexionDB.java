/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.utxicotepec.fastybunny.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión con la base de datos MySQL.
 * Proporciona un método estático para obtener una conexión activa.
 */
public class conexionDB {
        // URL de conexión a la base de datos. Especifica el protocolo, el host, el puerto y el nombre de la base de datos.
     private static final String URL = "jdbc:mysql://localhost:3306/fasty";
         // Usuario para acceder a la base de datos.
    private static final String USER = "root";
        // Contraseña del usuario de la base de datos.
    private static final String PASSWORD = "1234"; // Cámbialo por el tuyo

     /**
     * Establece y devuelve una conexión con la base de datos.
     * Utiliza las credenciales definidas en las constantes de la clase.
     * @return Un objeto Connection que representa la conexión a la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}

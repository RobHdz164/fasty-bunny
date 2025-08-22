/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.utxicotepec.fastybunny.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import mx.edu.utxicotepec.fastybunny.conexion.conexionDB;
import mx.edu.utxicotepec.fastybunny.model.usuarioModel;

/**
 * Controlador para gestionar las operaciones CRUD y de autenticación de los usuarios.
 * @author Roberto
 */
public class usuarioController {

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param usuario El objeto usuarioModel con la información a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public static boolean insertarUsuario(usuarioModel usuario) {
        String sql = "INSERT INTO usuario (nombre, correo, contraseña, telefono, id_rol) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTelefono());
            ps.setInt(5, usuario.getIdRol());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un usuario de la base de datos por su ID.
     * @param idUsuario El ID del usuario a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public static boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene una lista con todos los usuarios de la base de datos.
     * @return Una lista de objetos usuarioModel. La lista estará vacía si no hay usuarios o si ocurre un error.
     */
    public static List<usuarioModel> obtenerTodos() {
        List<usuarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                usuarioModel usuario = new usuarioModel(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contraseña"),
                    rs.getString("telefono"),
                    rs.getInt("id_rol")
                );
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    /**
     * Obtiene un usuario específico de la base de datos a partir de su ID.
     * @param idUsuario El ID del usuario a buscar.
     * @return Un objeto usuarioModel con los datos del usuario, o null si no se encuentra.
     */
    public static usuarioModel obtenerUsuarioPorId(int idUsuario) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new usuarioModel(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getString("telefono"),
                        rs.getInt("id_rol")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; // Devuelve null si no se encuentra el usuario o si hay un error
    }

    /**
     * Busca usuarios en la base de datos cuyo nombre coincida con el término de búsqueda.
     * @param nombreBusqueda El nombre o parte del nombre del usuario a buscar.
     * @return Una lista de objetos usuarioModel que coinciden con la búsqueda.
     */
    public static List<usuarioModel> buscarUsuarioPorNombre(String nombreBusqueda) {
        List<usuarioModel> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nombre LIKE ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombreBusqueda + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    usuarioModel usuario = new usuarioModel(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getString("telefono"),
                        rs.getInt("id_rol")
                    );
                    listaUsuarios.add(usuario);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaUsuarios;
    }

    /**
     * Actualiza un usuario existente en la base de datos.
     * @param usuario El objeto usuarioModel con los datos actualizados y el ID del usuario a modificar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public static boolean modificarUsuario(usuarioModel usuario) {
        // CORRECCIÓN: Se ajustó la consulta para usar los nombres de tabla y columnas correctos.
        String sql = "UPDATE usuario SET nombre = ?, correo = ?, contraseña = ?, telefono = ?, id_rol = ? WHERE id_usuario = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTelefono());
            ps.setInt(5, usuario.getIdRol());
            ps.setInt(6, usuario.getIdUsuario());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            // Nota: Mostrar diálogos desde el controlador puede acoplar la lógica con la vista.
            // Es una práctica común, pero se recomienda manejar las notificaciones en la capa de la vista.
            JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Verifica si las credenciales (correo y contraseña) de un usuario son válidas.
     * @param correo El correo del usuario.
     * @param contraseña La contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public static boolean verificarCredenciales(String correo, String contraseña) {
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contraseña = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Si existe un resultado, las credenciales son válidas.
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene una lista de todos los usuarios que tienen el rol de "Vendedor" (id_rol = 2).
     * @return Una lista de objetos usuarioModel que son vendedores.
     */
    public static List<usuarioModel> obtenerVendedores() {
        List<usuarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE id_rol = 2";
        try (Connection con = conexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                usuarioModel usuario = new usuarioModel(
                    rs.getInt("id_usuario"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contraseña"),
                    rs.getString("telefono"),
                    rs.getInt("id_rol")
                );
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
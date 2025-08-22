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

import mx.edu.utxicotepec.fastybunny.database.conexionDB;
import mx.edu.utxicotepec.fastybunny.model.rolModel;

/**
 * Controlador para gestionar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de los roles.
 * @author Roberto
 */
public class rolController {

    /**
     * Inserta un nuevo rol en la base de datos.
     * @param rol El objeto rolModel con la información a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public static boolean insertarRol(rolModel rol) {
        String sql = "INSERT INTO rol (nombre_rol) VALUES (?)";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rol.getNombre_rol());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza un rol existente en la base de datos.
     * @param rol El objeto rolModel con los datos actualizados y el ID del rol a modificar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public static boolean modificarRol(rolModel rol) {
        String sql = "UPDATE rol SET nombre_rol=? WHERE id_rol=?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rol.getNombre_rol());
            ps.setInt(2, rol.getId_rol()); // <-- CORRECCIÓN: Faltaba establecer el ID para la cláusula WHERE.
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un rol de la base de datos por su ID.
     * @param idRol El ID del rol a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public static boolean eliminarRol(int idRol) {
        String sql = "DELETE FROM rol WHERE id_rol = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRol);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene una lista con todos los roles de la base de datos.
     * @return Una lista de objetos rolModel. La lista estará vacía si no hay roles o si ocurre un error.
     */
    public static List<rolModel> obtenerTodos() {
        List<rolModel> lista = new ArrayList<>();
        String sql = "SELECT id_rol, nombre_rol FROM rol";
        try (Connection con = conexionDB.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                rolModel rol = new rolModel();
                rol.setId_rol(rs.getInt("id_rol"));
                rol.setNombre_rol(rs.getString("nombre_rol"));
                lista.add(rol);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Obtiene un rol específico de la base de datos a partir de su ID.
     * @param idRol El ID del rol a buscar.
     * @return Un objeto rolModel con los datos del rol, o null si no se encuentra.
     */
    public static rolModel obtenerRolPorId(int idRol) {
        String sql = "SELECT id_rol, nombre_rol FROM rol WHERE id_rol = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idRol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    rolModel rol = new rolModel();
                    rol.setId_rol(rs.getInt("id_rol"));
                    rol.setNombre_rol(rs.getString("nombre_rol"));
                    return rol;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; // Devuelve null si no se encuentra el rol o si hay un error
    }

    /**
     * Busca roles en la base de datos cuyo nombre coincida con el término de búsqueda.
     * @param nombreBusqueda El nombre o parte del nombre del rol a buscar.
     * @return Una lista de objetos rolModel que coinciden con la búsqueda.
     */
    public static List<rolModel> buscarRolPorNombre(String nombreBusqueda) {
        List<rolModel> listaRoles = new ArrayList<>();
        String sql = "SELECT * FROM rol WHERE nombre_rol LIKE ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombreBusqueda + "%"); // Busca coincidencias parciales
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rolModel rol = new rolModel(
                        rs.getInt("id_rol"),
                        rs.getString("nombre_rol")
                    );
                    listaRoles.add(rol);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaRoles;
    }
}
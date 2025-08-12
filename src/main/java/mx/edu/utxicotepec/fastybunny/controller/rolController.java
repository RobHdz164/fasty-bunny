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
import mx.edu.utxicotepec.fastybunny.conexion.conexionDB;
import mx.edu.utxicotepec.fastybunny.model.rolModel;

/**
 *
 * @author Roberto
 */
public class rolController {

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

    public static boolean modificarRol(rolModel rol) {
    String sql = "UPDATE rol SET nombre_rol=? WHERE id_rol=?";
    try (Connection con = conexionDB.obtenerConexion()) {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, rol.getNombre_rol());
       

        return ps.executeUpdate() > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}

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
    
    public static List<rolModel> buscarRolPorNombre(String nombreBusqueda) {
    List<rolModel> listaRoles = new ArrayList<>();
    String sql = "SELECT * FROM rol WHERE nombre_rol LIKE ?";
    try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, "%" + nombreBusqueda + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            rolModel rol = new rolModel(
                rs.getInt("id_rol"),
                rs.getString("nombre_rol")
            );
            listaRoles.add(rol);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return listaRoles;
}

}


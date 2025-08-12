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
import mx.edu.utxicotepec.fastybunny.model.usuarioModel;

/**
 *
 * @author Roberto
 */
public class usuarioController {

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

    public static List<usuarioModel> buscarUsuarioPorNombre(String nombreBusqueda) {
        List<usuarioModel> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nombre LIKE ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombreBusqueda + "%");
            ResultSet rs = ps.executeQuery();
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaUsuarios;
    }

    public static boolean actualizarUsuario(usuarioModel usuario) {
        String sql = "UPDATE usuario SET nombre = ?, correo = ?, contraseña = ?, telefono = ?, id_rol = ? WHERE id_usuario = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContraseña());
            ps.setString(4, usuario.getTelefono());
            ps.setInt(5, usuario.getIdRol());
            ps.setInt(6, usuario.getIdUsuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Verifica si las credenciales son válidas y si el usuario tiene el rol de Administrador (id_rol = 1).
     * @param correo    Correo ingresado.
     * @param contraseña Contraseña ingresada.
     * @return true si las credenciales son válidas y el rol es Administrador.
     */
    public static boolean verificarCredenciales(String correo, String contraseña) {
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contraseña = ? AND id_rol = 1";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Si existe un resultado, es válido.
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public static List<String> obtenerNombresVendedores() {
    List<String> vendedores = new ArrayList<>();
    String sql = "SELECT nombre FROM usuario WHERE id_rol = 2";

    try (Connection con = conexionDB.obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            vendedores.add(rs.getString("nombre"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return vendedores;
}
}

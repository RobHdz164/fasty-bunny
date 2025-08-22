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
import mx.edu.utxicotepec.fastybunny.model.categoriaModel;

/**
 * Controlador para gestionar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de las categorías.
 * @author Roberto
 */
public class categoriasController {

    /**
     * Inserta una nueva categoría en la base de datos.
     * @param categoria El objeto categoriaModel con la información a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public static boolean insertarCategoria(categoriaModel categoria) {
        String sql = "INSERT INTO categoria (nombre_categoria) VALUES (?)";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza una categoría existente en la base de datos.
     * @param categoria El objeto categoriaModel con los datos actualizados y el ID de la categoría a modificar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public static boolean actualizarCategoria(categoriaModel categoria) {
        String sql = "UPDATE categoria SET nombre_categoria = ? WHERE id_categoria = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria());
            ps.setInt(2, categoria.getIdCategoria());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina una categoría de la base de datos por su ID.
     * @param idCategoria El ID de la categoría a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public static boolean eliminarCategoria(int idCategoria) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene una lista con todas las categorías de la base de datos.
     * @return Una lista de objetos categoriaModel. La lista estará vacía si no hay categorías o si ocurre un error.
     */
    public static List<categoriaModel> obtenerTodas() {
    List<categoriaModel> lista = new ArrayList<>();
    String sql = "SELECT id_categoria, nombre_categoria FROM categoria";
        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                categoriaModel categoria = new categoriaModel(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre_categoria")
                );
                lista.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Obtiene una categoría específica de la base de datos a partir de su ID.
     * @param idCategoria El ID de la categoría a buscar.
     * @return Un objeto categoriaModel con los datos de la categoría, o null si no se encuentra.
     */
    public static categoriaModel obtenerCategoriaPorId(int idCategoria) {
        String sql = "SELECT id_categoria, nombre_categoria FROM categoria WHERE id_categoria = ?";
        try (Connection con = conexionDB.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new categoriaModel(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null; // Devuelve null si no se encuentra la categoría o si hay un error
    }
}
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
import mx.edu.utxicotepec.fastybunny.model.productoModel;

/**
 * Controlador para gestionar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) de los productos.
 * @author Roberto
 */
public class productoController {

    /**
     * Inserta un nuevo producto en la base de datos.
     * @param producto El objeto productoModel con la información a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     */
    public static boolean insertarProducto(productoModel producto) {
        String sql = "INSERT INTO producto (nombre_producto, descripcion, precio, id_vendedor, id_categoria) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getIdVendedor());
            ps.setInt(5, producto.getIdCategoria());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza un producto existente en la base de datos.
     * @param producto El objeto productoModel con los datos actualizados y el ID del producto a modificar.
     * @return true si la actualización fue exitosa, false en caso contrario.
     */
    public static boolean actualizarProducto(productoModel producto) {
        String sql = "UPDATE producto SET nombre_producto = ?, descripcion = ?, precio = ?, id_vendedor = ?, id_categoria = ? WHERE id_producto = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getIdVendedor());
            ps.setInt(5, producto.getIdCategoria());
            ps.setInt(6, producto.getIdProducto());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     * @param idProducto El ID del producto a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public static boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Obtiene una lista con todos los productos de la base de datos.
     * @return Una lista de objetos productoModel. La lista estará vacía si no hay productos o si ocurre un error.
     */
    public static List<productoModel> obtenerTodos() {
        List<productoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try (Connection con = conexionDB.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                productoModel producto = new productoModel(
                    rs.getInt("id_producto"),
                    rs.getString("nombre_producto"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("id_vendedor"),
                    rs.getInt("id_categoria")
                );
                lista.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    /**
     * Busca productos en la base de datos cuyo nombre coincida con el término de búsqueda.
     * @param nombreBusqueda El nombre o parte del nombre del producto a buscar.
     * @return Una lista de objetos productoModel que coinciden con la búsqueda.
     */
    public static List<productoModel> buscarProductoPorNombre(String nombreBusqueda) {
        List<productoModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre_producto LIKE ?";
        try (Connection con = conexionDB.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombreBusqueda + "%"); // Busca coincidencias parciales
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productoModel producto = new productoModel(
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        rs.getInt("id_vendedor"),
                        rs.getInt("id_categoria")
                    );
                    lista.add(producto);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }
}
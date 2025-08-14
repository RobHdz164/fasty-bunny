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
 *
 * @author Roberto
 */
public class productoController {

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
    

}
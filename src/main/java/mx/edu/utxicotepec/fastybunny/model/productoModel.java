/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.utxicotepec.fastybunny.model;

/**
 * Modelo que representa un producto en el sistema.
 * Contiene los atributos y métodos para gestionar la información de un producto.
 * @author PC-05
 */
public class productoModel {
    
    // --- ATRIBUTOS ---

    /**
     * Identificador único del producto.
     */
    private int idProducto;
    
    /**
     * Nombre del producto.
     */
    private String nombreProducto;
    
    /**
     * Descripción detallada del producto.
     */
    private String descripcion;
    
    /**
     * Precio de venta del producto.
     */
    private double precio;
    
    /**
     * ID del usuario (vendedor) que ofrece el producto.
     */
    private int idVendedor;
    
    /**
     * ID de la categoría a la que pertenece el producto.
     */
    private int idCategoria;

    // --- CONSTRUCTORES ---

    /**
     * Constructor por defecto.
     * Crea una instancia de productoModel sin inicializar sus atributos.
     */
    public productoModel() {
    }

    /**
     * Constructor con todos los parámetros.
     * Crea una instancia de productoModel con todos sus atributos definidos.
     * @param idProducto El ID del producto.
     * @param nombreProducto El nombre del producto.
     * @param descripcion La descripción del producto.
     * @param precio El precio del producto.
     * @param idVendedor El ID del vendedor asociado.
     * @param idCategoria El ID de la categoría asociada.
     */
    public productoModel(int idProducto, String nombreProducto, String descripcion, double precio, int idVendedor, int idCategoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idVendedor = idVendedor;
        this.idCategoria = idCategoria;
    }

    /**
     * Constructor para crear un nuevo producto sin un ID asignado.
     * Útil para operaciones de inserción donde el ID es autoincremental.
     * @param nombreProducto El nombre del producto.
     * @param descripcion La descripción del producto.
     * @param precio El precio del producto.
     * @param idVendedor El ID del vendedor asociado.
     * @param idCategoria El ID de la categoría asociada.
     */
    public productoModel(String nombreProducto, String descripcion, double precio, int idVendedor, int idCategoria) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idVendedor = idVendedor;
        this.idCategoria = idCategoria;
    }

    // --- GETTERS Y SETTERS ---

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    // --- MÉTODOS SOBREESCRITOS ---

    /**
     * Devuelve una representación en cadena del objeto.
     * En este caso, devuelve el nombre del producto.
     * @return El nombre del producto.
     */
    @Override
    public String toString() {
        return this.nombreProducto;
    }
}
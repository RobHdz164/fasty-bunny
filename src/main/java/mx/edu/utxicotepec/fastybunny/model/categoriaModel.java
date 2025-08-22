/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.utxicotepec.fastybunny.model;

/**
 * Modelo que representa una categoría en el sistema.
 * Contiene los atributos y métodos para gestionar la información de una categoría.
 * @author PC-06
 */
public class categoriaModel {

    // --- ATRIBUTOS ---
    
    /**
     * Identificador único de la categoría.
     */
    private int idCategoria;
    
    /**
     * Nombre de la categoría.
     */
    private String nombreCategoria;

    // --- CONSTRUCTORES ---

    /**
     * Constructor por defecto.
     * Crea una instancia de categoriaModel sin inicializar sus atributos.
     */
    public categoriaModel() {
    }

    /**
     * Constructor con todos los parámetros.
     * Crea una instancia de categoriaModel con un ID y un nombre específicos.
     * @param idCategoria El ID de la categoría.
     * @param nombreCategoria El nombre de la categoría.
     */
    public categoriaModel(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * Constructor para crear una nueva categoría sin un ID asignado.
     * Útil para operaciones de inserción donde el ID es autoincremental.
     * @param nombreCategoria El nombre de la categoría.
     */
    public categoriaModel(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    // --- GETTERS Y SETTERS ---

    /**
     * Obtiene el ID de la categoría.
     * @return El identificador único de la categoría.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el ID de la categoría.
     * @param idCategoria El nuevo identificador para la categoría.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene el nombre de la categoría.
     * @return El nombre de la categoría.
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * Establece el nombre de la categoría.
     * @param nombreCategoria El nuevo nombre para la categoría.
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    // --- MÉTODOS SOBREESCRITOS ---

    /**
     * Devuelve una representación en cadena del objeto.
     * En este caso, devuelve el nombre de la categoría.
     * Esencial para que los componentes de la interfaz de usuario (como JComboBox) muestren el nombre.
     * @return El nombre de la categoría.
     */
    @Override
    public String toString() {
        return this.getNombreCategoria(); 
    }
}
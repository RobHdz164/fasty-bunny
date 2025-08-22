/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.utxicotepec.fastybunny.model;

/**
 * Modelo que representa un rol de usuario en el sistema.
 * Contiene los atributos y métodos para gestionar la información de un rol.
 * @author PC-05
 */
public class rolModel {
    
    // --- ATRIBUTOS ---
    
    /**
     * Identificador único del rol.
     */
    private int id_rol;
    
    /**
     * Nombre del rol (ej. "Administrador", "Vendedor").
     */
    private String nombre_rol;

    // --- CONSTRUCTORES ---

    /**
     * Constructor por defecto.
     * Crea una instancia de rolModel sin inicializar sus atributos.
     */
    public rolModel() {
    }

    /**
     * Constructor con todos los parámetros.
     * Crea una instancia de rolModel con un ID y un nombre específicos.
     * @param id_rol El ID del rol.
     * @param nombre_rol El nombre del rol.
     */
    public rolModel(int id_rol, String nombre_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

    /**
     * Constructor para crear un nuevo rol sin un ID asignado.
     * Útil para operaciones de inserción donde el ID es autoincremental.
     * @param nombre_rol El nombre del rol.
     */
    public rolModel(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }
    
    // --- GETTERS Y SETTERS ---

    /**
     * Obtiene el ID del rol.
     * @return El identificador único del rol.
     */
    public int getId_rol() {
        return id_rol;
    }

    /**
     * Establece el ID del rol.
     * @param id_rol El nuevo identificador para el rol.
     */
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    /**
     * Obtiene el nombre del rol.
     * @return El nombre del rol.
     */
    public String getNombre_rol() {
        return nombre_rol;
    }

    /**
     * Establece el nombre del rol.
     * @param nombre_rol El nuevo nombre para el rol.
     */
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    // --- MÉTODOS SOBREESCRITOS ---
    
    /**
     * Devuelve una representación en cadena del objeto.
     * En este caso, devuelve el nombre del rol.
     * Esencial para que los componentes de la interfaz de usuario (como JComboBox) muestren el nombre.
     * @return El nombre del rol.
     */
    @Override
    public String toString() {
        return this.getNombre_rol();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.utxicotepec.fastybunny.model;

/**
 * Modelo que representa un usuario en el sistema.
 * Contiene los atributos y métodos para gestionar la información de un usuario.
 * @author PC-05
 */
public class usuarioModel {
    
    // --- ATRIBUTOS ---
    
    /**
     * Identificador único del usuario.
     */
    private int idUsuario;
    
    /**
     * Nombre completo del usuario.
     */
    private String nombre;
    
    /**
     * Correo electrónico del usuario, usado para el login.
     */
    private String correo;
    
    /**
     * Contraseña de acceso del usuario.
     */
    private String contraseña;
    
    /**
     * Número de teléfono del usuario.
     */
    private String telefono;
    
    /**
     * ID del rol asociado al usuario (ej. Administrador, Vendedor).
     */
    private int idRol;

    // --- CONSTRUCTORES ---

    /**
     * Constructor por defecto.
     * Crea una instancia de usuarioModel sin inicializar sus atributos.
     */
    public usuarioModel() {
    }

    /**
     * Constructor con todos los parámetros.
     * Crea una instancia de usuarioModel con todos sus atributos definidos.
     * @param idUsuario El ID del usuario.
     * @param nombre El nombre del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contraseña La contraseña del usuario.
     * @param telefono El teléfono del usuario.
     * @param idRol El ID del rol asociado.
     */
    public usuarioModel(int idUsuario, String nombre, String correo, String contraseña, String telefono, int idRol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.idRol = idRol;
    }

    /**
     * Constructor para crear un nuevo usuario sin un ID asignado.
     * Útil para operaciones de inserción donde el ID es autoincremental.
     * @param nombre El nombre del usuario.
     * @param correo El correo electrónico del usuario.
     * @param contraseña La contraseña del usuario.
     * @param telefono El teléfono del usuario.
     * @param idRol El ID del rol asociado.
     */
    public usuarioModel(String nombre, String correo, String contraseña, String telefono, int idRol) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.idRol = idRol;
    }

    // --- GETTERS Y SETTERS ---

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    
    // --- MÉTODOS SOBREESCRITOS ---
    
    /**
     * Devuelve una representación en cadena del objeto.
     * En este caso, devuelve el nombre del usuario.
     * Esencial para que los componentes de la interfaz de usuario (como JComboBox) muestren el nombre.
     * @return El nombre del usuario.
     */
    @Override
    public String toString() {
        return this.getNombre(); 
    }
}

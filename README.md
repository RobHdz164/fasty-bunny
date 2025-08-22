# Fasty Bunny: Sistema de Gestión de Escritorio

**Fasty Bunny** es un sistema de gestión de escritorio desarrollado en Java, diseñado para la administración integral de un negocio de ventas. La aplicación permite gestionar usuarios, productos, roles y categorías a través de una interfaz gráfica intuitiva y funcional.

## Arquitectura

El proyecto sigue el patrón de arquitectura **Modelo-Vista-Controlador (MVC)** para asegurar una clara separación de responsabilidades, facilitando la mantenibilidad y escalabilidad del código.

-   **Modelo**: Representa los datos y la lógica de negocio (clases como `usuarioModel`, `productoModel`, etc.).
-   **Vista**: Compone la interfaz de usuario con la que se interactúa (formularios de Java Swing como `FrmUsuarios`, `FrmProductos`, etc.).
-   **Controlador**: Actúa como intermediario entre el Modelo y la Vista, manejando las acciones del usuario (clases como `usuarioController`, `productoController`, etc.).

## Características Principales

El sistema ha sido refactorizado para ofrecer una experiencia de usuario robusta y consistente:

-   **Autenticación Segura**: Ventana de inicio de sesión para controlar el acceso al sistema.
-   **Gestión Completa (CRUD)**: Funcionalidades para Crear, Leer, Actualizar y Eliminar registros en los siguientes módulos:
    -   Usuarios
    -   Productos
    -   Roles
    -   Categorías
-   **Interfaz de Usuario Estandarizada**:
    -   **Navegación Centralizada**: Un menú principal que organiza el acceso a todos los módulos y previene la apertura de ventanas duplicadas.
    -   **Lógica de Botones Inteligente**: Los botones de acción (`Guardar`, `Modificar`, `Eliminar`) se habilitan o deshabilitan dinámicamente según el contexto para guiar al usuario y prevenir errores.
    -   **Búsqueda Integrada**: Funcionalidad de búsqueda por nombre en los módulos de Usuarios y Productos para filtrar datos fácilmente.
    -   **Visualización Clara**: Las tablas muestran nombres descriptivos (ej. nombre del rol, nombre de la categoría) en lugar de IDs numéricos, mejorando la legibilidad.
    -   **Autocompletado de Formularios**: Al seleccionar un registro de una tabla, sus datos se cargan automáticamente en los campos del formulario para una edición ágil.

## Tecnologías Utilizadas

-   **Lenguaje**: Java
-   **Interfaz Gráfica**: Java Swing
-   **Base de Datos**: MySQL (o compatible como MariaDB)
-   **Conector**: JDBC para MySQL
-   **Gestión de Proyecto**: Maven
-   **IDE Recomendados**: Apache NetBeans o Visual Studio Code (con el "Extension Pack for Java").

## Instrucciones de Instalación y Ejecución

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local:

1.  **Clonar el Repositorio:**
    ```bash
    git clone https://github.com/RobHdz164/fasty-bunny.git
    cd fasty-bunny
    ```

2.  **Configurar la Base de Datos:**
    -   Asegúrate de tener un servidor de MySQL en ejecución.
    -   Crea una nueva base de datos llamada `BD_FastyBunny`.
    -   **Importa el script SQL (`BD_FastyBunny.sql`)** que se encuentra en la raíz del proyecto. Esto creará las tablas y cargará los datos iniciales necesarios.
    ```sql
    -- Ejemplo usando el cliente de línea de comandos de MySQL
    mysql -u tu_usuario -p BD_FastyBunny < BD_FastyBunny.sql
    ```
    -   Verifica que las credenciales de conexión en `src/main/java/mx/edu/utxicotepec/fastybunny/conexion/conexionDB.java` coincidan con las de tu servidor de base de datos.

3.  **Abrir y Ejecutar el Proyecto:**
    -   **Opción 1: Apache NetBeans**
        -   Ve a `File > Open Project` y selecciona la carpeta del proyecto clonado.
        -   NetBeans detectará que es un proyecto de Maven y lo configurará automáticamente.
        -   Haz clic derecho en el proyecto y selecciona `Run` para ejecutarlo.
    -   **Opción 2: Visual Studio Code**
        -   Abre la carpeta del proyecto en VS Code.
        -   Asegúrate de tener instalado el `Extension Pack for Java`.
        -   El proyecto se configurará automáticamente. Abre el archivo `FastyBunny.java` y ejecútalo.

## Autores

- Roberto Hernandez Cruz.
- Andrey Ortega Garcia.
- Monica Itzel Romero Calva.
- Paola Michelle Angely Rodríguez Hernández.

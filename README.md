# Fasty Bunny

**Fasty Bunny** es una aplicación de simulación para la administración de datos orientada a la gestión de usuarios, productos y categorías, diseñada especialmente para el entorno de ventas de alimentos y botanas.

## Descripción

La aplicación permite registrar usuarios con diferentes roles:

- **Administrador**: Gestores principales del sistema (id_rol=1).
- **Cliente**
- **Vendedor** (id_rol=2)

Los administradores son los principales usuarios de la aplicación, pero es posible registrar nuevos roles según sea necesario.

### Funcionalidades principales

- **Gestión de usuarios**: Registro, modificación, eliminación y búsqueda de usuarios por nombre. Soporta múltiples roles y la creación de nuevos.
- **Gestión de productos**: Los vendedores pueden registrar los productos que ofrecen. Todos los productos están conectados a la base de datos `BD_FastyBunny`.
- **Gestión de categorías**: Registro, modificación, eliminación y búsqueda de categorías para los productos, mayormente alimentos o botanas.
- **Operaciones CRUD**: Todas las secciones (usuarios, productos, categorías) permiten crear, leer, actualizar y eliminar registros, así como hacer búsquedas por nombre.

## Requisitos Técnicos

- **Java JDK 8 o superior** instalado en tu sistema.
- **Apache NetBeans** (recomendado) o **Visual Studio Code** con extensiones para Java.
- **Sistema de gestión de bases de datos** compatible (por ejemplo, MySQL o MariaDB).
- **Conexión a la base de datos**: asegúrate de tener creada la base de datos `BD_FastyBunny` y haber configurado correctamente las credenciales en la aplicación.
- **Git** para el control de versiones y clonación del repositorio.
- **Extensión de Java para VS Code** (si usas este editor).
- Opcional: **Driver JDBC** adecuado para tu gestor de base de datos (MySQL/MariaDB).

## Instrucciones de Uso

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/RobHdz164/fasty-bunny.git
2. **Importar el proyecto:**

En NetBeans: Selecciona “Abrir proyecto” y elige la carpeta del repositorio.
En Visual Studio Code: Abre la carpeta del proyecto y asegúrate de tener las extensiones de Java instaladas.
Configurar la base de datos:

Crea la base de datos BD_FastyBunny en tu gestor preferido.
Configura las credenciales de conexión en el archivo correspondiente del proyecto (por ejemplo, en un archivo de configuración o directamente en el código fuente).
Construir y ejecutar la aplicación:

En NetBeans, ejecuta el proyecto con el botón de “Run”.
En VS Code, utiliza la paleta de comandos (Ctrl+Shift+P) y busca “Java: Run” en el archivo principal.
Acceso y gestión:

Inicia sesión como Administrador (id_rol=1) para acceder a todas las funcionalidades.
Los apartados de usuarios, productos y categorías están disponibles desde el panel administrativo.
Puedes registrar, modificar, eliminar y buscar registros según lo requieras.
La aplicación está orientada a administradores, por lo que no es necesario preocuparse por la gestión directa de usuarios con id_rol=3 (clientes).

## Autores

Roberto Hernandez Cruz
Andrey Ortega Garcia
Monica Itzel Romero Calva
Paola Michelle Angely Rodríguez Hernández

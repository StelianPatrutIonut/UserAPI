# User-API
API De gestión de Usuarios

Este proyecto es una API RESTful para gestionar usuarios, creada con **Spring Boot** y **MySQL**. Permite realizar operaciones básicas de CRUD (Crear, Leer, Actualizar, Eliminar) sobre usuarios, con soporte para paginación y filtrado.

## Características

- **CRUD completo** para la gestión de usuarios.
- **Documentación de API** generada automáticamente usando **Swagger**.
- **Autenticación** y **seguridad básica** usando JWT (si lo configuras).
  
## Requisitos

- Java 11 o superior.
- Maven 3.6 o superior.
- MySQL 5.7 o superior.

## Configuración del Proyecto

### 1. Clonar el repositorio

Para empezar, clona el repositorio en tu máquina local:
git clone https://github.com/tu-usuario/userapi.git
cd userapi

2. Configurar la base de datos
Crea una base de datos en MySQL llamada userapi (o el nombre que prefieras) y configura las credenciales en el archivo application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/userapi
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect


3. Construir y ejecutar el proyecto
Usando Maven
Para construir y ejecutar el proyecto, asegúrate de tener Maven instalado. Luego, ejecuta el siguiente comando en el directorio raíz del proyecto:

mvn clean install
mvn spring-boot:run
Esto iniciará la aplicación en http://localhost:8080.

Usando IDE
Si prefieres usar un IDE como IntelliJ IDEA o Eclipse, importa el proyecto y ejecuta la clase principal UserApiApplication como una aplicación Spring Boot.

4. Acceder a la documentación de la API (Swagger UI)
La API está documentada automáticamente con Swagger. Puedes acceder a la interfaz gráfica de Swagger UI en:
http://localhost:8080/swagger-ui/
En esta interfaz podrás probar todos los endpoints de la API y ver los detalles de las peticiones y respuestas.

5. Endpoints disponibles
  1. Crear un nuevo usuario
  Método: POST
  URL: /api/users
  Body: JSON con los datos del usuario.
  Ejemplo de body:

  {
    "name": "Juan Pérez",
    "email": "juan@ejemplo.com"
  }
  
  2. Obtener todos los usuarios
  Método: GET
  URL: /api/users

  3. Obtener un usuario por ID
  Método: GET
  URL: /api/users/{id}

  4. Actualizar un usuario
  Método: PUT
  URL: /api/users/{id}
  Body: JSON con los datos a actualizar.

  5. Eliminar un usuario
  Método: DELETE
  URL: /api/users/{id}

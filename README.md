[README.md](https://github.com/user-attachments/files/31159262/README.md)
# Tienda Genérica — Sprint 1

Proyecto Java + Spring Boot que implementa el **Sprint 1** del documento
`6_PROYECTO_TIENDA_GENERICA.docx`:

- **Módulo de Login del Sistema** (HU-001)
- **Módulo de Gestión de Usuarios** (HU-002 a HU-005)

Incluye backend (API REST), frontend (HTML/CSS/JS) y script de base de datos.

## Stack (según Parte 4 del documento)

- Java SE 11 (JDK)
- Spring Boot 2.4.5
- Maven 3.6+
- MySQL 8.0.24
- IntelliJ IDEA Community (IDE sugerido en el documento, no obligatorio)

## Estructura del proyecto

```
tienda-generica-sprint1/
├── pom.xml
├── database/
│   └── schema.sql                 # Script MySQL (tabla usuarios + admininicial)
└── src/main/
    ├── java/com/tiendagenerica/
    │   ├── TiendaGenericaApplication.java
    │   ├── model/Usuario.java
    │   ├── repository/UsuarioRepository.java
    │   ├── dto/ (LoginRequest, UsuarioDTO, MensajeResponse)
    │   ├── service/ (AuthService, UsuarioService)
    │   ├── controller/ (AuthController, UsuarioController)
    │   ├── config/ (AppConfig, DataInitializer)
    │   └── exception/ (excepciones de negocio + GlobalExceptionHandler)
    └── resources/
        ├── application.properties
        └── static/
            ├── login.html + js/login.js
            ├── index.html               (menú con navbar)
            ├── usuarios.html + js/usuarios.js
            └── css/styles.css
```

## Cómo ejecutarlo

1. **Crear la base de datos.** Con `application.properties` tal como está
   (`createDatabaseIfNotExist=true` y `ddl-auto=update`), Spring Boot crea
   la base de datos y la tabla `usuarios` automáticamente al arrancar.
   Si prefieres crearla tú mismo con MySQL Workbench, usa
   `database/schema.sql`.

2. **Ajustar credenciales de MySQL** en
   `src/main/resources/application.properties`
   (`spring.datasource.username` / `password`) según tu instalación local.

3. **Compilar y ejecutar** desde la raíz del proyecto:
   ```bash
   mvn spring-boot:run
   ```
   o generar el JAR y ejecutarlo:
   ```bash
   mvn clean package
   java -jar target/tienda-generica-sprint1.jar
   ```

4. **Abrir en el navegador:** `http://localhost:8080/login.html`

5. **Usuario por defecto** (creado automáticamente al primer arranque por
   `DataInitializer`):
   - Usuario: `admininicial`
   - Contraseña: `admin123456`

## Endpoints REST

| Método | Endpoint                     | Descripción                          |
|--------|-------------------------------|---------------------------------------|
| POST   | `/api/auth/login`             | Login (HU-001)                        |
| GET    | `/usuarios/listar`            | Listar usuarios                       |
| GET    | `/usuarios/consultar/{cedula}`| Consultar por cédula (HU-003)         |
| POST   | `/usuarios/guardar`           | Crear usuario (HU-002)                |
| PUT    | `/usuarios/actualizar`        | Actualizar usuario (HU-004)           |
| DELETE | `/usuarios/eliminar/{id}`     | Borrar usuario por cédula (HU-005)    |

Los mensajes de éxito/error de cada endpoint corresponden exactamente a los
del **Conjunto de Pruebas** del Sprint 1 (SP1-QA-1 a SP1-QA-10): "Usuario
Creado", "Usuario Inexistente", "Faltan datos del usuario", "Datos
faltantes", "Datos del Usuario Actualizados", "Datos del Usuario
Borrados", "Cédula Errada", y el mensaje de login inválido.

## Nota sobre la verificación de este entregable

El entorno en el que se generó este proyecto no tiene salida de red hacia
Maven Central (`repo.maven.apache.org`), por lo que no fue posible ejecutar
`mvn compile` para una compilación real de extremo a extremo. En su lugar
se hizo una revisión manual exhaustiva:

- Verificación de llaves `{}` balanceadas en todos los `.java`.
- Verificación de que cada `package` coincide con su carpeta.
- Verificación cruzada de que cada clase importada entre paquetes existe.
- Verificación de que cada getter/setter usado (`getCedulaUsuario`,
  `setPassword`, etc.) está definido en la clase correspondiente
  (`Usuario`, `UsuarioDTO`, `LoginRequest`).
- El hash BCrypt del usuario `admininicial` en `schema.sql` fue generado y
  verificado con la librería `bcrypt` (`admin123456` valida correctamente
  contra el hash almacenado).

Se recomienda ejecutar `mvn clean package` en tu máquina (con acceso normal
a internet) como verificación final antes de entregar o desplegar.

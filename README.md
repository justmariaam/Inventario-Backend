# Inventario-Backend
## Descripción del proyecto
Este backend forma parte del Sistema de Control de Inventario.
Está desarrollado en Java, Spring Boot, Spring Data JPA y utiliza una base de datos MySQL alojada en FreeDB.

El sistema expone un CRUD para gestionar Productos, utilizando JSON para enviar y recibir información.

## Correr en local
1. Clonar el repositorio
    ```bash
    git clone https://github.com/justmariaam/Inventario-Backend.git
    cd Inventario-Backend
    ```
2. Configurar la base de datos local

    Editar src/main/resources/application.properties

    ```bash
    spring.datasource.url=jdbc:mysql://sql.freedb.tech:3306/freedb_inventarioBd
    spring.datasource.username=freedb_inventarioUser
    spring.datasource.password=TU_PASSWORD
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    server.port=8080
    ```
3. Compilar y ejecutar
    ```bash
    ./mvnw clean
    ./mvnw spring-boot:run
    ```
    El backend quedará corriendo en: http://localhost:8080/api/productos

## Despliegue en Railway
1. Crear un proyecto en Railway, iremos a https://railway.app, depués le daremos en "Nuevo proyecto" y seleccionaremos “Repositorio de GitHub” y elegiremos el repositorio donde tenemos nuestro backend.

2. Configurar Variables de Entorno
Para que el backend pueda conectarse correctamente a la base de datos, en el menú lateral seleccionar "Variables". Y agregar las siguientes variables: 

    | Variable               | Valor    | 
    |------------------------|----------|
    | SPRING_DATASOURCE_URL  | jdbc:mysql://sql.freedb.tech:3306/freedb_inventarioBd?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true  | 
    | SPRING_DATASOURCE_USERNAME| freedb_inventarioUser|
    | SPRING_DATASOURCE_PASSWORD| TU_PASSWORD |
    | SPRING_JPA_HIBERNATE_DDL_AUTO| update |

3. Generar el dominio público. Selecionamos el proyecto creado, y en el menú nos vamos a "Configuración", y selecionamos "Generar Dominio,", Railway generará una URL similar a:https://inventario-backend-production-c7b0.up.railway.app, esta sera la dirección que utilizará el frontend para consumir la API.


## Base de datos local con Docker- MariaDB
Si quieres usuar una bd local:
```bash
docker run -d --name mariadb_local \
  -p 3307:3306 \
  -e MARIADB_ROOT_PASSWORD=123 \
  -e MARIADB_DATABASE=inventario_db \
  -e MARIADB_USER=mari \
  -e MARIADB_PASSWORD=123 \
  mariadb:10.6
```
### Archivo application.properties para local:
```bash
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3307/inventario_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=mari
spring.datasource.password=123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
Compilar y correr
```bash
./mvnw clean
./mvnw spring-boot:run
```
## Ejemplos de CURL
* Crear producto
    ```bash
    curl -X POST http://localhost:8080/api/productos \
    -H "Content-Type: application/json" \
    -d '{"nombre":"Coca Cola","categoria":"Bebidas","precio":20.5,"cantidad":100}'
    ```
* Obtener todos los productos
    ```bash
    curl -X GET http://localhost:8080/api/productos
    ```

* Obtener un producto por ID
    ```bash
    curl -X GET http://localhost:8080/api/productos/1
    ```

* Actualizar un producto
    ```bash
        curl -X PUT http://localhost:8080/api/productos/7 \
        -H "Content-Type: application/json" \
        -d '{"nombre":"Pan bimbo","categoria":"Comida","precio":20.5,"cantidad":100}'
    ```
* Eliminar un producto
    ```bash
    curl -X DELETE http://localhost:8080/api/productos/7
    ```


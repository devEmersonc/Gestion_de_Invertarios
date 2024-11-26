# Sistema de Gestión de Inventarios

Este es un proyecto que implementa una API RESTful para gestionar inventarios en una tienda o almacén. Permite la gestión de productos, categorías, proveedores y usuarios, con autenticación mediante JWT y seguridad con Spring Security.

## Funcionalidades

- CRUD para productos, categorías, proveedores y usuarios.
- Autenticación y autorización mediante JWT.

## Requisitos y Tecnologías

Este proyecto utiliza las siguientes tecnologías y herramientas:

- **Backend**: Spring Boot 3.4.0, Spring Security, Spring Data JPA, JWT, Spring Web.
- **Base de datos**: MySQL.
- **Lenguaje**: Java 17 (JDK 17).
- **Pruebas**: Postman.
- **Gestión de dependencias**: Maven.

## Dependencias

- **Spring Boot Starter JPA**: Integración con JPA y la base de datos
- **Spring Boot Starter Security**: Seguridad y la autenticación
- **Spring Boot Starter Validation**: Validaciones de datos
- **Spring Boot Starter Web**: Para la creación de APIs REST
- **MySQL Connector**: Conexión con MySQL
- **Spring Boot Starter Test**: Para pruebas unitarias y de integración
- **Spring Security Test**:  Pruebas de seguridad
- **JJWT**: Para trabajar con JSON Web Tokens
- **Dotenv**: Gestionar variables de entorno

## Variables de entorno

Antes de ejecutar la aplicación, configura las siguientes variables de entorno en el archivo .env (archivo de texto plano) en la raíz del proyecto:

DB_USER: Nombre de usuario de tu base de datos MySQL.
DB_PASSWORD: Contraseña de tu base de datos MySQL.
JWT_SECRET_KEY: Clave secreta para la generación de tokens JWT. Esta clave es crucial para la seguridad de la aplicación, ya que se usa para firmar y verificar los tokens de autenticación.

Ejemplo de las variables de entorno:

DB_USER=tu_nombre_de_usuario_mysql
DB_PASSWORD=tu_contraseña_de_mysql
JWT_SECRET_KEY=5a990397b91197c662cd8fd140c6864552730adf6c32e070ead2f69df84e3bc3

Asegúrate de que estas variables estén correctamente configuradas, ya que son esenciales para el funcionamiento seguro de la base de datos y la autenticación.

## Uso

1. Clona este repositorio.
2. Crea el archivo .env en la raíz del proyecto y configura las variables de entorno.
3. Crea la base de datos en MySQL con el siguiente comando:

   ```sql
   CREATE DATABASE gestion_inventario;
4. Verifica que estén todas las dependencias necesarias para que la aplicación funcione correctamente y que tengas la versión 17 de Java instalada.
5. Ejecuta la aplicación.

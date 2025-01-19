# Foro-Hub-Challenge-BackEnd

API REST de foro desarrollada en Spring Boot con autenticación básica, gestión de usuarios, categorías, hilos, publicaciones, comentarios y 'likes'.

## Características

- **Usuarios**: Gestión de usuarios con autenticación básica.
- **Categorías**: Gestión de categorías para organizar el contenido.
- **Hilos (Threads)**: Creación y gestión de hilos de discusión.
- **Publicaciones (Posts)**: Creación y gestión de publicaciones dentro de los hilos.
- **Comentarios (Comments)**: Añadir y gestionar comentarios en las publicaciones.
- **Likes**: Añadir y gestionar 'likes' en las publicaciones.
- **Autenticación**: Configuración de seguridad básica con Spring Security.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Lombok
- Maven

## Requisitos Previos

- Java 17
- Maven
- MySQL

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/JorgePertuzM/Foro-Hub-Challenge-BackEnd.git

2. Navega al directorio del proyecto:

   ```bash
   Navega al directorio del proyecto:
   
3. Configura tu base de datos MySQL en application.properties.

4. Ejecuta el proyecto con Maven:

    ```bash
    mvn spring-boot:run

## Endpoints Principales

### 1. Usuarios:
   
      1.1. GET /users
  
      1.2. GET /users/{id}
  
      1.3. POST /users
  
      1.4. PUT /users/{id}
  
      1.5. DELETE /users/{id}


### 2. Categorías:

      2.1. GET /categories

     2.2. GET /categories/{id}
  
     2.3. POST /categories

     2.4. PUT /categories/{id}

     2.5. DELETE /categories/{id}

### 3. Hilos (Threads):
    
    3.1. GET /threads

    3.2. GET /threads/{id}

    3.3. POST /threads

    3.4. PUT /threads/{id}

    3.5. DELETE /threads/{id}

### 4. Publicaciones (Posts):
    4.1. GET /posts
  
    4.2. GET /posts/{id}
  
    4.3. POST /posts
  
    4.4. PUT /posts/{id}
  
    4.5. DELETE /posts/{id}

### 5. Comentarios (Comments):
    
    5.1. GET /comments
    
    5.2. GET /comments/{id}
  
    5.3. POST /comments
    
    5.4. PUT /comments/{id}
  
    5.5. DELETE /comments/{id}

### 6. Likes:
    
    6.1. GET /likes
  
    6.2. GET /likes/{id}
  
    6.3. POST /likes
  
    6.4. PUT /likes/{id}
  
    6.5. DELETE /likes/{id}

## Contribuciones

Las contribuciones son bienvenidas. Para reportar problemas o sugerir mejoras, por favor abre un "issue" o envía un "pull request".
























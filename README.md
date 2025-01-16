# Aplicación de Consola para Gestión de Libros

Este proyecto consiste en una aplicación de consola que consume la API pública de [Gutendex](https://gutendex.com/), un servicio que ofrece acceso a una vasta colección de libros de dominio público. La aplicación consulta la API para obtener información sobre libros y sus autores, guarda estos datos en una base de datos PostgreSQL, y permite consultar la información almacenada.

## Características

- **Consumo de API**: La aplicación consume la API de Gutendex para obtener información sobre libros disponibles en dominio público.
- **Almacenamiento en PostgreSQL**: Los libros y sus autores son almacenados en una base de datos PostgreSQL para su posterior consulta.
- **Consultas de Datos**: Permite consultar los libros y autores almacenados en la base de datos.
- **Interfaz de Consola**: La aplicación tiene una interfaz de consola sencilla para interactuar con el usuario y mostrar los resultados.

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **Base de Datos**: PostgreSQL
- **API Consumida**: [Gutendex API](https://gutendex.com/)
- **Bibliotecas**:
  - **JDBC**: Para conectar y realizar operaciones con la base de datos PostgreSQL.
  - **JSON**: Para procesar la respuesta de la API en formato JSON.


## Flujo de la Aplicación

1. **Consulta de Libros**: La aplicación realiza una consulta a la API de Gutendex para obtener información sobre libros.
2. **Almacenamiento de Datos**: Los datos obtenidos (título del libro, autor, etc.) se almacenan en una base de datos PostgreSQL para su posterior consulta.
3. **Consulta de Datos Guardados**: Una vez que los libros y autores se han almacenado en la base de datos, puedes realizar consultas para obtener la lista de libros guardados o buscar un libro por título o autor.

  

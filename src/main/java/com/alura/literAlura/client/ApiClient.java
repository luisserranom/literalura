package com.alura.literAlura.client;

import com.alura.literAlura.model.Autor;
import com.alura.literAlura.model.Libro;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ApiClient {

    private final String API_URL_LIBRO = "https://gutendex.com/books";  // URL base de la API Gutendex
    private final String API_URL_AUTOR = "https://api.example.com/autor";  // URL para autores (ejemplo)

    public Libro consultarLibroPorTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();

        // Construimos la URL con el título codificado
        String url = UriComponentsBuilder.fromHttpUrl(API_URL_LIBRO)
                .queryParam("search", titulo)
                .toUriString();

        // Realizamos la consulta a la API para obtener el libro
        return restTemplate.getForObject(url, Libro.class);
    }

    public Autor consultarAutorPorNombre(String nombre) {
        RestTemplate restTemplate = new RestTemplate();

        // Construimos la URL para consultar el autor
        String url = UriComponentsBuilder.fromHttpUrl(API_URL_AUTOR)
                .queryParam("nombre", nombre)
                .toUriString();

        // Realizamos la consulta a la API para obtener el autor
        return restTemplate.getForObject(url, Autor.class);
    }
}

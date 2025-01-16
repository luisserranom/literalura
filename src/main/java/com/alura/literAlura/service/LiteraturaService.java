package com.alura.literAlura.service;

import com.alura.literAlura.client.ApiClient;
import com.alura.literAlura.model.Autor;
import com.alura.literAlura.model.Libro;
import com.alura.literAlura.repository.IAutorRepository;
import com.alura.literAlura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LiteraturaService {


    @Autowired
    private ApiClient apiClient;  // Cliente para consultar la API

    @Autowired
    private ILibroRepository libroRepository;

    @Autowired
    private IAutorRepository autorRepository;

    public void buscarLibroPorTitulo(String titulo) {
        // Llamada a la API para obtener los datos del libro
        Libro libro = apiClient.consultarLibroPorTitulo(titulo);

        if (libro != null) {
            // Si el libro se encuentra en la API, guardamos en la base de datos

            // Verificamos si ya existe el libro en la base de datos
            Libro libroExistente = libroRepository.findByTitulo(libro.getTitulo());
            if (libroExistente == null) {
                libroRepository.save(libro);
                System.out.println("Libro guardado en la base de datos: " + libro.getTitulo());
            } else {
                System.out.println("El libro ya existe en la base de datos.");
            }

            // Verificamos si el autor ya está registrado
            Autor autor = apiClient.consultarAutorPorNombre(libro.getTitulo());  // Supongamos que obtenemos el autor de la API
            Autor autorExistente = autorRepository.findByNombre(autor.getNombre());
            if (autorExistente == null) {
                autorRepository.save(autor);
                System.out.println("Autor guardado en la base de datos: " + autor.getNombre());
            } else {
                System.out.println("El autor ya existe en la base de datos.");
            }
        } else {
            System.out.println("No se encontró el libro en la API.");
        }
    }

    public void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();

        // Imprimir los libros encontrados
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("----- Libros registrados -----");
            for (Libro libro : libros) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor().getNombre());
                System.out.println("Año: " + libro.getAnio());
                System.out.println("Idioma: " + libro.getIdioma());
                System.out.println("------------------------------");
            }
        }
    }

    public void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();

        // Imprimir los autores encontrados
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados en la base de datos.");
        } else {
            System.out.println("----- Autores registrados -----");
            for (Autor autor : autores) {
                System.out.println("Nombre: " + autor.getNombre());
                System.out.println("Año de nacimiento: " + autor.getAnioNacimiento());
                System.out.println("------------------------------");
            }
        }
    }

    public void listarAutoresVivos(int anio) {
        List<Autor> autores = autorRepository.findAll();

        // Filtrar los autores vivos en el año proporcionado
        boolean autoresVivosEncontrados = false;
        for (Autor autor : autores) {
            if (autor.estaVivo(anio)) {
                if (!autoresVivosEncontrados) {
                    System.out.println("----- Autores vivos en el año " + anio + " -----");
                    autoresVivosEncontrados = true;
                }
                System.out.println("Nombre: " + autor.getNombre());
                System.out.println("Año de nacimiento: " + autor.getAnioNacimiento());
                System.out.println("Año de fallecimiento: " + (autor.getAnioFallecimiento() != -1 ? autor.getAnioFallecimiento() : "Aún vivo"));
                System.out.println("------------------------------");
            }
        }

        if (!autoresVivosEncontrados) {
            System.out.println("No hay autores vivos en el año " + anio + ".");
        }
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

}

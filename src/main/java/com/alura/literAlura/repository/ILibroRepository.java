package com.alura.literAlura.repository;

import com.alura.literAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILibroRepository extends JpaRepository<Libro, Long> {
    Libro findByTitulo(String titulo);
    List<Libro> findByIdioma(String idioma);
}

package com.alura.literAlura.repository;

import com.alura.literAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNombre(String nombre);
}

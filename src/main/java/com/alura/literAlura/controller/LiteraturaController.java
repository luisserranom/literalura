package com.alura.literAlura.controller;

import com.alura.literAlura.model.Libro;
import com.alura.literAlura.service.LiteraturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LiteraturaController {
    //buscarLibroPorTitulo

    @Autowired
    private LiteraturaService literaturaService;

    public void buscarLibroPorTitulo(String titulo) {
        literaturaService.buscarLibroPorTitulo(titulo);
    }

    public void listarLibrosRegistrados() {
        literaturaService.listarLibrosRegistrados();
    }

    public void listarAutoresRegistrados() {
        literaturaService.listarAutoresRegistrados();
    }

    public void listarAutoresVivos(int anio) {
        literaturaService.listarAutoresVivos(anio);
    }

    @GetMapping("/libros/idioma/{idioma}")
    public List<Libro> listarLibrosPorIdioma(@PathVariable String idioma) {
        return literaturaService.listarLibrosPorIdioma(idioma);
    }
}

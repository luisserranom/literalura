package com.alura.literAlura;

import com.alura.literAlura.controller.LiteraturaController;
import com.alura.literAlura.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}
}

@Component
class MenuRunner implements CommandLineRunner {

	@Autowired
	private LiteraturaController controller;  // Inyección de dependencias

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			mostrarMenu();
			int opcion = obtenerOpcion(scanner);

			switch (opcion) {
				case 1 -> buscarLibroPorTitulo(scanner);
				case 2 -> listarLibrosRegistrados();
				case 3 -> listarAutoresRegistrados();
				case 4 -> listarAutoresVivos(scanner);
				case 5 -> listarLibrosPorIdioma(scanner);
				case 0 -> {
					System.out.println("¡Hasta luego!");
					return;
				}
				default -> System.out.println("Opción no válida. Intenta de nuevo.");
			}
		}
	}

	private void mostrarMenu() {
		System.out.println("----- Menú -----");
		System.out.println("1 - Buscar libro por título");
		System.out.println("2 - Listar libros registrados");
		System.out.println("3 - Listar autores registrados");
		System.out.println("4 - Listar autores vivos en un determinado año");
		System.out.println("5 - Listar libros por idioma");
		System.out.println("0 - Salir");
		System.out.print("Selecciona una opción: ");
	}

	private int obtenerOpcion(Scanner scanner) {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Por favor, introduce un número válido.");
			scanner.nextLine(); // Consumir entrada no válida
			return -1;
		}
	}

	private void buscarLibroPorTitulo(Scanner scanner) {
		System.out.print("Introduce el título del libro: ");
		scanner.nextLine(); // Consumir el salto de línea
		String titulo = scanner.nextLine();
		controller.buscarLibroPorTitulo(titulo);
	}

	private void listarLibrosRegistrados() {
		controller.listarLibrosRegistrados();
	}

	private void listarAutoresRegistrados() {
		controller.listarAutoresRegistrados();
	}

	private void listarAutoresVivos(Scanner scanner) {
		System.out.print("Introduce el año: ");
		try {
			int anio = scanner.nextInt();
			controller.listarAutoresVivos(anio);
		} catch (Exception e) {
			System.out.println("Por favor, introduce un año válido.");
			scanner.nextLine(); // Consumir entrada no válida
		}
	}

	private void listarLibrosPorIdioma(Scanner scanner) {
		System.out.print("Introduce el idioma: ");
		scanner.nextLine(); // Consumir el salto de línea
		String idioma = scanner.nextLine();
		List<Libro> libros = controller.listarLibrosPorIdioma(idioma);
		if (libros.isEmpty()) {
			System.out.println("No se encontraron libros en ese idioma.");
		} else {
			System.out.println("Libros en el idioma " + idioma + ":");
			libros.forEach(libro -> System.out.println(libro.getTitulo()));
		}
	}
}

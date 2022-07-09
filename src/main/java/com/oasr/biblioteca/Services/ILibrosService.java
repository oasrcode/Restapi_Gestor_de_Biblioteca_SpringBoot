package com.oasr.biblioteca.Services;



import com.oasr.biblioteca.Modelos.Libros;


import java.util.List;

public interface ILibrosService {
    Libros BuscarID(Long id);
    List<Libros> BuscarTodos();
    Libros BuscarPorISBN(Long isbn);
    List<Libros> BuscarPorTitulo(String titulo);
    void Guardar(Libros libro);
    void Borrar(Libros libro);
    void Actualizar(Libros libro);
}

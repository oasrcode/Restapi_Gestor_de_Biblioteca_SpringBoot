package com.oasr.biblioteca.DAO;

import com.oasr.biblioteca.Modelos.Libros;


import java.util.List;

public interface ILibrosDAO {

    Libros BuscarID(Long id);
    Libros BuscarPorISBN(Long isbn);
    List<Libros> BuscarPorTitulo(String title);
    List<Libros> BuscarTodos();
    void Guardar(Libros libro);
    void Borrar(Libros libro);
    void Actualizar(Libros libro);
}

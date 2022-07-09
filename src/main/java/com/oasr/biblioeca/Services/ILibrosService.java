package com.oasr.biblioeca.Services;



import com.oasr.biblioeca.Modelos.Libros;


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

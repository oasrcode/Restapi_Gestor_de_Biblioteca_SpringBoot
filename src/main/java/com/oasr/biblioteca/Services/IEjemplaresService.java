package com.oasr.biblioteca.Services;

import com.oasr.biblioteca.Modelos.Ejemplares;

import java.util.List;

public interface IEjemplaresService {
    Ejemplares BuscarID(Long id);
    List<Ejemplares> BuscarTodos();
    List<Ejemplares> BuscarPorISBN(Long isbn);
    Ejemplares BuscarPorCodigoEjemplar(String codEjemplar);
    void Guardar(Ejemplares ejemplar);
    void Borrar(Ejemplares ejemplar);
    void Actualizar(Ejemplares ejemplar);
}

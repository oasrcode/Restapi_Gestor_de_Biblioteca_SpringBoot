package com.oasr.biblioeca.DAO;

import com.oasr.biblioeca.Modelos.Ejemplares;


import java.util.List;

public interface IEjemplaresDAO {

    Ejemplares BuscarID(Long id);
    List<Ejemplares> BuscarTodos();
    List<Ejemplares> BuscarPorISBN(Long isbn);
    Ejemplares BuscarPorCodigoEjemplar(String codEjemplar);
    void Guardar(Ejemplares ejemplar);
    void Borrar(Ejemplares ejemplar);
    void Actualizar(Ejemplares ejemplar);
}

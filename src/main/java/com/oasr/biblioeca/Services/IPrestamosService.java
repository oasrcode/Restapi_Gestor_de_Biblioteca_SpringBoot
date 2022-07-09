package com.oasr.biblioeca.Services;

import com.oasr.biblioeca.Modelos.Prestamos;

import java.util.List;

public interface IPrestamosService {

    Prestamos BuscarID(Long id);
    List<Prestamos> BuscarTodos();
    List<Prestamos> BuscarPorNumeroCarnet(Long nCarnet);
    Prestamos BuscarPorCodigoEjemplar(String ejemplarCod);
    void Guardar(Prestamos prestamos);
    void Borrar(Prestamos prestamos);
    void Actualizar(Prestamos prestamos);
}

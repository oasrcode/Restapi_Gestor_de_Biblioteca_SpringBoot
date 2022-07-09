package com.oasr.biblioeca.DAO;




import com.oasr.biblioeca.Modelos.Prestamos;

import java.util.List;


public interface IPrestamosDAO {


    Prestamos BuscarID(Long id);
    List<Prestamos> BuscarTodos();
    Prestamos BuscarPorCodigoEjemplar(String ejemplarCod);
    List<Prestamos> BuscarPorNumeroCarnet(Long nCarnet);
    void Guardar(Prestamos prestamos);
    void Borrar(Prestamos prestamos);
    void Actualizar(Prestamos prestamos);
}

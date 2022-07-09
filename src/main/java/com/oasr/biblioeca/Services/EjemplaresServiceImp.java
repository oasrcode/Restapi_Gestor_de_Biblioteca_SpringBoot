package com.oasr.biblioeca.Services;

import com.oasr.biblioeca.DAO.IEjemplaresDAO;
import com.oasr.biblioeca.Modelos.Ejemplares;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EjemplaresServiceImp implements IEjemplaresService{

    @Autowired
    IEjemplaresDAO iEjemplaresDAO;
    @Override
    public Ejemplares BuscarID(Long id) {
        return iEjemplaresDAO.BuscarID(id);
    }

    @Override
    public List<Ejemplares> BuscarTodos() {
        return iEjemplaresDAO.BuscarTodos();
    }

    @Override
    public List<Ejemplares> BuscarPorISBN(Long isbn) {
        return iEjemplaresDAO.BuscarPorISBN(isbn);
    }

    @Override
    public Ejemplares BuscarPorCodigoEjemplar(String codEjemplar) {
        return iEjemplaresDAO.BuscarPorCodigoEjemplar(codEjemplar);
    }

    @Override
    public void Guardar(Ejemplares ejemplar) {
    iEjemplaresDAO.Guardar(ejemplar);
    }

    @Override
    public void Borrar(Ejemplares ejemplar) {
    iEjemplaresDAO.Borrar(ejemplar);
    }

    @Override
    public void Actualizar(Ejemplares ejemplar) {
    iEjemplaresDAO.Actualizar(ejemplar);
    }
}

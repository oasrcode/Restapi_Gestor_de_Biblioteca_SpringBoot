package com.oasr.biblioeca.Services;

import com.oasr.biblioeca.DAO.ILibrosDAO;
import com.oasr.biblioeca.Modelos.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class LibrosServiceImp implements ILibrosService{

    @Autowired
    ILibrosDAO iLibrosDAO;

    @Override
    public Libros BuscarID(Long id) {
        return iLibrosDAO.BuscarID(id);
    }

    @Override
    public List<Libros> BuscarTodos() {
        return iLibrosDAO.BuscarTodos();
    }

    @Override
    public Libros BuscarPorISBN(Long isbn) {
        return iLibrosDAO.BuscarPorISBN(isbn);
    }

    @Override
    public List<Libros> BuscarPorTitulo(String titulo) {
        return iLibrosDAO.BuscarPorTitulo(titulo);
    }

    @Override
    public void Guardar(Libros libro) {
        iLibrosDAO.Guardar(libro);
    }

    @Override
    public void Borrar(Libros libro) {
        iLibrosDAO.Borrar(libro);
    }

    @Override
    public void Actualizar(Libros libro) {
        iLibrosDAO.Actualizar(libro);
    }
}

package com.oasr.biblioeca.Services;

import com.oasr.biblioeca.DAO.IPrestamosDAO;
import com.oasr.biblioeca.Modelos.Prestamos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosServiceImp implements IPrestamosService{

    @Autowired
    IPrestamosDAO iPrestamosDAO;


    @Override
    public Prestamos BuscarID(Long id) {
        return iPrestamosDAO.BuscarID(id);
    }

    @Override
    public List<Prestamos> BuscarTodos() {
        return iPrestamosDAO.BuscarTodos();
    }


    @Override
    public List<Prestamos> BuscarPorNumeroCarnet(Long nCarnet) {
        return iPrestamosDAO.BuscarPorNumeroCarnet(nCarnet);
    }

    @Override
    public Prestamos BuscarPorCodigoEjemplar(String ejemplarCod) {
        return iPrestamosDAO.BuscarPorCodigoEjemplar(ejemplarCod);
    }

    @Override
    public void Guardar(Prestamos prestamos) {
        iPrestamosDAO.Guardar(prestamos);
    }

    @Override
    public void Borrar(Prestamos prestamos) {

        iPrestamosDAO.Borrar(prestamos);
    }

    @Override
    public void Actualizar(Prestamos prestamos) {
        iPrestamosDAO.Actualizar(prestamos);
    }
}

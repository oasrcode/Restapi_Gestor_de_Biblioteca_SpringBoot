package com.oasr.biblioteca.Services;

import com.oasr.biblioteca.DAO.IUsuariosDAO;
import com.oasr.biblioteca.Modelos.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuariosServiceImp implements IUsuariosService {
    @Autowired
    IUsuariosDAO iUsuariosDAO;


    @Override
    public Usuarios BuscarID(Long id) {
        return iUsuariosDAO.BuscarID(id);
    }

    @Override
    public List<Usuarios> BuscarTodos() {
        return iUsuariosDAO.BuscarTodos();
    }

    @Override
    public Usuarios BuscarPorNumeroCarnet(Long nCarnet) {
        return iUsuariosDAO.BuscarPorNumeroCarnet(nCarnet);
    }

    @Override
    public List<Usuarios> BuscarPorNomApel(String namesurn) {
        return iUsuariosDAO.BuscarPorNomApel(namesurn);
    }

    @Override
    public void Guardar(Usuarios usuario) {
    iUsuariosDAO.Guardar(usuario);
    }

    @Override
    public void Borrar(Usuarios usuario) {
    iUsuariosDAO.Borrar(usuario);
    }

    @Override
    public void Actualizar(Usuarios usuario) {
        iUsuariosDAO.Actualizar(usuario);
    }
}

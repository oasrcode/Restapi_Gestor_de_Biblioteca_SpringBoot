package com.oasr.biblioteca.DAO;

import com.oasr.biblioteca.Modelos.Usuarios;

import java.util.List;

public interface IUsuariosDAO  {

    Usuarios BuscarID(Long id);
    Usuarios BuscarPorNumeroCarnet(Long nCarnet);
    List<Usuarios> BuscarTodos();
    List<Usuarios> BuscarPorNomApel(String nomApel);
    void Guardar(Usuarios usuario);
    void Borrar(Usuarios usuario);
    void Actualizar(Usuarios usuario);


}

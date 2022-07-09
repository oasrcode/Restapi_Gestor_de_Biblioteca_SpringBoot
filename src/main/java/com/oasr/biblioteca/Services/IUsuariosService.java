package com.oasr.biblioteca.Services;

import com.oasr.biblioteca.Modelos.Usuarios;

import java.util.List;

public interface IUsuariosService {
    Usuarios BuscarID(Long id);
    List<Usuarios> BuscarTodos();
    Usuarios BuscarPorNumeroCarnet(Long nCarnet);
    List<Usuarios> BuscarPorNomApel(String namesurn);
    void Guardar(Usuarios usuario);
    void Borrar(Usuarios usuario);
    void Actualizar(Usuarios usuario);
}

package com.oasr.biblioeca.DAO;

import com.oasr.biblioeca.Modelos.Usuarios;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDAOImp implements IUsuariosDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Usuarios BuscarID(Long id) {
        return entityManager.find(Usuarios.class,id);
    }

    @Override
    public Usuarios BuscarPorNumeroCarnet(Long nCarnet) {
        return (Usuarios)entityManager.
                createQuery("Select u from Usuarios u where u.nCarnet = :codigo")
                .setParameter("codigo",nCarnet)
                .getSingleResult();
    }


    @Override
    public List<Usuarios> BuscarTodos() {

        return entityManager.createQuery("from Usuarios ").getResultList();
    }

    @Override
    public List<Usuarios> BuscarPorNomApel(String nomApel) {


        return entityManager.createQuery("" +
                "select u from Usuarios u " +
                "where concat(u.nombre,' ',u.apellidos) like :namesurn").
                setParameter("namesurn","%"+ nomApel +"%").getResultList();
    }

    @Override
    public void Guardar(Usuarios usuario) {

        entityManager.persist(usuario);
    }

    @Override
    public void Borrar(Usuarios usuario) {
        if(entityManager.contains(usuario)){
            entityManager.remove(usuario);
        }

    }

    @Override
    public void Actualizar(Usuarios usuario) {
        entityManager.merge(usuario);
    }
}

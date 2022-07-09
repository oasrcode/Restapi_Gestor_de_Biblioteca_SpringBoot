package com.oasr.biblioteca.DAO;


import com.oasr.biblioteca.Modelos.Prestamos;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PrestamosDAOImp implements  IPrestamosDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Prestamos BuscarID(Long id) {

        return entityManager.find(Prestamos.class,id);
    }

    @Override
    public List<Prestamos> BuscarTodos() {
        return entityManager.createQuery("from Prestamos").getResultList();
    }


    @Override
    public Prestamos BuscarPorCodigoEjemplar(String ejemplarCod) {
        return (Prestamos) entityManager.createQuery("select p from Prestamos p " +
                "where p.ejemplar.codigo like :ejemplarCod").
        setParameter("ejemplarCod",ejemplarCod).getSingleResult();
    }

    @Override
    public List<Prestamos> BuscarPorNumeroCarnet(Long nCarnet) {
        return entityManager.
                createQuery("select p from Prestamos p" +
                        " where p.usuario.nCarnet= :nCarnet ").
                setParameter("nCarnet",nCarnet).getResultList();
    }

    @Override
    public void Guardar(Prestamos prestamos) {
        entityManager.persist(prestamos);
    }

    @Override
    public void Borrar(Prestamos prestamos) {
        if(entityManager.contains(prestamos)){
            entityManager.remove(prestamos);

        }
    }

    @Override
    public void Actualizar(Prestamos prestamos) {
    entityManager.merge(prestamos);
    }
}

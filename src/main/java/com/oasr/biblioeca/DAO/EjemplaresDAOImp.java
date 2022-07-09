package com.oasr.biblioeca.DAO;

import com.oasr.biblioeca.Modelos.Ejemplares;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EjemplaresDAOImp implements IEjemplaresDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Ejemplares BuscarID(Long id) {
       return entityManager.find(Ejemplares.class,id);
    }

    @Override
    public List<Ejemplares> BuscarTodos() {
        return entityManager.createQuery("from Ejemplares").getResultList();
    }

    @Override
    public List<Ejemplares> BuscarPorISBN(Long isbn) {
        return entityManager.
                createQuery("select e from Ejemplares e where e.libro.isbn = :isbn ").
                setParameter("isbn",isbn).getResultList();
    }

    @Override
    public Ejemplares BuscarPorCodigoEjemplar(String codEjemplar) {
        return (Ejemplares) entityManager.createQuery("select e from Ejemplares e " +
                " where e.codigo like :codEjemplar").
                setParameter("codEjemplar",codEjemplar).getSingleResult();
    }

    @Override
    public void Guardar(Ejemplares ejemplar) {
        entityManager.persist(ejemplar);
    }

    @Override
    public void Borrar(Ejemplares ejemplar) {

        if(entityManager.contains(ejemplar)){
            entityManager.remove(ejemplar);
        }

    }

    @Override
    public void Actualizar(Ejemplares ejemplar) {
    entityManager.merge(ejemplar);
    }
}

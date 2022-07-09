package com.oasr.biblioeca.DAO;


import com.oasr.biblioeca.Modelos.Libros;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class LibrosDAOImp implements ILibrosDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Libros BuscarID(Long id) {
        return entityManager.find(Libros.class,id);
    }

    @Override
    public Libros BuscarPorISBN(Long isbn) {
        return (Libros) entityManager.createQuery(
                        "select l from Libros l where l.isbn = :isbn")
                .setParameter("isbn",isbn).getSingleResult();
    }

    @Override
    public List<Libros> BuscarPorTitulo(String title) {
        return entityManager.createQuery(
                "select l from Libros l where l.titulo like :title")
                .setParameter("title","%"+title+"%").getResultList();
    }

    @Override
    public List<Libros> BuscarTodos() {
        return entityManager.createQuery("from Libros ").getResultList();
    }

    @Override
    public void Guardar(Libros libro) {
        entityManager.persist(libro);
    }

    @Override
    public void Borrar(Libros libro) {
        if(entityManager.contains(libro)){
            entityManager.remove(libro);
        }


    }

    @Override
    public void Actualizar(Libros libro) {
        entityManager.merge(libro);

    }
}

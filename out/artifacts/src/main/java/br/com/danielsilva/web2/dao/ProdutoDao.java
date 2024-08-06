package br.com.danielsilva.web2.dao;

import br.com.danielsilva.web2.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDao implements IProdutoDao {

    @Override
    public Produto cadastrar(Produto produto) {

        EntityManagerFactory entityManagerFactory=
                Persistence.createEntityManagerFactory("Web");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return produto ;
    }







}

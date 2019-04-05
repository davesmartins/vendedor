/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifet.es.vendor.api.repository;

import br.edu.ifet.es.vendor.api.model.Login;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

public class LoginDAO {

    private EntityManager em;

    public LoginDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Login login) {
//        EntityManager em = PersistenceUtil.getEntityManager();
//        EntityTransaction tx = em.getTransaction();
        try {
            //     tx.begin();
            if (login.getId() != null) {
                em.merge(login);
            } else {
                em.persist(login);
            }
            //   tx.commit();

        } catch (Exception e) {
            //  if (tx != null && tx.isActive()) {
            //      tx.rollback();
            //  }
            throw new RuntimeException(e);
        } finally {
            //  em.close();
        }

    }

    public void delete(Login login) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Login.class, login.getId()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    public Login find(long id) {
        //EntityTransaction tx = em.getTransaction();
        Login login = null;
        try {
            //  tx.begin();
            login = em.find(Login.class, id);
            // tx.commit();
        } catch (Exception e) {
            //  if (tx != null && tx.isActive()) {
            //      tx.rollback();
            //  }
            throw new RuntimeException(e);
        } finally {
            //em.close();
        }
        return login;
    }

    public List<Login> findAll() {
        // EntityTransaction tx = em.getTransaction();
        List<Login> logins = null;
        try {
            //   tx.begin();
            TypedQuery<Login> query
                    = em.createQuery("select l from Login l", Login.class);
            logins = query.getResultList();
            // tx.commit();
        } catch (Exception e) {
            //if (tx != null && tx.isActive()) {
            //    tx.rollback();
            //}
            throw new RuntimeException(e);
        } finally {
            // em.close();
        }
        return logins;
    }

    public Login logar(String login, String senha) {
        TypedQuery<Login> query = em.createQuery("select l from  Login l where l.login = :login AND l.senha = :senha ", Login.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try {
             return query.getSingleResult();
            
        } catch (NoResultException e) {
            return null;  
        }
    }
}

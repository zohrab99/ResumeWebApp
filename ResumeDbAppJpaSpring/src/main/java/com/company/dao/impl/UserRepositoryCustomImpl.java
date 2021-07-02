/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Zohrab
 */

@Repository("userDaoImpl")

public class UserRepositoryCustomImpl  implements UserRepositoryCustom {

    public UserRepositoryCustomImpl(){
        System.out.println("created UserDaoImpl UID=2453");
    }

    @PersistenceContext
    EntityManager em;


    @Cacheable(value = "users")
    @Override
    public List<User> getAll(String name, String surname, Integer nationality) {


        String sql = "select u from User u where 1=1 ";

        if (name != null && !name.trim().isEmpty()) {
            sql += " and u.name= :name";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            sql += " and u.surname= :surname";

        }
        if (nationality != null) {
            sql += " and u.nationality.id= :natio";
        }

        Query query = em.createQuery(sql, User.class);

        if (name != null && !name.trim().isEmpty()) {

            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationality != null) {
            query.setParameter("natio", nationality);
        }

        List<User> list = query.getResultList();


        return list;


    }

    @Override
    public User findByEmail(String email) {


        Query query = em.createQuery("select u from User u where u.email= :e ", User.class);

        query.setParameter("e", email);

        List<User> list = query.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }


        return null;

    }

    private static BCrypt.Hasher crypt =BCrypt.withDefaults();


    @Override
    public boolean updateUser(User u) {


        em.merge(u);

        return true;

    }

    @Override
    public boolean deleteUser(int id) {


        User u = em.find(User.class, id);


        em.remove(u);


        return true;
    }

    @Override
    public User getById(int userId) {

        User u = em.find(User.class, userId);


        return u;

    }

    @Override
    public boolean addUser(User u) {

        u.setPassword(crypt.hashToString(4,u.getPassword().toCharArray()));

        em.persist(u);


        return true;
    }

    //    @Override
//    public User findByEmailPassword(String email, String password) {
//
//
//        Query query = em.createQuery("select u from User u where u.email= :e and u.password= :p ", User.class);
//
//        query.setParameter("e", email);
//        query.setParameter("p", password);
//
//        List<User> list = query.getResultList();
//
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//
//
//        return null;
//
//    }

//    @Override
//    public User findByEmailPasswordCritBuild(String email, String password) {
//
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> qr = cb.createQuery(User.class);
//        Root<User> root = qr.from(User.class);
//
//        CriteriaQuery<User> qr2 = qr.where(cb.equal(root.get("email"), email), cb.equal(root.get("password"), password));
//
//        Query query = em.createQuery(qr2);
//
//        List<User> list = query.getResultList();
//
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//
//        return null;
//
//
//    }


}

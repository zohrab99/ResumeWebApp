/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;


import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Zohrab
 */

@Service
@Transactional

public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDaoImpl")
    UserRepositoryCustom userDao;


    @Override
    public List<User> getAll(String name, String surname, Integer nationality) {


        return userDao.getAll(name, surname, nationality);


    }

    @Override
    public User findByEmail(String email) {


        return userDao.findByEmail(email);

    }


    @Override
    public boolean updateUser(User u) {


        return userDao.updateUser(u);

    }

    @Override
    public boolean deleteUser(int id) {


        return userDao.deleteUser(id);
    }

    @Override
    public User getById(int userId) {


        return userDao.getById(userId);

    }

    @Override
    public boolean addUser(User u) {


        return userDao.addUser(u);
    }




}

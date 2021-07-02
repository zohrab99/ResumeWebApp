/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.User;

import java.util.List;

/**
 *
 * @author Zohrab
 */
public interface UserServiceInter {

    public User getById(int userId);

    public List<User> getAll(String name,String surname,Integer nationality);

    public User findByEmail(String email);

    public boolean updateUser(User u);

    public boolean deleteUser(int id);

    public boolean addUser(User u);






}

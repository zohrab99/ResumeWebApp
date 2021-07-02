/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.User;

import java.util.List;

/**
 *
 * @author Zohrab
 */
public interface UserRepositoryCustom {
    
    public User getById(int userId);
    
    public List<User> getAll(String name,String surname,Integer nationality);

    public User findByEmail(String email);

   // public User findByEmailPassword(String email, String password);
    
   // public User findByEmailPasswordCritBuild(String email, String password);
    
    public boolean updateUser(User u);
    
    public boolean deleteUser(int id);
    
    public boolean addUser(User u);


    
    
}

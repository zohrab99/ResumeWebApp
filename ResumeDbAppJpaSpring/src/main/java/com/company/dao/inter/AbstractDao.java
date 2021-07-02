/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zohrab
 */
public abstract  class AbstractDao {
    
    public Connection connect() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         String url="jdbc:mysql://localhost:3306/resume";
        String username="root";
        String password="qwerty";
        
        Connection connection = DriverManager.getConnection(url, username, password);
        
        return connection;
        
    }
    
    private static EntityManagerFactory emfactory=null;
    
    public EntityManager em(){
        if(emfactory==null){
          emfactory=Persistence.createEntityManagerFactory("resumeappPU");
      }
        EntityManager em=emfactory.createEntityManager();
        
     return em;
    }
    
    public void closeEmf(){
        emfactory.close();
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zohrab
 */
public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        
         List<Country> list=new ArrayList<>();
        
        try(Connection connection = connect()) {
             Statement createStatement = connection.createStatement();
            createStatement.execute("select * from country");
             ResultSet rt = createStatement.getResultSet();
             
             while(rt.next()){
                 int id=rt.getInt("id");
                 String name=rt.getString("name");
                 String nationality=rt.getString("nationality");
                 
                 Country country=new Country(id, name, nationality);
                 list.add(country);
             }
            
        } catch (SQLException ex) {
         ex.printStackTrace();
        }
     return list;   
    }

    @Override
    public Country getCntryByName(String birth_place) {
        Country country=null;
          try(Connection connection = connect()) {
            PreparedStatement pr = connection.prepareStatement("select * from country where name=?");
            pr.setString(1, birth_place);
            pr.execute();
           
             ResultSet rt = pr.getResultSet();
             
             while(rt.next()){
                 int id=rt.getInt("id");
                 String name=rt.getString("name");
                
                country=new Country(id, name,null);
                 
             }
            
        } catch (SQLException ex) {
         ex.printStackTrace();
             }  
         return country; 
          
    }

    @Override
    public Country getCntryByNatio(String natio) {
Country country=null;
          try(Connection connection = connect()) {
            PreparedStatement pr = connection.prepareStatement("select * from country where nationality=?");
            pr.setString(1, natio);
            pr.execute();
           
             ResultSet rt = pr.getResultSet();
             
             while(rt.next()){
                 int id=rt.getInt("id");
                 String natioName=rt.getString("nationality");
                
                country=new Country(id, null,natioName);
                 
             }
            
        } catch (SQLException ex) {
         ex.printStackTrace();
             }  
         return country; 
    }




}

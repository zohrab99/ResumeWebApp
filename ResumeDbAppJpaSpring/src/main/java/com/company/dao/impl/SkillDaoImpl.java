/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import org.springframework.stereotype.Repository;

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

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
      List<Skill> list=new ArrayList<>();
      
        try( Connection connection = connect()) {
            Statement st = connection.createStatement();
            st.execute("select * from skill");
            ResultSet rt = st.getResultSet();
            while(rt.next()){
                int id = rt.getInt("id");
                String name = rt.getString("name");
                Skill skill=new Skill(id, name);
                list.add(skill);
            }
            
            
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return list; 
    }

    @Override
    public Skill getById(int skillId) {
        Skill skill = null;
        try(Connection connect = connect()) {

            Statement st = connect.createStatement();
            st.execute("select * from skill where id="+skillId);
            ResultSet rt = st.getResultSet();
            while(rt.next()){
                int id = rt.getInt("id");
                String name=rt.getString("name");
                skill= new Skill(id, name);
              }
           
            
        } catch (SQLException ex) {
            ex.printStackTrace();
         }
        return skill;
     }

    @Override
    public boolean addSkill(Skill skill) {
        try {
            Connection connection = connect();
            PreparedStatement prs = connection.prepareStatement("insert into skill (name) values(?)",Statement.RETURN_GENERATED_KEYS);
             prs.setString(1, skill.getName());
             prs.execute();
            ResultSet rt = prs.getGeneratedKeys();
            while(rt.next()){
                System.out.println("addSkill de skillID  "+rt.getInt(1));
                skill.setId(rt.getInt(1));
                
            }
            

            
           
        } catch (SQLException ex) {
            System.out.println("XETA ADD SKILL da");
            ex.printStackTrace();
            return false;
            
        }
     return true;              
    }

    @Override
    public boolean updateSkill(Skill s) {
        try( Connection connection = connect()) {
            PreparedStatement prs = connection.prepareStatement("update skill set name=? where id=?");
            prs.setInt(2, s.getId());
            prs.setString(1, s.getName());
           return prs.execute();
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
            
        }
        
    }

    @Override
    public boolean deleteSkill(int skillId) {
        try( Connection connection = connect()) {
            PreparedStatement prs = connection.prepareStatement("delete from skill where id=?");
            prs.setInt(1, skillId);
           return prs.execute();
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
            
        }
    }
   
    
    
    
    
    
    
    
    
}

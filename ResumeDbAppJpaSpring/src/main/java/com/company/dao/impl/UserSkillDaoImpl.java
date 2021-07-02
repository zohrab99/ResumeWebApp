/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zohrab
 */
public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    
   
    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> list=new ArrayList<>();
        
        try(Connection connection = connect()) {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT" +
                    "	us.id AS user_skill_id," +
                    "	u.*," +
                    "	s.id AS skill_id," +
                    "	s.NAME AS skill_name," +
                    "	us.power " +
                    "FROM" +
                    "	user_skill us" +
                    "	 LEFT JOIN user u ON us.user_id = u.id" +
                    "	LEFT JOIN skill s ON us.skill_id = s.id" +
                    "	where us.user_id=?");
            prepareStatement.setInt(1, userId);
            prepareStatement.execute();
            ResultSet rt = prepareStatement.getResultSet();
            while(rt.next()){
                UserSkill userSkill = getUserSkill(rt);
                list.add(userSkill);
                
           }
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return list;
    }
    
    public UserSkill getUserSkill(ResultSet rt) throws SQLException{
       
        int user_skill_id = rt.getInt("user_skill_id");
        int user_id=rt.getInt("id");
        int skill_id=rt.getInt("skill_id");
        String skill_name=rt.getString("skill_name");
        int power=rt.getInt("power");
        
         Skill skill=new Skill(skill_id,skill_name);
         User user=new User(user_id);
         
         UserSkill usk=new UserSkill(user_skill_id, user, skill, power);
         
         return usk;
        
         }

    @Override
    public boolean addUserSkill(UserSkill u) {
   try( Connection connection=connect()) {
            
            PreparedStatement prSt = connection.prepareStatement("insert  into user_skill (user_id,skill_id,power) values(?,?,?)");

               prSt.setInt(1, u.getUser().getId());
               prSt.setInt(2, u.getSkill().getId());
                prSt.setInt(3, u.getPower());
         return  prSt.execute();
            
        } catch (SQLException ex) {
            System.out.println("Xeta ADD USER SKILLDE");
            ex.printStackTrace();
            return false;
            
            
        } }

     @Override
    public boolean deleteUserSkill(int UserSkillId) {
        try( Connection connection = connect()) {
            PreparedStatement prs = connection.prepareStatement("delete from user_skill where id=?");
            prs.setInt(1, UserSkillId);
           return prs.execute();
            
           
        } catch (SQLException ex) {
            System.out.println("Xeta DELETE USER SKILLDE");
            ex.printStackTrace();
            return false;
            
        }
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
      try( Connection connection = connect()) {
            PreparedStatement prs = connection.prepareStatement("update user_skill set user_id=?,skill_id=?,power=? where id=?");
            prs.setInt(1,u.getUser().getId());
            prs.setInt(2,u.getSkill().getId());
            prs.setInt(3,u.getPower());
            prs.setInt(4,u.getId());
           return prs.execute();
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
            
        } }
    
}

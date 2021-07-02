/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.EmplyomentHistoryInter;
import com.company.entity.EmplyomentHistory;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zohrab
 *
 */

@Repository
public class EmplyomentHistoryImpl  implements EmplyomentHistoryInter {

    @PersistenceContext
    EntityManager em;

    public EmplyomentHistoryImpl() {
        System.out.println(" created EMPLYOMENTHistoryIMpl");
    }

    @Override
    public List<EmplyomentHistory> getAllEmpHistoryByUserId(int userId) {
        Query query=em.createQuery("SELECT e FROM EmplyomentHistory e WHERE e.user.id = :id",EmplyomentHistory.class);
        query.setParameter("id",userId);
        List<EmplyomentHistory> list = query.getResultList();


        return list;

    }
    

    
}

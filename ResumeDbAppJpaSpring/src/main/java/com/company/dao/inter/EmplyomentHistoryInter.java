/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.EmplyomentHistory;

import java.util.List;

/**
 *
 * @author Zohrab
 */
public interface EmplyomentHistoryInter {
    
    
    
    public List<EmplyomentHistory> getAllEmpHistoryByUserId(int userId);

}

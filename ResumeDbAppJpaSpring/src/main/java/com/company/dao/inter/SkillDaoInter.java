/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Skill;

import java.util.List;

/**
 *
 * @author Zohrab
 */
public interface SkillDaoInter {
    
    public List<Skill> getAll();
    public Skill getById(int skillId);
    public boolean addSkill(Skill s);
    public boolean updateSkill(Skill s);
    public boolean deleteSkill(int skillId);
    
}

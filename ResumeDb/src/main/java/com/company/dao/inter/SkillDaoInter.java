package com.company.dao.inter;

import com.company.entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    List<Skill> getAllSkill();
    public boolean addSkills(Skill s);
    public Skill getById(int id);
    boolean updateSkill(Skill skill);
   boolean removeSkill(int id);

   
}

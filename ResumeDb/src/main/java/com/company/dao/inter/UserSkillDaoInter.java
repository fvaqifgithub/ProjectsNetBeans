package com.company.dao.inter;

import com.company.entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {


   public List<UserSkill> getAllUserSkills(int id);
 public boolean updateUserSkill(UserSkill uskill);
    public boolean removeSkill(int index);
    public boolean addUserSkill(UserSkill userskill);



}

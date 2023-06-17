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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    public UserSkill getUserSkill(ResultSet rs) throws SQLException {
        int userskillId = rs.getInt("userSkillId");
        int skillId = rs.getInt("skill_id");
        int userId = rs.getInt("id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        return new UserSkill(userskillId, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllUserSkills(int id) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement prepare = c.prepareStatement("select "
                    + " us.id as userSkillId ,"
                    + " u.*, "
                    + " us.skill_id, "
                    + " s.name as skill_name, "
                    + " us.power "
                    + " from "
                    + " user_skill us "
                    + " left join user u on us.user_id=u.id "
                    + " left join skill s on us.skill_id=s.id  "
                    + "where us.user_id=" + id);
            prepare.execute();

            ResultSet r = prepare.getResultSet();

            while (r.next()) {
                UserSkill user = getUserSkill(r);
                result.add(user);

            }
        } catch (Exception ex) {
        }
        return result;
    }

    @Override
    public boolean updateUserSkill(UserSkill uskill) {
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("update user_skill set power=?,user_id=?,skill_id=? where id=? ");
            p.setInt(1, uskill.getPower());
            p.setInt(2, uskill.getUser().getId());
            p.setInt(3, uskill.getSkill().getId());
            p.setInt(4, uskill.getId());
            return p.execute();
            
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        try (Connection c = connect()) {
            PreparedStatement st = c.prepareStatement("insert into user_skill(power,user_id,skill_id)values(?,?,?)");
           st.setInt(1, us.getPower());
            st.setInt(2, us.getUser().getId());
            st.setInt(3, us.getSkill().getId());

            return st.execute();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean removeSkill(int index) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user_skill where id=" + index);

        } catch (Exception e) {
        }
        return false;
    }
}

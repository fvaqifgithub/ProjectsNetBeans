package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    public Skill getSkill(ResultSet r) throws Exception {
        int id = r.getInt("id");
        String name = r.getString("name");
        return new Skill(id, name);
    }

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("select * from skill where id=id");
            ResultSet r = stmt.getResultSet();
            while (r.next()) {
                Skill s2 = getSkill(r);
                result.add(s2);
            }

        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("UPDATE skill set  name=? where id=? ");
            p.setString(1, skill.getName());
            p.setInt(2, skill.getId());
            return p.execute();
        } catch (Exception ex) {
        }
        return false;
    }

    /**
     *
     *\n
     */
    @Override
    public boolean addSkills(Skill s) {
        try (Connection c = connect()) {
            PreparedStatement st = c.prepareStatement("insert into skill(name)values(?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, s.getName());
            ResultSet g = st.getGeneratedKeys();
            if (g.next()) {
                s.setId(g.getInt(1));
            }
            st.execute();

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Skill getById(int id) {
        Skill result = null;
        try (Connection c = connect()) {
            Statement st = c.createStatement();
            st.execute("select * from  skill where id =" + id);
            ResultSet r = st.getResultSet();
            while (r.next()) {
                int index = r.getInt("id");
                String name = r.getString("name");

                result = new Skill(index, name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean removeSkill(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from skill where id =" + id);
        } catch (Exception e) {
        }
        return false;
    }
}

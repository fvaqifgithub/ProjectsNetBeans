package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private User getUser(ResultSet r) throws Exception {
        int id = r.getInt("id");
        String name = r.getString("name");
        String surname = r.getString("surname");
        String telephone = r.getString("telephone");
        String address = r.getString("address");
        String email = r.getString("email");
        String profileDesc = r.getString("profile_description");
        int nationalityId = r.getInt("nationality_id");
        int birthplaceId = r.getInt("birthplace_id");
        String nationalityStr = r.getString("nationality");
        Date birthdate = r.getDate("birthdate");
        String birthplaceStr = r.getString("birthplace");
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);
        Country nationality = new Country(nationalityId, null, nationalityStr);

        return new User(id, name, surname, email, telephone, profileDesc, address, birthdate, birthplace, nationality);
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement st = c.createStatement();
            st.execute("select "
                    + "u.*, "
                    + "n.nationality, "
                    + "c.name as birthplace "
                    + "from user u "
                    + "left join country n on u.nationality_id = n.id "
                    + "left join country c on u.birthplace_id = c.id ");
            ResultSet r = st.getResultSet();
            while (r.next()) {
                User u = getUser(r);
                result.add(u);
            }
            

        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("update user set name=?,surname=?,profile_description=?,telephone=?,email=?,address=?,birthdate=?,birthplace_id=?,nationality_id=? where id=?");
            p.setString(1, u.getName());
            p.setString(2, u.getSurname());
            p.setString(3, u.getProfileDesc());
            p.setString(4, u.getTelephone());
            p.setString(5, u.getEmail());
            p.setString(6, u.getAddress());
            p.setDate(7, u.getBirthdate());
            p.setInt(8, u.getBirthplace().getId());
            p.setInt(9, u.getNationality().getId());
            p.setInt(10, u.getId());

            return p.execute();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement st = c.prepareStatement("insert into user(name,surname,telephone,email,profile_description)values(?,?,?,?,?)");
            st.setString(1, u.getName());
            st.setString(2, u.getSurname());
            st.setString(3, u.getTelephone());
            st.setString(4, u.getEmail());
            st.setString(5, u.getProfileDesc());
            return st.execute();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("delete from user where id=" + id);
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public User getById(int userId) {
        User result = new User();
        try (Connection c = connect()) {
            Statement st = c.createStatement();
            st.execute(" select " + " u.*, " + " n.nationality as nationality, " + "  c.name birthplace  " + " from " + " user u " + " left join country n on u.nationality_id = n.id " + " left join country c on u.birthplace_id = c.id where u.id=" + userId);
            ResultSet r = st.getResultSet();
            while (r.next()) {
                int id = r.getInt("id");
                String name = r.getString("name");
                String surname = r.getString("surname");
                String telephone = r.getString("telephone");
                Date birthdate = r.getDate("birthdate");
                String profileDesc = r.getString("profile_description");
                String email = r.getString("email");
                String address = r.getString("address");
                int nationality = r.getInt("nationality_id");
                int birthplace = r.getInt("birthplace_id");
                String n=r.getString("nationality");
                String b=r.getString("birthplace");
              Country birthplace_id=new Country(birthplace,b,null);
              Country nationality_id=new Country(nationality,null,n);

                result = new User(id, name, surname, email, telephone, profileDesc, address, birthdate,birthplace_id,nationality_id);
            }

        } catch (Exception e) {
        }
        return result;
    }
}

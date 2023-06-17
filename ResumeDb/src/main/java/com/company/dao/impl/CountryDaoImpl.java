package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    public Country getCountry(ResultSet r) throws Exception {
        int id = r.getInt("id");
        String name = r.getString("name");
        String nationality = r.getString("nationality");
        Country c = new Country(id, name, nationality);
        return c;
    }

    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement st = c.createStatement();
            st.execute("select * from country  ");
            ResultSet r = st.getResultSet();
            while (r.next()) {
                Country c1 = getCountry(r);
                result.add(c1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean updateCountry(Country ct) {
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("update country set id=?, name=?,nationality=?");
            p.setInt(1, ct.getId());
            p.setString(2, ct.getName());
            p.setString(3, ct.getNationality());
            return p.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addCountry(Country ct) {
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("insert into country (name,nationality)values(?,?)");
            p.setString(1, ct.getName());
            p.setString(2, ct.getNationality());
            return p.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeCountry(int id) {
        try (Connection c = connect()) {
            Statement s = c.createStatement();
            return s.execute("delete from country where id=" + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Country getById(int i) {

        Country c = new Country();
        try (Connection ct = connect()) {
            Statement s = ct.createStatement();
            s.execute("");
            ResultSet r = s.getResultSet();
            while (r.next()) {
                int id = r.getInt("id");
                String name = r.getString("name");
                String nationality = r.getString("nationality");
                c = new Country(id, name, nationality);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}

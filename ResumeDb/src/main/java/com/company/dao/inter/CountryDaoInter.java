package com.company.dao.inter;

import com.company.entity.Country;
import com.company.entity.User;

import java.util.List;

public interface CountryDaoInter {
    List<Country> getAll();
    public boolean updateCountry(Country c);
    public boolean addCountry(Country c);
    public boolean removeCountry(int id);
    public Country getById(int i);

}

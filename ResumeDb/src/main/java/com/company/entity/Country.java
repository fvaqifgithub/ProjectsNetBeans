package com.company.entity;

import java.util.Objects;

public class Country {
    private Integer id;
    private String name;
    private String nationality;

    public Country() {
    }
    public Country(Integer id){
        this.id=id;
    }
   


    public Country(Integer id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return name+"("+nationality+")";

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(name, country.name) && Objects.equals(nationality, country.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nationality);
    }
}

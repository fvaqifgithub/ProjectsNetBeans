package com.company.entity;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    private String profileDesc;
    private String address;
    private Date birthdate;
    private Country bithplace;
    private Country nationality;

    public User(int id, String name, String surname, String email, String telephone, String profileDesc, String address, Date birthdate, Country birthplace, Country nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.profileDesc = profileDesc;
        this.address = address;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.nationality=nationality;
    }

    public User(int id, String name, String surname, String telephone, String email, String profileDesc) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.profileDesc = profileDesc;
    }


    public User(int id, String name, String surname, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
    }

    public User() {

    }

    public User(int id) {
        this.id=id;
    }

    public User(int id, String name, String surname, String email, String telephone, String profileDesc, String address,Date birthdate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.profileDesc = profileDesc;
        this.address = address;
        this.birthdate = birthdate;
    }




    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Country getNationality() {
        return nationality;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    public void setNationality(Country nationality) {
        this.nationality=nationality;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }
 

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", profileDesc='" + profileDesc + '\'' +
                ", address='" + address + '\'' +
                ", birthdate=" + birthdate +
                ", country=" + birthplace +
                ", birthplace=" + nationality+
                '}';
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Country birthplace;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

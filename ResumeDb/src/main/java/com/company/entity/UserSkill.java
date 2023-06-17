package com.company.entity;

public class UserSkill {
    private Integer id;

    public UserSkill() {
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    private User user;
    private Skill skill;
    private  int power;
    

    public UserSkill(Integer id, User user, Skill skill, int power) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                ", user=" + user +
                ", skill=" + skill +
                ", power=" + power +
                '}';
    }

    public Skill getSkill(Skill skill){
        return skill;
    }
}

package com.company.entity;

public class Skill {

    public Skill() {
    }
    public Skill(String name){
     this.name=name;
    }
      public Skill(Integer id) {
          this.id=id;
    }
    @Override
    public String toString() {
        return   name ;
    }

    private Integer id;
    private String name;
    public Skill(Integer id,String name){
        this.id=id;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

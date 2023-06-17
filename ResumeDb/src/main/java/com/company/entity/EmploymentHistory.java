package com.company.entity;

import java.sql.Date;

public class EmploymentHistory {
    private Integer id;
    private String header;
    private String job_description;

    public EmploymentHistory() {
    }

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", job_description='" + job_description + '\'' +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                ", user=" + user +
                '}';
    }

    private Date begin_date;
    private Date end_date;
    private User user;

    public EmploymentHistory(Integer id, String header, String job_description, Date begin_date, Date end_date, User user) {
        this.id = id;
        this.header = header;
        this.job_description = job_description;
        this.begin_date = begin_date;
        this.end_date = end_date;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

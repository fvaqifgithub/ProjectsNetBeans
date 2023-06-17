package com.company.dao.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {

    List<EmploymentHistory> getAllEmploymentHistoryById(int id);

    boolean addHistory(EmploymentHistory h);

    EmploymentHistory getById(int Id);

    boolean removeHistory(int id);

    boolean updateHistory(EmploymentHistory history);

}

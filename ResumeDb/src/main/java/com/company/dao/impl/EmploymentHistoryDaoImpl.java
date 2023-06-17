package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {


    private EmploymentHistory getEmploymentHistory(ResultSet r) throws Exception {
        int id = r.getInt("id");
        String header = r.getString("header");
        Date begindate = r.getDate("begin_date");
        Date enddate = r.getDate("end_date");
        String jobDescription = r.getString("job_description");
        int userId = r.getInt("userId");
        EmploymentHistory emp = new EmploymentHistory(null, header, jobDescription, begindate, enddate, new User(id));
        return emp;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryById(int id) {
        List<EmploymentHistory> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement s = c.prepareStatement("select * from employment_history ");
            s.setInt(1, id);
            s.execute();
            ResultSet r = s.getResultSet();
            while (r.next()) {
                EmploymentHistory emp = getEmploymentHistory(r);
                result.add(emp);
            }
        } catch (Exception ex) {

        }
        return result;
    }

    @Override
    public boolean removeHistory(int id) {
        try (Connection c = connect()) {
            Statement st = c.createStatement();
            st.execute("delete from employment_history where id=" + id);
        } catch (Exception ex) {
        }
        return false;
    }

    @Override
    public EmploymentHistory getById(int Id) {
        EmploymentHistory e = new EmploymentHistory();
        try (Connection c = connect()) {
            Statement st = c.createStatement();
            st.execute("select * from employment_history  where user_id="+Id);
            ResultSet r = st.getResultSet();
            while (r.next()) {
                int id = r.getInt("id");
                String header = r.getString("header");
                Date begindate = r.getDate("begin_date");

                Date enddate = r.getDate("end_date");
                int userId = r.getInt("user_id");
                String jobDescription = r.getString("job_description");

                e = new EmploymentHistory(id, header, jobDescription, begindate, enddate, new User(userId));
            }
        } catch (Exception ex) {
        }
        return e;

    }
    @Override
      public boolean updateHistory(EmploymentHistory history) {
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("update employment_history set header=?,begin_date=?,end_date=?,job_description=?,user_id=? ");
            p.setString(1, history.getHeader());
            p.setDate(2, history.getBegin_date());
            p.setDate(3, history.getEnd_date());
            p.setString(4, history.getJob_description());
            p.setInt(5, history.getUser().getId());

            return p.execute();
        } catch (Exception e) {
        }
        return false;
      }
    /**
     *
     * @param h
     * @return
     */
    @Override
    public boolean addHistory(EmploymentHistory h) {
        try (Connection c = connect()) {
            PreparedStatement p = c.prepareStatement("insert into employment_history (header,begin_date,end_date,job_description,user_id)values(?,?,?,?,?)");
            p.setString(1, h.getHeader());
           p.setDate(2,h.getBegin_date());
            p.setDate(3, h.getEnd_date());
            p.setString(4, h.getJob_description());
            p.setInt(5, h.getUser().getId());
            return p.execute();
        } catch (Exception ex) {
        }
        return false;
    }
}

package com.company.main;


import com.company.dao.impl.UserDaoImpl;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import static java.lang.System.out;
import java.text.ParseException;
import java.util.List;

public class Main {
    
  
    public static void main(String[] args) throws ParseException {
 new Main().doPost();
}
    protected void doPost()
          {
    UserDaoInter userdao = new UserDaoImpl();

        List<User> user = userdao.getAll();

        
            for (User u : user) {
                out.println(user);
            }
          

    }
}

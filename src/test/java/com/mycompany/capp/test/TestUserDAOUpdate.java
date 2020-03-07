
package com.mycompany.capp.test;

import com.mycompany.springcontactapp.config.SpringRootConfig;
import com.mycompany.springcontactapp.dao.UserDAO;
import com.mycompany.springcontactapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUserDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userdao = context.getBean(UserDAO.class);
        //the user details will be taken from update user profile page
        User u = new User();
         u.setUserId(4);
        u.setName("Nili");
        u.setPhone("659hh9797");
        u.setEmail("N4@gmail.com");
        u.setAddress("kolkata");
        u.setLoginame("nil");
        u.setPassword("nil1");
        u.setRole(1);//admin
        u.setLoginStatus(1);//active
        userdao.update(u);
        System.out.println("--------Data updated---------");
    }
    
}

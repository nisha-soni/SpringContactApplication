
package com.mycompany.capp.test;

import com.mycompany.springcontactapp.config.SpringRootConfig;
import com.mycompany.springcontactapp.dao.UserDAO;
import com.mycompany.springcontactapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Nisha
 */
public class TestUserDAOFindSingleRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userdao = context.getBean(UserDAO.class);
       User u = userdao.findById(2);
       System.out.println(u);
        System.out.println("--------user details---------");
        System.out.println(u.getUserId());
        System.out.println(u.getName());
        System.out.println(u.getPhone());
        System.out.println(u.getAddress());
        System.out.println(u.getLoginame());
        System.out.println(u.getPassword());
        System.out.println(u.getRole());
        System.out.println(u.getLoginStatus());
        System.out.println(u.getEmail());
        
    }
    
}

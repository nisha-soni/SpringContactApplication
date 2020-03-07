
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
public class TestUserDAOSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userdao = context.getBean(UserDAO.class);
        //the user details will be taken from user-reg-page
        User u = new User();
        u.setName("NIL");
        u.setPhone("659689797");
        u.setEmail("N2@gmail.com");
        u.setAddress("MUMBAi");
        u.setLoginame("nil");
        u.setPassword("nil1");
        u.setRole(1);//admin
        u.setLoginStatus(1);//active
        userdao.save(u);
        System.out.println("--------Data SAved---------");
    }
    
}

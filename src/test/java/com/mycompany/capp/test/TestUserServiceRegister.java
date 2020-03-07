
package com.mycompany.capp.test;

import com.mycompany.springcontactapp.config.SpringRootConfig;
import com.mycompany.springcontactapp.domain.User;
import com.mycompany.springcontactapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Nisha
 */
public class TestUserServiceRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userservice = context.getBean(UserService.class);
        User u = new User();
        u.setName("nitin");
        u.setPhone("659689797");
        u.setEmail("Nitin@gmail.com");
        u.setAddress("MUMBAi");
        u.setLoginame("nitin");
        u.setPassword("nitin12323");
        u.setRole(UserService.ROLE_ADMIN);//admin
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);//active
        userservice.register(u);
        System.out.println("--------user registered successfully---------");
    }
    
}

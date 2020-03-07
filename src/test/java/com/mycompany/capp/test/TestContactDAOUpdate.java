
package com.mycompany.capp.test;

import com.mycompany.springcontactapp.config.SpringRootConfig;
import com.mycompany.springcontactapp.dao.ContactDAO;
import com.mycompany.springcontactapp.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestContactDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactdao = context.getBean(ContactDAO.class);
        //the user details will be taken from update user profile page
        Contact u = new Contact();
         u.setContactId(1);
        u.setName("Nilicpy");
        u.setPhone("65978797");
        u.setEmail("nilicpy@gmail.com");
        u.setAddress("kolkata");
        u.setRemark("20");
        contactdao.update(u);
        System.out.println("--------Data updated in contact---------");
    }
    
}

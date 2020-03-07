
package com.mycompany.capp.test;

import com.mycompany.springcontactapp.config.SpringRootConfig;
import com.mycompany.springcontactapp.dao.ContactDAO;
import com.mycompany.springcontactapp.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Nisha
 */
public class TestContactDAOSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactdao = context.getBean(ContactDAO.class);
        //the user details will be taken from user-reg-page
        Contact u = new Contact();
        u.setUserId(1);
        u.setName("nishacpy");
        u.setPhone("6373838393");
        u.setEmail("Nishacpy@gmail.com");
        u.setAddress("MUMBAI");
        u.setRemark("10");
        contactdao.save(u);
        System.out.println("--------Data SAved in contact---------");
    }
    
}

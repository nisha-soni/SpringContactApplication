
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
public class TestContactDAODelete2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactdao = context.getBean(ContactDAO.class);
        Contact u = new Contact();
         u.setContactId(1);
        contactdao.delete(u);
        System.out.println("--------Data deleted in contact---------");
    }
    
}

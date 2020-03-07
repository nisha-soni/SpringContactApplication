
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
public class TestContactDAOFindSingleRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactdao = context.getBean(ContactDAO.class);
       Contact u = contactdao.findById(1);
       System.out.println(u);
        System.out.println("--------contact details---------");
        System.out.println(u.getContactId());
        System.out.println(u.getUserId());
        System.out.println(u.getName());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println(u.getRemark());
        
    }
    
}

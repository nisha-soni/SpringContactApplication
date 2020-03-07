
package com.mycompany.capp.test;

import com.mycompany.springcontactapp.config.SpringRootConfig;
import com.mycompany.springcontactapp.dao.ContactDAO;
import com.mycompany.springcontactapp.domain.Contact;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Nisha
 */
public class TestContactDAOFindAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ContactDAO contactdao = context.getBean(ContactDAO.class);
        List<Contact> users = contactdao.findAll();
        for(Contact u : users){
           System.out.println(u.getUserId()+" "+u.getName()+" "+u.getAddress());
        }
                
    }
    
}

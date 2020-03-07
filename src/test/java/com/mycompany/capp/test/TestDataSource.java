
package com.mycompany.capp.test;

import com.mycompany.springcontactapp.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Nisha
 */
public class TestDataSource {

    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = context.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user(`name`, `phone`, `address`, `loginame`, `password`,`email`) VALUES(?,?,?,?,?,?)";
         Object[] param = new Object[]{"h","6786586587","Bangl","ni","ni","soni@gmail.com"};
         jt.update(sql,param);
         System.out.println("-------SQL Executed--------");
             
    }
    
}

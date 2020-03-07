
package com.mycompany.springcontactapp.config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author Nisha
 */
@Configuration
//@ComponentScan(basePackages={"com.mycompany"})
@ComponentScan(basePackages={"com.mycompany.springcontactapp.dao","com.mycompany.springcontactapp.service"})
public class SpringRootConfig {
    //services, dao, datasource,emailsender
    @Bean
    public BasicDataSource getdataSource(){
     BasicDataSource ds = new BasicDataSource();
     ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
     ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
     ds.setUsername("root");
     ds.setPassword("root");
     ds.setMaxTotal(2);
     ds.setInitialSize(1);
     ds.setTestOnBorrow(true);
     ds.setValidationQuery("SELECT 1");
     ds.setDefaultAutoCommit(true);
     return ds;
    }
    
}

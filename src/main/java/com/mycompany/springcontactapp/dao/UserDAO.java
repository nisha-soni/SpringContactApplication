
package com.mycompany.springcontactapp.dao;

import com.mycompany.springcontactapp.domain.User;
import java.util.List;

/**
 *
 * @author Nisha
 */
public interface UserDAO {
    public void save(User u);
    public void update(User u);
    public void delete(User u);
    public void delete(Integer userId);
    public User findById(Integer userId);
    public List<User> findAll();
    public List<User> findByProperty(String propName, Object propvalue);
}

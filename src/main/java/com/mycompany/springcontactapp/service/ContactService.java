package com.mycompany.springcontactapp.service;

import com.mycompany.springcontactapp.domain.Contact;
import java.util.List;

/**
 *the interface specifies all business operation for contact entity.
 * @author Nisha
 */
public interface ContactService {
    public void save(Contact c);
    public void update(Contact c);
    public void delete(Integer ContactId);
    public Contact findById(Integer ContactId);
    public void delete(Integer[] ContactIds);
    
    /**
     *this method returns all user contact(who is logged in )
     * @param userId
     * @return
     */
    public List<Contact> findUserConnect(Integer userId);
    /**
     *this method returns all user contact(who is logged in )
     * the method search contact for user(userId) based on given free-text-criteria(text)
     * @param userId
     *  @param txt
     * @return
     */
    public List<Contact> findUserConnect(Integer userId, String txt);
    
}

package com.mycompany.springcontactapp.service;

import com.mycompany.springcontactapp.domain.User;
import com.mycompany.springcontactapp.exception.UserBlockedException;
import java.util.List;

/**
 *
 * @author Nisha
 */
public interface UserService {
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;
    public void register(User u);
   //the method handle login operation(autentication)using given credentials, it returns user object when success and null when failed
   //when the user account is blocked we will get the exception
    public User login(String loginName, String password) throws UserBlockedException;
    public List<User> getUserList();
    public void changeLoginStatus(Integer userId, Integer loginStatus);
    public Boolean isUsernameExist(String username);
}

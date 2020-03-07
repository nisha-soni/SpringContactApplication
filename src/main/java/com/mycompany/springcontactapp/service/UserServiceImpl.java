package com.mycompany.springcontactapp.service;

import com.mycompany.springcontactapp.dao.BaseDAO;
import com.mycompany.springcontactapp.rm.UserRowMappper;
import com.mycompany.springcontactapp.dao.UserDAO;
import com.mycompany.springcontactapp.domain.User;
import com.mycompany.springcontactapp.exception.UserBlockedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nisha
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Override
    public void register(User u) {
     userDAO.save(u);
    }

    /*the method handles login operation using given credentials, it returns user object when success and 
    null when failed
    when the user is blocked the exception is thrown by the method*/
    @Override
    public User login(String loginName, String password) throws UserBlockedException {
     String sql = "SELECT *"
             +"FROM user WHERE loginame=:ln AND password=:pw";
     Map m = new HashMap();
     m.put("ln",loginName);
     m.put("pw",password);
     try{
     User u = getNamedParameterJdbcTemplate().queryForObject(sql,m,new UserRowMappper());
     if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)){
         throw new UserBlockedException("Your account has been blocked, contact to admin");
     } else{
         return u;
     }
     }catch(EmptyResultDataAccessException ex){
      return null;
     }
    }

    @Override
    public List<User> getUserList() {
    return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
     String sql="UPDATE user SET loginStatus=:lst WHERE userId=:uid";
     Map m = new HashMap();
     m.put("uid",userId);
     m.put("lst",loginStatus);
     getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public Boolean isUsernameExist(String username) {
     String sql = "SELECT count(loginame) FROM user WHERE loginame=?";
     Integer count = getJdbcTemplate().queryForObject(sql, new String[]{username} , Integer.class);
     if(count == 1){
       return true;
     }else{
       return false;
     }
    }
    
}


package com.mycompany.springcontactapp.dao;

import com.mycompany.springcontactapp.rm.UserRowMappper;
import com.mycompany.springcontactapp.domain.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nisha
 */
@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

    @Override
    public void save(User u) {
     String sql = "INSERT INTO user(`name`, `phone`, `address`, `loginame`, `password`, `role`,`email`)"
             +"VALUES(:name, :phone, :address, :loginame, :password, :role,:email)";
     Map m = new HashMap();
     m.put("name",u.getName());
     m.put("phone",u.getPhone());
     m.put("address",u.getAddress());
     m.put("loginame",u.getLoginame());
     m.put("password",u.getPassword());
     m.put("role",u.getRole());
     m.put("email",u.getEmail());
     
     KeyHolder kh = new GeneratedKeyHolder();
     SqlParameterSource ps = new MapSqlParameterSource(m);
     super.getNamedParameterJdbcTemplate().update(sql,ps,kh);
     Integer userId = kh.getKey().intValue();
     u.setUserId(userId);
    }

    @Override
    public void update(User u) {
        String sql = "UPDATE user SET"
                +" name=:name,"
                +" phone=:phone,"
                +" address=:address,"
                +" role=:role,"
                +" loginStatus=:loginStatus,"
                +" email=:email"
                +" WHERE userId=:userId";
         Map m = new HashMap();
        m.put("name",u.getName());
        m.put("phone",u.getPhone());
        m.put("address",u.getAddress());
        m.put("role",u.getRole());
         m.put("loginStatus",u.getLoginStatus());
        m.put("email",u.getEmail()); 
         m.put("userId", u.getUserId());
         getNamedParameterJdbcTemplate().update(sql,m);
        }

    @Override
    public void delete(User u) {
     this.delete(u.getUserId());
    }

    @Override
    public void delete(Integer userId) {
      String sql = "DELETE FROM user WHERE userId=?";
      getJdbcTemplate().update(sql,userId);
    }

    @Override
    public User findById(Integer userId) {
     String sql = "SELECT userId,name,phone,address,loginame,password,role,loginStatus,email"
             +" FROM user WHERE userId=?";
     User u = getJdbcTemplate().queryForObject(sql,new UserRowMappper(),userId);
     return u;
    }

    @Override
    public List<User> findAll() {
      String sql = "SELECT userId,name,phone,address,loginame,password,role,loginStatus,email"
             +" FROM user";
      List<User> users = getJdbcTemplate().query(sql,new UserRowMappper());
      return users;
      //return getJdbcTemplate().query(sql,new UserRowMappper());
    }

    @Override
    public List<User> findByProperty(String propName, Object propvalue) {
     String sql = "SELECT userId,name,phone,address,loginame,password,role,loginStatus,email"
             +" FROM user WHERE "+propName+"=?";
     return getJdbcTemplate().query(sql,new UserRowMappper(),propvalue);
    }
    
    
}

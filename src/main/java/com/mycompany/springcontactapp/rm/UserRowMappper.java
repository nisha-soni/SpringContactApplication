package com.mycompany.springcontactapp.rm;

import com.mycompany.springcontactapp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nisha
 */
public class UserRowMappper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User u = new User();
      u.setUserId(rs.getInt("userId"));
      u.setName(rs.getString("name"));
      u.setPhone(rs.getString("phone"));
      u.setEmail(rs.getString("email"));
      u.setAddress(rs.getString("address"));
      u.setLoginame(rs.getString("loginame"));
      u.setPassword(rs.getString("password"));
      u.setRole(rs.getInt("role"));
      u.setLoginStatus(rs.getInt("loginStatus"));
      return u;
    }
    
}

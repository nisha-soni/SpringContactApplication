
package com.mycompany.springcontactapp.rm;

import com.mycompany.springcontactapp.domain.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Nisha
 */
public class ContactRowMapper implements RowMapper<Contact>{

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
      Contact u = new Contact();
      u.setContactId(rs.getInt("contactId"));
      u.setUserId(rs.getInt("userId"));
      u.setName(rs.getString("name"));
      u.setEmail(rs.getString("email"));
      u.setAddress(rs.getString("address"));
      u.setPhone(rs.getString("phone"));
      u.setRemark(rs.getString("remark"));
      return u;
    }
    
}

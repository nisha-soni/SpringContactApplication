
package com.mycompany.springcontactapp.service;

import com.mycompany.springcontactapp.dao.BaseDAO;
import com.mycompany.springcontactapp.dao.ContactDAO;
import com.mycompany.springcontactapp.domain.Contact;
import com.mycompany.springcontactapp.rm.ContactRowMapper;
import com.mycompany.springcontactapp.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nisha
 */
@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{
    @Autowired
    private ContactDAO contactdao;
    @Override
    public void save(Contact c) {
     contactdao.save(c);
    }

    @Override
    public void update(Contact c) {
     contactdao.update(c);
    }

    @Override
    public void delete(Integer ContactId) {
     contactdao.delete(ContactId);
    }

    @Override
    public void delete(Integer[] ContactIds) {
        String Ids = StringUtil.toCommaSeperatedString(ContactIds);
      String sql = "DELETE FROM contact WHERE contactId IN("+Ids+")";
      getJdbcTemplate().update(sql);
    }

    @Override
    public List<Contact> findUserConnect(Integer userId) {
      return contactdao.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserConnect(Integer userId, String txt) {
      String sql="SELECT contactId,userId,name,phone,email,address,remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
      return getJdbcTemplate().query(sql,new ContactRowMapper(),userId);
    }

    @Override
    public Contact findById(Integer ContactId) {
     return contactdao.findById(ContactId);
    }
    
}

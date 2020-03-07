package com.mycompany.springcontactapp.controller;
import com.mycompany.springcontactapp.command.LoginCommand;
import com.mycompany.springcontactapp.command.UserCommand;
import com.mycompany.springcontactapp.domain.User;
import com.mycompany.springcontactapp.exception.UserBlockedException;
import com.mycompany.springcontactapp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Nisha
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userservice;
    
    @RequestMapping(value = {"/","/index1"})
    public String index(Model m){
      m.addAttribute("command",new LoginCommand());
     return "index1";
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd,Model m,HttpSession session){
        try {
            User loggedInUser = userservice.login(cmd.getLoginName(), cmd.getPassword());
            if(loggedInUser == null){
               m.addAttribute("err","Login failed enter valid credentials");
               return "index1";//login form
            }else{
               //success
               if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)){
                   addUserInSession(loggedInUser,session);
                  return "redirect:admin/dashboard";
               }
               else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
                   addUserInSession(loggedInUser,session);
                   return "redirect:user/dashboard";
               }else{
                 m.addAttribute("err","Invalid User Role");
                 return "index1";//login form
               }
            }
        } catch (UserBlockedException ex) {
           m.addAttribute("err",ex.getMessage());
           return "index1";//login form
        }
    }
    @RequestMapping(value = {"login/user/dashboard"})
    public String userDashboard(){
     return "dashboard_user";
    }
    @RequestMapping(value = {"login/admin/dashboard"})
    public String adminDashboard(){
     return "dashboard_admin";
    }
    
    @RequestMapping(value = {"/admin/users"})
    public String getUserList(Model m){
      m.addAttribute("userList",userservice.getUserList());
     return "users";
    }
    
    @RequestMapping(value = {"/logout"})
    public String logout(HttpSession session){
        session.invalidate();
     return "redirect:index1?act=lo";
    }
    
    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m){
        UserCommand cmd = new UserCommand();
        m.addAttribute("command", cmd);
      return "reg_form";
    }
    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m){
        try {
            User user = cmd.getUser();
            user.setRole(UserService.ROLE_USER);
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userservice.register(user);
            return "redirect:/index1?act=reg";
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            m.addAttribute("err","User name is already registered!");
            return "reg_form";
        }
    }
    private void addUserInSession(User u, HttpSession session){
     session.setAttribute("user", u);
     session.setAttribute("userId",u.getUserId());
     session.setAttribute("role",u.getRole());
    }
    
     @RequestMapping(value = "/admin/change_status")
     @ResponseBody
     public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus){
         try{
            userservice.changeLoginStatus(userId, loginStatus);
            return "SUCCESS:Status changed";
         }
         catch(Exception e){
             return "ERROR:unable to change status";
         }
    }
    
      @RequestMapping(value = "/check_avail")
     @ResponseBody
     public String checkAvailability(@RequestParam String username){
        if(userservice.isUsernameExist(username)){
         return "This user name is already taken!";
        }else{
         return "This user name is not taken by any user!";
        }
    }
}

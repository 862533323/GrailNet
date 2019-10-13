package cn.rfh.grailnet.controller;

import cn.rfh.grailnet.entity.User;
import cn.rfh.grailnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController extends BaseController{
    @Autowired
    UserService userService;

    @RequestMapping("/user/register")
    public String register(String account, String pwd, String email, String name, String phone){
        rebuildJSONObject();
        User user;
        user=userService.findUserByPhone(phone);
        if (user!=null){
            jsonObject.put(STATUS,STATUS_FALSE);
            jsonObject.put(MESSAGE,"注册失败");
        }else {
            user=new User();
            user.setAccount(account);
            user.setPwd(pwd);
            user.setEmail(email);
            user.setName(name);
            user.setPhone(phone);
            userService.saveUser(user);
            jsonObject.put(STATUS,STATUS_SUCCESS);
            jsonObject.put(MESSAGE,"注册成功");
        }
        return jsonObject.toString();
    }

    @RequestMapping("/user/login")
    public String login(HttpServletRequest request,String account, String pwd, boolean autoLogin){
        rebuildJSONObject();
        HttpSession session=request.getSession();
        User user=userService.login(account,pwd);
        session.setAttribute(USER_INF,user);
        if (user==null){
            jsonObject.put(MESSAGE,"false");
        }else {
            if (autoLogin){
                user.setAutoLogin(autoLogin);
                jsonObject.put(TOKEN,userService.getToken(user));
            }
            jsonObject.put(MESSAGE,MESSAGE_SUCCESS);
            jsonObject.put(USER,user);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/user/register/validateName")
    public String validateName(String name){
        rebuildJSONObject();
        User user=userService.findUserByName(name);
        if (user!=null){
            jsonObject.put(STATUS,STATUS_FALSE);
            jsonObject.put(MESSAGE,"name exist");
        }else {
            jsonObject.put(STATUS,STATUS_SUCCESS);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/user/logout")
    public void logout(HttpServletRequest request){
        rebuildJSONObject();
        HttpSession session=request.getSession();
        User user= (User) session.getAttribute(USER_INF);
        userService.logout(user);
        request.getSession().invalidate();
    }

    @RequestMapping("/user/info")
    public String getUserInfo(HttpServletRequest request){
        rebuildJSONObject();
        User user = (User) request.getSession().getAttribute(USER_INF);
        if (user!=null){
            jsonObject.put(USER,user);
        }
        return jsonObject.toString();
    }
}

package com.derellea.controller;

import com.derellea.domain.User;
import com.derellea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpServletRequest req){
        User u=userService.findByUsernameAndPassword(user);
        if(u==null){
            return "2";
        }else{
            req.getSession().setAttribute("user",u);
            return "1";
        }

    }

    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest req){
        req.getSession().removeAttribute("user");
        String contextPath = req.getContextPath();
        return "redirect:"+contextPath+"/index.jsp";
    }

    @RequestMapping("/info")
    @ResponseBody
    public User info(HttpServletRequest req){
        return ((User) req.getSession().getAttribute("user"));
    }
}

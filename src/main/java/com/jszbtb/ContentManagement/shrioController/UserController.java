package com.jszbtb.ContentManagement.shrioController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jszbtb.ContentManagement.pojo.Modle;
import com.jszbtb.ContentManagement.pojo.User;
import com.jszbtb.ContentManagement.shrioService.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	/*
	@Autowired
	private HttpServletRequest request;*/
	
	
	
	@RequestMapping("users")
	@ResponseBody
	public List<User> getUsers(){
		 List<User> userList = this.userService.getUser();
		 return userList;
	}
	
	@RequestMapping("login")
	public String login(User user){
		/*HttpSession session = request.getSession();*/
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(user.getName(),user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User myUser=(User) subject.getPrincipal();
           /* session.setAttribute("user", user);*/
            return "redirect:toPage/index?type=redirect";
        } catch(Exception e) {
            return "redirect:toPage/login?type=redirect";//返回登录页面
        }
		
	}
	
/*	@RequestMapping("getUserModel")
	@ResponseBody
	public List<Modle> getUserModel(){
		return this.userService.getUserModle();
	}*/
	
}

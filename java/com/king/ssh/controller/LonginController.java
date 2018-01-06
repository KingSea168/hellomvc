package com.king.ssh.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.king.common.Consts;
import com.king.ssh.entity.User;

@Controller
public class LonginController {
	
	@RequestMapping(value="${adminPath}")
	public String login(HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute(Consts.LOGIN_USER)!=null){
			return "modules/sys/frame";
		}
		
		return "modules/sys/login";
	}
	   
	@RequestMapping(value="${adminPath}/login")
	public String login(HttpServletRequest request,String username,String password) {
		if(Objects.equals(username, "admin") && Objects.equals(password, "123456")) {
			User loginUser =new User();
			loginUser.setUsername(username);
			loginUser.setPassword(password);
			HttpSession session =request.getSession();
			session.setAttribute(Consts.LOGIN_USER, loginUser);
			session.setAttribute("username", username);
		}
		
		return "redirect:http://localhost:8080/hellomvc/admin";
	}
	
	@RequestMapping(value="${adminPath}/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session =request.getSession();
		session.removeAttribute(Consts.LOGIN_USER);
		return "redirect:http://localhost:8080/hellomvc/admin";
	}
}

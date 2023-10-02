package com.employee.sb.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.sb.entity.Login;
import com.employee.sb.service.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;


@RestController
public class LoginController {
	
	@Autowired
	LoginService ls;
	
	@PostMapping("/login")
	public String validate(@RequestBody Login user) throws ServletException{
		String jwtToken = "";
		
		if(user.getUserName()== null ||user.getPassword() == null) {
			throw new ServletException("Please fill username & password");		
		}
		
		String userName = user.getUserName();
		String Password = user.getPassword();
		user = ls.loginUser(userName, Password);
		
		if(user == null) {
			throw new ServletException("user not found");
		}
		
jwtToken = Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
				
		return jwtToken;
	}

}

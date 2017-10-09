package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Display {

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/test",method=RequestMethod.GET, produces="application/json")
	public DisplayModel greet() {
		DisplayModel greeting= new DisplayModel();
		greeting.setGreeting("Manikandan");
		return greeting;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/login",method=RequestMethod.GET, produces="application/json")
	public Login loginValidate(
			@RequestParam("user") String userName,
			@RequestParam("pwd") String password
			) {
		Login login=new Login();
		
		if(userName.equals("manikandan") && password.equals("manikandan")){
			login.setStatus(true);
			return login;
		}
		else{
			login.setStatus(false);
			return login;
		}
		
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/currentDate",method=RequestMethod.GET, produces="application/json")
	public DisplayModel displayDate() {
		DisplayModel display=new DisplayModel();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		display.setCurrentTime(dtf.format(now));
		return display;
	}
}
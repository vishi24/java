package com.vishwa.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vishwa.rest.model.user;

@Service
public class userService {

	@Autowired
	private user user;
	
	public user formUser(user userinput) {
		user.setName("Setting from service "+ userinput.getName());
		user.setAge("Setting from service "+ userinput.getAge());
		
		return user;
	}
}

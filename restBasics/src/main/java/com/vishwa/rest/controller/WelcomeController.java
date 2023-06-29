package com.vishwa.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vishwa.rest.model.user;
import com.vishwa.rest.service.userService;

//https://github.com/RameshMF/springboot-blog-rest-api
//https://www.javaguides.net/2019/01/standard-project-structure-for-spring-boot-projects.html

//Here, initial endpoints responses are plain string, we will see how we can response back with JSON in endpoints
//containing "json" in their name

// model contains all POJO classes for resources exposed by the REST API's

// dao contains all repository classes which interacts with the DB - *In this we 
// don't have DB as their is no DB interaction

// service contains all the business logic

@RestController
@RequestMapping("/v1") // Request mapping can also be used on method as well
public class WelcomeController {

	private userService userService;

	public WelcomeController(userService userService) {
		this.userService = userService;
	}

//@GetMapping is a composed annotation that acts as a 
//shortcut for @RequestMapping(method = RequestMethod.GET).
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome bhai";
	}

//Here , if path variable is passed in the url, localhost/student/1
	@GetMapping("/welcome/{name}")
	public String welcomeParam(@PathVariable String name) {
		return "Welcome" + name + " bhai";
	}

//Here , if path variable is passed in the url, localhost/student/1
	@GetMapping("/welcome/{name}/{age}")
	public String welcomeParamMulti(@PathVariable String name, @PathVariable String age) {
		return "Welcome " + name + " bhai , your are " + age + " years old";
	}

//Here , if path variable is passed in the url, localhost/student/1
//If we different path variable and method parameter name
	@GetMapping("/welcomeyou/{fname}/{age}")
	public String welcomeParamDiff(@PathVariable("fname") String name, @PathVariable String age) {
		return "Welcome " + name + " bhai , your are " + age + " years old";
	}

//Here , Using the request param instead of path variable -> localhost/v1/welcome?name=Raj
	@GetMapping("/welcomereqparam")
//public String welcomeReq(@RequestParam String name) - if both are same
	public String welcomeReq(@RequestParam("name") String fname) {
		return "Welcome " + fname + " bhai";
	}

//HttpEntity can be used to create both RequestEntity and ResponseEntity.
//Where as ResponseEntity is subclassed from HttpEntity with a more elaborative
//way to send the ResponseObject and it only limited to sending the Response.

//@RequestBody , converts the input json to the object of mentioned type, we can use object also

	@GetMapping("/welcomejson")
	public ResponseEntity<user> welcomeJson(@RequestBody user userinput) {

		return ResponseEntity.ok(userService.formUser(userinput));
	}

	@PostMapping("/welcomejson")
	public ResponseEntity<user> welcomeJsonPost(@RequestBody user userinput) {
		userinput.setName("Using POST");
		return ResponseEntity.ok(userinput);
	}
}

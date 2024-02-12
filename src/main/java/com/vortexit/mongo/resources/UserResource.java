package com.vortexit.mongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vortexit.mongo.domain.User;
import com.vortexit.mongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
/*	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> findAll(){
		
		User maria = new User("1", "Maria Browm", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>(); //Sendo List uma interface, deve ser implementada pela ArrayList 
		list.addAll(Arrays.asList(maria, alex));
		return list;
	}
*/
// Outra forma de implementar
/*	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		User maria = new User("1", "Maria Browm", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>(); //Sendo List uma interface, deve ser implementada pela ArrayList 
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
*/
// Implementar acesso ao MongodB	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);	
	}
}

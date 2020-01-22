package com.nbb.pastryboutique.user;

import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://pastry-boutique-frontend.s3-website.us-east-2.amazonaws.com")


public class UserController {
 
   
    @Autowired
    private final UserRepository userRepository = null;
 
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
    	User user = new User("Not Found", "Not Found");
    	
    	for(User usr :userRepository.findAll()) {
			if(usr.getId()== id)
				return usr;
    	}
    	
    	return user;
    }
    
   // @CrossOrigin(origins = "http://pastry-boutique-frontend.s3-website.us-east-2.amazonaws.com")
    @GetMapping("/users")
    public List<User> getUsers() {    	
    	List<User> users = new ArrayList<User>();  	
    	
    	for(User user :userRepository.findAll()) {
			users.add(user);
    	}
    	
    	return users;        
    }
 
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUser){
    	User user = getUserById(id);
    	
    	user.setName(updateUser.getName());
    	user.setEmail(updateUser.getEmail());
    	
    	return new ResponseEntity<User>(user, HttpStatus.OK);
    	
    }
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
    	
    	 userRepository.deleteById(id);
    	
    	return ResponseEntity.noContent().build();
    }
}

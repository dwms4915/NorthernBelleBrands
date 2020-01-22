package com.nbb.pastryboutique.course;

import java.util.List;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class CourseController {
 
   
    @Autowired
    private final CourseRepository courseRepository = null;
 
    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id) {
    	Course user = new Course("Not Found", "Not Found");
    	
    	for(Course crs :courseRepository.findAll()) {
			if(crs.getId()== id)
				return crs;
    	}
    	
    	return user;
    }
    
    @GetMapping("/courses")
    public List<Course> getCourses() {    	
    	List<Course> courses = new ArrayList<Course>();  	
    	
    	for(Course course :courseRepository.findAll()) {
    		courses.add(course);
    	}
    	
    	return courses;        
    }
 
    @PostMapping("/courses")
    void addUser(@RequestBody Course course) {
    	courseRepository.save(course);
    }
}

package com.nbb.pastryboutique.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Course.class, idClass = Long.class)
public interface CourseRepository extends CrudRepository<Course, Long> {

}

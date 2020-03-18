package com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories;

import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface CourseRepository extends CrudRepository<Course,Integer> {

  @Query(value = "Select c from Course c where c.label = :coursename")
  public Course findByCourseName(@Param("coursename") String coursename);
}

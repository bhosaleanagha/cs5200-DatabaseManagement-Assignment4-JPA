package com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories;

import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Faculty;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends CrudRepository<Student,Integer> {

  @Query("Select s from Person s where s.firstName = :firstname")
  public Student findByfirstname(@Param("firstname") String firstname);

}

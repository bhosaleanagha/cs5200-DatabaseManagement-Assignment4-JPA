package com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories;

import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Person;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PersonRepository extends CrudRepository<Person,Integer> {

}

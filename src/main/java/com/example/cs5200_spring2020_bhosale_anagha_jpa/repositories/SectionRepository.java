package com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories;

import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Faculty;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Section;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface SectionRepository extends CrudRepository<Section,Integer> {

  @Query("Select s from Section s where s.title = :sectionName")
  public Section findBySectionName(@Param("sectionName") String sectionName);
}

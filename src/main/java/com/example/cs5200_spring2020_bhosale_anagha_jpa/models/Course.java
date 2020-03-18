package com.example.cs5200_spring2020_bhosale_anagha_jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {

  @Id
  @GeneratedValue
      (strategy = GenerationType.IDENTITY)

  private int id;

  private String label;

  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
  private List<Section> sections;

  @ManyToOne
  @JsonIgnore
  private Faculty author;

  public Course(){

  }

  public Course(int id, String label,Faculty author){
    this.id = id;
    this.label = label;
    this.author = author;
  }

  public void sectionOffered(Section section){
    this.getSections().add(section);
    if(section.getCourse()!=this){
      section.setCourse(this);
    }
  }
  public List<Section> getSections() {
    return sections;
  }

  public void setSections(
      List<Section> sections) {
    this.sections = sections;
  }

  public Faculty getAuthor() {
    return author;
  }

  public void setAuthor(Faculty author) {
    this.author = author;
    if(!author.getCourses().contains(this)){
      author.getCourses().add(this);
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}

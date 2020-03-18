package com.example.cs5200_spring2020_bhosale_anagha_jpa.models;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends Person{

  @Id
  @GeneratedValue
      (strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name ="office")
  private String office;

  @Column(name ="tenured")
  private boolean tenured;

  @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
  private List<Course> courses;

  public Faculty(){

  }

  public Faculty(int id,String firstname, String lastname, String username, String password,String office, boolean tenured,List<Course> course ){
    super(id,firstname,lastname,username,password);
    this.id = id;
    this.office = office;
    this.tenured = tenured;
    this.courses = course;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void authoredCourse(Course course){

    this.getCourses().add(course);
     if(course.getAuthor()!=this){
      course.setAuthor(this);
    }
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public boolean isTenured() {
    return tenured;
  }

  public void setTenured(boolean tenured) {
    this.tenured = tenured;
  }
}


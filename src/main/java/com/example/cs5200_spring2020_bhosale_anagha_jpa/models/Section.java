package com.example.cs5200_spring2020_bhosale_anagha_jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Section {

  @Id
  @GeneratedValue
      (strategy = GenerationType.IDENTITY)
  private int id;

  private int seats;
  private String title;

  @ManyToOne
  @JsonIgnore
  private Course course;

  @OneToMany(mappedBy = "section")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Enrollment> enrollments;

  public Section(){

  }

  public Section(int id, int seats,Course course){
    this.id = id;
    this.seats = seats;
    course = course;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
     if(!course.getSections().contains(course)){
       course.getSections().add(this);
    }
  }

  public List<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(
      List<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }

  public void enroll(Enrollment enrollment){
    this.getEnrollments().add(enrollment);
        if(enrollment.getSection() != this){
          enrollment.setSection(this);
        }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }
}


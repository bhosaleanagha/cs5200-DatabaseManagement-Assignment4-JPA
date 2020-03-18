package com.example.cs5200_spring2020_bhosale_anagha_jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollment")
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int grade;

  private String feedback;

  @ManyToOne
  private Student student;

  @ManyToOne
  private Section section;

  public Enrollment(){

  }

  public Enrollment(int id,int grade,String feedback,Student student,Section section){
    this.id = id;
    this.grade = grade;
    this.feedback = feedback;
    this.student = student;
    this.section = section;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
    if(!student.getEnrollments().contains(this)){
      student.getEnrollments().add(this);
    }
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
    if(!section.getEnrollments().contains(this)){
      section.getEnrollments().add(this);
    }
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }
}

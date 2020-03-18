package com.example.cs5200_spring2020_bhosale_anagha_jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Student extends Person {

  @Id
  @GeneratedValue
      (strategy = GenerationType.IDENTITY)
  private int id ;

  @Column(name = "gradYear")
  private int gradYear;

  @Column(name = "scholarship")
  private long scholarship;

  @OneToMany(mappedBy = "student")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Enrollment> enrollments;

  public Student(){

  }

  public Student(int id,String firstname,String lastname, String username, String password,int gradYear, long scholarship, List<Enrollment> enrollments){
    super(id,firstname,lastname,username,password);
    this.id= id;
    this.gradYear = gradYear;
    this.scholarship = scholarship;
    this.enrollments = enrollments;
  }

  public List<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void enroll(Enrollment enrollment){
    this.getEnrollments().add(enrollment);
    if(enrollment.getStudent() != this){
      enrollment.setStudent(this);
    }
  }

  public void setEnrollments(
      List<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getGradYear() {
    return gradYear;
  }

  public void setGradYear(int gradYear) {
    this.gradYear = gradYear;
  }

  public long getScholarship() {
    return scholarship;
  }

  public void setScholarship(long scholarship) {
    this.scholarship = scholarship;
  }


}


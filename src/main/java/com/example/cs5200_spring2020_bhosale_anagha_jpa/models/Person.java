package com.example.cs5200_spring2020_bhosale_anagha_jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {

  @Id
  @GeneratedValue
      (strategy = GenerationType.IDENTITY)
  private int id;

  private String username;
  private String password;
  private String firstName;
  private String lastName;

  public Person(){

  }

  public Person(int id, String username, String password, String firstName, String lastName){
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}


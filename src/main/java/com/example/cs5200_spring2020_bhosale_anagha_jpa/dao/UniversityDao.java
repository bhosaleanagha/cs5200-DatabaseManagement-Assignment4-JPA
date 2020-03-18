package com.example.cs5200_spring2020_bhosale_anagha_jpa.dao;

import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Course;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Faculty;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Person;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Section;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Student;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

public interface UniversityDao {

  public void truncateDatabase();

  public Faculty createFaculty(@RequestBody Faculty faculty);

  public Student createStudent(@RequestBody Student student);

  public Course createCourse(@RequestBody Course course);

  public Section createSection(@RequestBody Section section);

  Course addSectionToCourse(Section section, Course course);

 Course setAuthorForCourse(Faculty faculty, Course course);

  public Section setCourseForSection(Section section,Course course);

  public Faculty getFacultyByFirstname(String firstname);

  public Course getCourseByCourseName(String coursename);

  public Student getStudentByFirstName(String firstname);

  public Section getSectionByName(String sectionName);

 Boolean enrollStudentInSection(Student student, Section section);

  List<Person> findAllUsers();

  List<Faculty> findAllFaculty();

  List<Student> findAllStudents();

  List<Course> findAllCourses();

  List<Section> findAllSections();

  List<Course> findCoursesForAuthor(Faculty faculty);

  List<Section> findSectionForCourse(Course course);

  List<Student> findStudentsInSection(Section section);

  List<Section> findSectionsForStudent(Student student);
}

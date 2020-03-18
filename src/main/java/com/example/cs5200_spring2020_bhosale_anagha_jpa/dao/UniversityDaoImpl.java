package com.example.cs5200_spring2020_bhosale_anagha_jpa.dao;

import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Course;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Enrollment;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Faculty;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Person;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Section;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Student;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.CourseRepository;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.EnrollmentRepository;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.FacultyRepository;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.PersonRepository;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.SectionRepository;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UniversityDaoImpl implements UniversityDao {

  @Autowired
  EnrollmentRepository enrollmentRepository;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  FacultyRepository facultyRepository;

  @Autowired
  CourseRepository courseRepository;

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  SectionRepository sectionRepository;

  public UniversityDaoImpl() {
  }

  @Override
  public void truncateDatabase() {
    enrollmentRepository.deleteAll();
    sectionRepository.deleteAll();
    courseRepository.deleteAll();
    facultyRepository.deleteAll();
    studentRepository.deleteAll();
    personRepository.deleteAll();
  }

  @Override
  public Faculty createFaculty(Faculty faculty) {
    return facultyRepository.save(faculty);
  }

  @Override
  public Student createStudent(@RequestBody Student student) {

    return studentRepository.save(student);
  }

  @Override
  public Course createCourse(@RequestBody Course course) {

    return courseRepository.save(course);
  }

  @Override
  public Section createSection(@RequestBody Section section) {

    return sectionRepository.save(section);
  }

  @Override
  public Faculty getFacultyByFirstname(String firstName){
    return facultyRepository.findByfirstname(firstName);
  }

  @Override
  public Course getCourseByCourseName(String courseName){
    return courseRepository.findByCourseName(courseName);
  }

  @Override
  public Student getStudentByFirstName(String firstname){
    return studentRepository.findByfirstname(firstname);
  }

  @Override
  public Section getSectionByName(String sectionName){
    return sectionRepository.findBySectionName(sectionName);
  }

  @Override
  public Course addSectionToCourse(Section section, Course course){
    course.sectionOffered(section);
    sectionRepository.save(section);
    return  courseRepository.save(course);
  }

  @Override
  public Section setCourseForSection(Section section,Course course){
    section.setCourse(course);
    return sectionRepository.save(section);
  }

  @Override
  public Course setAuthorForCourse(Faculty faculty, Course course){
     course.setAuthor(faculty);
    return courseRepository.save(course);
  }

  @Override
 public Boolean enrollStudentInSection(Student student, Section section) {
    if(section.getSeats() - 1 >= 0){
      section.setSeats(section.getSeats() - 1);
      Enrollment enrollment = new Enrollment();
      enrollment.setSection(section);
      enrollment.setStudent(student);
      student.enroll(enrollment);
      section.enroll(enrollment);
      enrollmentRepository.save(enrollment);
      sectionRepository.save(section);
      return true;
    }
    return false;
  }

  @Override
  public List<Person> findAllUsers() {
    return (List<Person>)personRepository.findAll();
  }

  @Override
  public List<Faculty> findAllFaculty() {
    return (List<Faculty>) facultyRepository.findAll();
  }

  @Override
  public List<Student> findAllStudents() {
    return (List<Student>)studentRepository.findAll();
  }

  @Override
  public List<Course> findAllCourses() {
    return (List<Course>) courseRepository.findAll();
  }

  @Override
  public List<Section> findAllSections() {
    return (List<Section>) sectionRepository.findAll();
  }

  @Override
  public List<Course> findCoursesForAuthor(Faculty faculty) {
    List<Course> courses = faculty.getCourses();
    return courses;
  }

  @Override
  public List<Section> findSectionForCourse(Course course) {
    List<Section> section = course.getSections();
    return section;
  }

  @Override
  public List<Student> findStudentsInSection(Section section) {
    List<Enrollment> enrollments = section.getEnrollments();
    List<Student> student = new ArrayList<>();
    for(Enrollment e : enrollments){
      student.add(e.getStudent());
    }
    return student;
  }

  @Override
  public List<Section> findSectionsForStudent(Student student) {
    List<Enrollment> enrollments = student.getEnrollments();
    List<Section> section = new ArrayList<>();
    for(Enrollment e : enrollments){
      section.add(e.getSection());
    }
    return section;
  }


}

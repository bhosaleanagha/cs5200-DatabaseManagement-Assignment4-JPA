package com.example.cs5200_spring2020_bhosale_anagha_jpa;

import com.example.cs5200_spring2020_bhosale_anagha_jpa.dao.UniversityDao;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.dao.UniversityDaoImpl;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Course;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Faculty;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Person;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Section;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.models.Student;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.CourseRepository;
import com.example.cs5200_spring2020_bhosale_anagha_jpa.repositories.FacultyRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	UniversityDao dao = new UniversityDaoImpl();

	@Autowired
	FacultyRepository facultyRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createFaculties() {


		Faculty faculty1 = new Faculty();
		faculty1.setFirstName("Alan");
		faculty1.setLastName("Turin");
		faculty1.setOffice("123A");
		faculty1.setTenured(true);
		dao.createFaculty(faculty1);

		Faculty faculty2 = new Faculty();
		faculty2.setFirstName("Ada");
		faculty2.setLastName("Lovelace");
		faculty2.setOffice("123B");
		faculty2.setTenured(true);
		dao.createFaculty(faculty2);
	}

	@Test
	void createStudent(){
		Student student1 = new Student();
		student1.setFirstName("Alice");
		student1.setLastName("Wonderland");
		student1.setGradYear(2020);
		student1.setScholarship(12000);
		dao.createStudent(student1);

		Student student2 = new Student();
		student2.setFirstName("Bob");
		student2.setLastName("Hope");
		student2.setGradYear(2021);
		student2.setScholarship(23000);
		dao.createStudent(student2);

		Student student3 = new Student();
		student3.setFirstName("Charlie");
		student3.setLastName("Brown");
		student3.setGradYear(2019);
		student3.setScholarship(21000);
		dao.createStudent(student3);

		Student student4 = new Student();
		student4.setFirstName("Dan");
		student4.setLastName("Craig");
		student4.setGradYear(2019);
		student4.setScholarship(0);
		dao.createStudent(student4);

		Student student5 = new Student();
		student5.setFirstName("Edward");
		student5.setLastName("Scissorhands");
		student5.setGradYear(2022);
		student5.setScholarship(11000);
		dao.createStudent(student5);

		Student student6 = new Student();
		student6.setFirstName("Frank");
		student6.setLastName("Herbert");
		student6.setGradYear(2018);
		student6.setScholarship(0);
		dao.createStudent(student6);

		Student student7 = new Student();
		student7.setFirstName("Gregory");
		student7.setLastName("Peck");
		student7.setGradYear(2023);
		student7.setScholarship(10000);
		dao.createStudent(student7);
	}



	@Test
	public void createCourse(){

		Course course1 = new Course();
		course1.setLabel("CS1234");
		dao.createCourse(course1);
		Faculty faculty = dao.getFacultyByFirstname("Alan");
		dao.setAuthorForCourse(faculty,course1);

		Course course2 = new Course();
		course2.setLabel("CS2345");
		dao.createCourse(course2);
		Faculty faculty2 = dao.getFacultyByFirstname("Alan");
		dao.setAuthorForCourse(faculty2,course2);

		Course course3 = new Course();
		course3.setLabel("CS3456");
		dao.createCourse(course3);
		Faculty faculty3 = dao.getFacultyByFirstname("Ada");
		dao.setAuthorForCourse(faculty3,course3);

		Course course4 = new Course();
		course4.setLabel("CS4567");
		dao.createCourse(course4);
		Faculty faculty4 = dao.getFacultyByFirstname("Ada");
		dao.setAuthorForCourse(faculty4,course4);
	}


	@Test
	public void createSections(){
		Section section1 = new Section();
		section1.setSeats(50);
		section1.setTitle("SEC4321");
		dao.createSection(section1);
		Course course1 = dao.getCourseByCourseName("CS1234");
		dao.addSectionToCourse(section1,course1);


		Section section2 = new Section();
		section2.setSeats(50);
		section2.setTitle("SEC5432");
		dao.createSection(section2);
		Course course2 = dao.getCourseByCourseName("CS1234");
		dao.addSectionToCourse(section2,course2);


		Section section3 = new Section();
		section3.setSeats(50);
		section3.setTitle("SEC6543");
		dao.createSection(section3);
		Course course3 = dao.getCourseByCourseName("CS2345");
		dao.addSectionToCourse(section3,course3);

		Section section4 = new Section();
		section4.setSeats(50);
		section4.setTitle("SEC7654");
		dao.createSection(section4);
		Course course4 = dao.getCourseByCourseName("CS3456");
		dao.addSectionToCourse(section4,course4);

	}

	@Test
	public void enrollStudentInSection(){

		Student student1 = dao.getStudentByFirstName("Alice");
		Section section1 = dao.getSectionByName("SEC4321");
		dao.enrollStudentInSection(student1,section1);

		Student student2 = dao.getStudentByFirstName("Alice");
		Section section2 = dao.getSectionByName("SEC5432");
		dao.enrollStudentInSection(student2,section2);

		Student student3 = dao.getStudentByFirstName("Bob");
		Section section3 = dao.getSectionByName("SEC5432");
		dao.enrollStudentInSection(student3,section3);

		Student student4 = dao.getStudentByFirstName("Charlie");
		Section section4 = dao.getSectionByName("SEC6543");
		dao.enrollStudentInSection(student4,section4);
	}

	@Test
	public void truncateDatabase(){
		dao.truncateDatabase();
	}

	@Test
	public void findCoursesForFaculty(){
		Faculty f = dao.getFacultyByFirstname("Alan");
		List<Course> c = dao.findCoursesForAuthor(f);
		for(Course c1:c){
			System.out.println(c1.getLabel());
		}
	}

	@Test
	public void findSectionForCourse(){
		Course course1 = dao.getCourseByCourseName("CS1234");
		List<Section> section = dao.findSectionForCourse(course1);
		for(Section s :section){
			System.out.println(s.getTitle());
		}
	}

	@Test
	public void findStudentInSection(){
		Section section1 = dao.getSectionByName("SEC5432");
		List<Student> student = dao.findStudentsInSection(section1);
		for(Student s :student){
			System.out.println(s.getFirstName());
		}
	}

	@Test
	public void findSectionsForStudent(){
		Student student1 = dao.getStudentByFirstName("Alice");
		List<Section> section = dao.findSectionsForStudent(student1);
		for(Section s: section){
			System.out.println(s.getTitle());
		}
	}

	@Test
	public void ValidatingUsers(){
		List<Person> person = dao.findAllUsers();
		Assert.isTrue(person.size()==9,"Oops the current number of person is "+person.size());
	}

	@Test
	public void ValidatingFaculty(){
		List<Faculty> faculty = dao.findAllFaculty();
		Assert.isTrue(faculty.size()==2,"Oops the curent number of facties are "+faculty.size());
	}

	@Test
	public void ValidatingStudents(){
		List<Student> students = dao.findAllStudents();
		Assert.isTrue(students.size()==7,"Oops the current number of students is "+students.size());
	}

	@Test
	public void ValidatingCourses(){
		List<Course> course = dao.findAllCourses();
		Assert.isTrue(course.size()==4,"Oops the current number of course is "+course.size());
	}

	@Test
	public void ValidatingSection(){
		List<Section> section = dao.findAllSections();
		Assert.isTrue(section.size()==4,"Oops the current number of section is "+section.size());
	}

	@Test
	public void ValidatingCourseAuthorship(){
		Faculty f = dao.getFacultyByFirstname("Alan");
		List<Course> c = dao.findCoursesForAuthor(f);
		Assert.isTrue(c.size()==2,"Oops the total number of courses is "+c.size());
		 f = dao.getFacultyByFirstname("Ada");
		List<Course> c1 = dao.findCoursesForAuthor(f);
		Assert.isTrue(c.size()==2,"Oops the total number of courses is "+c1.size());
	}

	@Test
	public void ValidatingSectionPerCourse(){
		Course course1 = dao.getCourseByCourseName("CS1234");
		List<Section> section1 = dao.findSectionForCourse(course1);
		Assert.isTrue(section1.size()==2,"Oops the total number of section is "+section1.size());
		Course course2 = dao.getCourseByCourseName("CS2345");
		List<Section> section2 = dao.findSectionForCourse(course2);
		Assert.isTrue(section2.size()==1,"Oops the total number of section is "+section2.size());
		Course course3 = dao.getCourseByCourseName("CS3456");
		List<Section> section3 = dao.findSectionForCourse(course3);
		Assert.isTrue(section3.size()==1,"Oops the total number of section is "+section3.size());
		Course course4 = dao.getCourseByCourseName("CS4567");
		List<Section> section4 = dao.findSectionForCourse(course4);
		Assert.isTrue(section4.size()==0,"Oops the total number of section is "+section4.size());
	}

	@Test
	public void ValidatingSectionEnrollment(){
		Section section1 = dao.getSectionByName("SEC4321");
		List<Student> student1 = dao.findStudentsInSection(section1);
		Assert.isTrue(student1.size()==1,"Oops the total number of student enrolled is "+student1.size());

		Section section2 = dao.getSectionByName("SEC5432");
		List<Student> student2 = dao.findStudentsInSection(section2);
		Assert.isTrue(student2.size()==2,"Oops the total number of student enrolled is "+student2.size());

		Section section3 = dao.getSectionByName("SEC6543");
		List<Student> student3 = dao.findStudentsInSection(section3);
		Assert.isTrue(student3.size()==1,"Oops the total number of student enrolled is "+student3.size());

		Section section4 = dao.getSectionByName("SEC7654");
		List<Student> student4 = dao.findStudentsInSection(section4);
		Assert.isTrue(student4.size()==0,"Oops the total number of student enrolled is "+student4.size());
	}

	@Test
	public void ValidatingStudentEnrollment(){
		Student student1 = dao.getStudentByFirstName("Alice");
		List<Section> section1 = dao.findSectionsForStudent(student1);
		Assert.isTrue(section1.size()==2,"Oops the total number of student enrolled is "+section1.size());

		Student student2 = dao.getStudentByFirstName("Bob");
		List<Section> section2 = dao.findSectionsForStudent(student2);
		Assert.isTrue(section2.size()==1,"Oops the total number of student enrolled is "+section2.size());

		Student student3 = dao.getStudentByFirstName("Charlie");
		List<Section> section3 = dao.findSectionsForStudent(student3);
		Assert.isTrue(section3.size()==1,"Oops the total number of student enrolled is "+section3.size());

		Student student4 = dao.getStudentByFirstName("Dan");
		List<Section> section4 = dao.findSectionsForStudent(student4);
		Assert.isTrue(section4.size()==0,"Oops the total number of student enrolled is "+section4.size());

		Student student5 = dao.getStudentByFirstName("Edward");
		List<Section> section5 = dao.findSectionsForStudent(student5);
		Assert.isTrue(section5.size()==0,"Oops the total number of student enrolled is "+section5.size());

		Student student6 = dao.getStudentByFirstName("Frank");
		List<Section> section6 = dao.findSectionsForStudent(student6);
		Assert.isTrue(section6.size()==0,"Oops the total number of student enrolled is "+section6.size());

		Student student7 = dao.getStudentByFirstName("Gregory");
		List<Section> section7 = dao.findSectionsForStudent(student7);
		Assert.isTrue(section7.size()==0,"Oops the total number of student enrolled is "+section7.size());
	}

	@Test
	public void ValidatingSectionSeats(){
		Section section1 = dao.getSectionByName("SEC4321");
		Assert.isTrue(section1.getSeats()==49,"Oops the total number of seats are "+section1.getSeats());

		Section section2 = dao.getSectionByName("SEC5432");
		Assert.isTrue(section2.getSeats()==48,"Oops the total number of seats are "+section1.getSeats());

		Section section3 = dao.getSectionByName("SEC6543");
		Assert.isTrue(section3.getSeats()==49,"Oops the total number of seats are "+section1.getSeats());

		Section section4 = dao.getSectionByName("SEC7654");
		Assert.isTrue(section4.getSeats()==50,"Oops the total number of seats are "+section1.getSeats());
	}

	}

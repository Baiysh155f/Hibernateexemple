package org.example;

import org.example.entity.Course;
import org.example.entity.Student;
import org.example.repository.CourseRepository;
import org.example.repository.CourseRepositoryImpl;
import org.example.repository.StudentRepository;
import org.example.repository.StudentRepositoryImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StudentRepository studentRepository = new StudentRepositoryImpl();
        Student student = new Student("Adilet",32,"adi@gmail.com",LocalDate.of(2000,1,2));
        Student student1 = new Student("Alibek",32,"ali@gmail.com",LocalDate.of(2000,1,2));
        Student student2 = new Student("Altynbek",32,"altyn@gmail.com",LocalDate.of(2000,1,2));

//          System.out.println(studentRepository.saveStudents(student));
//          System.out.println(studentRepository.saveStudents(student1));
//          System.out.println(studentRepository.saveStudents(student2));
       // System.out.println(studentRepository.getAllStudent());
       // System.out.println(studentRepository.updateStudents(1L, student));
//        System.out.println(studentRepository.deleteStudentById(12L));

        CourseRepository courseRepository = new CourseRepositoryImpl();
        Course course = new Course("Java","Back-End",LocalDate.of(2021,2,2),LocalDate.of(2023,2,2));
        Course course2 = new Course("JS","Frond-End",LocalDate.of(2021,2,2),LocalDate.of(2023,2,2));
        Course course3 = new Course("payton","Back-End",LocalDate.of(2021,2,2),LocalDate.of(2023,2,2));

//        System.out.println(courseRepository.saveCourse(course3));
      //  System.out.println(courseRepository.findCourseById(1L));
      //  System.out.println(courseRepository.deleteCourse(3L));
      // studentRepository.assigningCourseToStudent(7L,7L);
  // studentRepository.assigningCourseToStudent(10L,11L);

        System.out.println(courseRepository.getCourseByStudentId(11L));
    }
}

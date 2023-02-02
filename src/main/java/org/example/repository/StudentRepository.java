package org.example.repository;

import org.example.entity.Student;

import java.util.List;

/**
 * @Baiysh155f. Hibernateexemple
 * 31.01.2023
 * admin
 * вт
 **/
public interface StudentRepository {
    String saveStudents(Student student);
    List<Student> getAllStudent();
    String updateStudents(Long id,Student student);
    String deleteStudentById(Long id);
    String assigningCourseToStudent(Long courseId,Long studentId);

}

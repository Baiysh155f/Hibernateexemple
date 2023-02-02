package org.example.repository;

import org.example.entity.Course;

import java.util.List;

/**
 * @Baiysh155f. Hibernateexemple
 * 31.01.2023
 * admin
 * вт
 **/
public interface CourseRepository {
    String saveCourse(Course course);
    Course findCourseById(Long id);

    String deleteCourse(Long Id);
    List<Course> getCourseByStudentId(Long courseId);
}

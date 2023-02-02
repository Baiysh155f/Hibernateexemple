package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.comfing.HibernateConnection;
import org.example.entity.Course;
import org.example.entity.Student;

import java.util.List;

/**
 * @Baiysh155f. Hibernateexemple
 * 31.01.2023
 * admin
 * вт
 **/
public class CourseRepositoryImpl implements CourseRepository {
    private final EntityManager entityManager = HibernateConnection.createEntityManagerFactory().createEntityManager();

    @Override
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getName() + " saved...";
    }

    @Override
    public Course findCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public String deleteCourse(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getName() + " deleted in database....";
    }

    @Override
    public List<Course> getCourseByStudentId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Course> id = entityManager.createQuery("select c from Student s join s.courses c where s.id = :id", Course.class)
                .setParameter("id", courseId).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id;
    }

}

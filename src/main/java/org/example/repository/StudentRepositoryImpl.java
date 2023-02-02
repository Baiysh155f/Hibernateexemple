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
public class StudentRepositoryImpl implements StudentRepository{
    private final EntityManager entityManager = HibernateConnection.createEntityManagerFactory().createEntityManager();
    @Override
    public String saveStudents(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student.getFullName()+" saved...";
    }

    @Override
    public List<Student> getAllStudent() {
        entityManager.getTransaction().begin();
        List<Student> selectSFromStudentS = entityManager.createQuery("select s from Student s", Student.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return selectSFromStudentS;
    }

    @Override
    public String updateStudents(Long id, Student student) {
        entityManager.getTransaction().begin();
        Student student1= entityManager.find(Student.class, id);
        student1.setFullName(student.getFullName());
        student1.setAge(student.getAge());
        student1.setEmail(student.getEmail());
        student1.setCreateAt(student.getCreateAt());
        entityManager.getTransaction().commit();
        entityManager.close();
        return student.getFullName()+" updated...";
    }

    @Override
    public String deleteStudentById(Long id) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
//        for (int i = 0; i < student.getCourses().size(); i++) {
//            student.getCourses().get(i).getStudents().remove(student);
//        }
        entityManager.remove(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student.getFullName()+" deleted in database...";
    }

    @Override
    public String assigningCourseToStudent(Long courseId, Long studentId) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, studentId);
        Course course = entityManager.find(Course.class, courseId);
        student.getCourses().add(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return student.getFullName()+" and "+course.getName()+" connected...";
    }


}

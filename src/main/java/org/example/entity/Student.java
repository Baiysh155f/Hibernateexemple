package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

/**
 * @Baiysh155f. Hibernateexemple
 * 31.01.2023
 * admin
 * вт
 **/
@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private int age;
    @Column(unique = true)
    private String email;
    @Column(name = "create_at")
    private LocalDate createAt;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Course> courses;

    public Student(String fullName, int age, String email, LocalDate createAt) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}

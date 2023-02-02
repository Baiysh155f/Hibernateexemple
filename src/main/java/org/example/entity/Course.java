package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

/**
 * @Baiysh155f. Hibernateexemple
 * 31.01.2023
 * admin
 * вт
 **/
@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;
    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;
    @ManyToMany(mappedBy = "courses",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Student> students;

    public Course(String name, String description, LocalDate dateOfStart, LocalDate dateOfFinish) {
        this.name = name;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfFinish=" + dateOfFinish +
                '}';
    }
}

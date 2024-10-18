package com.postgresql.learnhub.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;

import java.util.List;

@Entity
@Table(name="Students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String mailId;
    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JsonIgnoreProperties("students")
    @JoinTable(
            name="student_course",
            joinColumns = {
                    @JoinColumn(name="student_id")
            },
            inverseJoinColumns = {
                  @JoinColumn(name="course_id")
            }
    )
    private List<Courses> courses;
}
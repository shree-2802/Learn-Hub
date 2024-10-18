package com.postgresql.learnhub.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name="Courses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Courses {
    @Id
    @Column(name="course_id",nullable = false)
    private String courseId;
    @Column(name="course_name", nullable = false)
    private String courseName;
    private String video;
    @Column(name="course_image",nullable = false)
    private String courseImage;

    @ManyToMany(mappedBy = "courses")
    private List<Students> studentDetails;

    @OneToMany
    @JsonIgnoreProperties("courses")
    @JoinTable(
            name="course_page",
            joinColumns = {
                   @JoinColumn(
                           name="course_id"
                   )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="page_id"
                    )
            }
    )
    private List<Page> pages;
}

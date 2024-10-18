package com.postgresql.learnhub.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID pageId;
    @Column(nullable = false)
    private int pageNumber;
    @Column(nullable = false)
    private String title;
    private String video;
    private String images;
    private String courseId;

    @OneToMany
    private List<PageContent> pageContent;

    @ManyToOne
    private Courses course;
}

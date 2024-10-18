package com.postgresql.learnhub.model;

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
public class PageContent {
    private String subTitle;
    private String image;
    private String video;
    private String content;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID contentId;

    @ManyToOne
    
    private Page page;
}

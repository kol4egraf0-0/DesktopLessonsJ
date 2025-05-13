package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;

    private String title;
    private String description;
    private String difficulty;

    @ManyToOne
    @JoinColumn
    private Category category;
}

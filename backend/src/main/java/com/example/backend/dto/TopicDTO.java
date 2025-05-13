package com.example.backend.dto;

import com.example.backend.model.Topic;
import lombok.Data;

@Data
public class TopicDTO {
    private Long topicId;
    private String title;
    private String description;
    private String difficulty;
    private Long categoryId;

    public TopicDTO(Topic topic) {
        this.topicId = topic.getTopicId();
        this.title = topic.getTitle();
        this.description = topic.getDescription();
        this.difficulty = topic.getDifficulty();
        this.categoryId = topic.getCategory().getId();
    }
}

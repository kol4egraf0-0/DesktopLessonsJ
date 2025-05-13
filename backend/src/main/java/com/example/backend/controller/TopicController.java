package com.example.backend.controller;

import com.example.backend.dto.TopicDTO;
import com.example.backend.model.Topic;
import com.example.backend.service.TopicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@CrossOrigin("*") //пусть будет пока
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/all")
    public List<TopicDTO> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/category/{categoryId}")
    public List<TopicDTO> getTopicsByCategory(@PathVariable Long categoryId) {
        return topicService.getTopicByCategory(categoryId);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDTO>> searchTopics(
            @RequestParam(name = "search", required = false) String searchText,
            Pageable pageable){
        Page<TopicDTO> topics = topicService.searchTopics(searchText, pageable);
        return ResponseEntity.ok(topics);
    }
}

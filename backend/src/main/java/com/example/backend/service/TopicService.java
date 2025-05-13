package com.example.backend.service;

import com.example.backend.dto.TopicDTO;
import com.example.backend.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private TopicRepository topicRepository;


    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<TopicDTO> getAllTopics() {
        return topicRepository.findAll()
                .stream()
                .map(TopicDTO::new)
                .toList();
    }

    public List<TopicDTO> getTopicByCategory(Long categoryId) {
        return topicRepository.findByCategoryId(categoryId)
                .stream()
                .map(TopicDTO::new)
                .toList();
    }
}

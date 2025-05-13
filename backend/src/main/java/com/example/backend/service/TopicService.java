package com.example.backend.service;

import com.example.backend.dto.TopicDTO;
import com.example.backend.model.Topic;
import com.example.backend.repository.TopicRepository;
import com.example.backend.specification.TopicSpecifications;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    public Page<TopicDTO> searchTopics(String searchText, Pageable pageable) {
        Specification<Topic> spec = TopicSpecifications.containsTextInTitleOrDescription(searchText);
        Page<Topic> articles = topicRepository.findAll(spec, pageable);
        return articles.map(TopicDTO::new);
    }

}

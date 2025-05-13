package com.example.backend.specification;

import com.example.backend.model.Topic;
import org.springframework.data.jpa.domain.Specification;

public class TopicSpecifications { //util
    public static Specification<Topic> containsTextInTitleOrDescription(String text) {
        return (root, query, cb) -> { //cb - кртериябилдер
            if (text == null || text.isEmpty()) {
                return cb.conjunction();
            }

            String likePattern = "%" + text.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("title")), likePattern), //
                    cb.like(cb.lower(root.get("description")), likePattern)
            );
        };
    }
}

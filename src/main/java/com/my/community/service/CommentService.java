// src/main/java/com/my/community/service/CommentService.java
package com.my.community.service;

import com.my.community.domain.Comment;
import com.my.community.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentMapper mapper;

    public CommentService(CommentMapper mapper) {
        this.mapper = mapper;
    }

    public List<Comment> listByPost(Long communityId) {
        return mapper.selectByCommunityId(communityId);
    }

    public Comment create(Comment c) {
        mapper.insert(c);
        return c;
    }

    public void update(Long commentId, String content) {
        mapper.update(commentId, content);
    }

    public void delete(Long commentId) {
        mapper.softDelete(commentId);
    }
}

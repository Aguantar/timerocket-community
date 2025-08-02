// src/main/java/com/my/community/controller/CommentController.java
package com.my.community.controller;

import com.my.community.domain.Comment;
import com.my.community.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CommentController {
    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    // 댓글 목록
    @GetMapping("/api/communities/{postId}/comments")
    public List<Comment> list(@PathVariable Long postId) {
        return service.listByPost(postId);
    }

    // 댓글 작성
    @PostMapping("/api/communities/{postId}/comments")
    public ResponseEntity<Comment> create(
            @PathVariable Long postId,
            @RequestBody Comment c
    ) {
        c.setCommunityId(postId);
        Comment created = service.create(c);
        return ResponseEntity
                .created(URI.create("/api/comments/" + created.getCommentId()))
                .body(created);
    }

    // 댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public ResponseEntity<Void> update(
            @PathVariable Long commentId,
            @RequestBody Comment c
    ) {
        service.update(commentId, c.getContent());
        return ResponseEntity.noContent().build();
    }

    // 댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable Long commentId) {
        service.delete(commentId);
        return ResponseEntity.noContent().build();
    }
}

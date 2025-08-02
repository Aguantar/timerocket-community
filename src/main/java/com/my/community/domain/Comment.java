package com.my.community.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Comment {
    private Long commentId;
    private Long communityId;
    private Long userId;
    private String content;
    private Long parentCommentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
package com.my.communitybackend.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Community {
    private Long   communityId;
    private Long   userId;
    private Long   themeId;
    private String title;
    private String content;
    private Integer viewCount;
    private Integer likeCount;
    private Integer saveCount;
    private Integer attachmentCount;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

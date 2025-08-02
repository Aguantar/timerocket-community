package com.my.community.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommunityLike {
    private Long likeId;
    private Long communityId;
    private Long userId;
    private LocalDateTime createdAt;
}
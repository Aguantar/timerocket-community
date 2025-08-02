package com.my.community.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommunitySave {
    private Long saveId;
    private Long communityId;
    private Long userId;
    private LocalDateTime createdAt;
}
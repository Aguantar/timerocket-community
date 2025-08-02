package com.my.community.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommunityFile {
    private Long fileId;
    private Long communityId;
    private String originalName;
    private String uniqueName;
    private String savedPath;
    private String fileType;
    private Long fileSize;
    private Integer fileOrder;
    private LocalDateTime createdAt;
}
// src/main/java/com/my/community/service/CommunityService.java
package com.my.community.service;

import com.my.community.domain.Community;
import com.my.community.mapper.CommunityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommunityService {
    private final CommunityMapper mapper;

    public CommunityService(CommunityMapper mapper) {
        this.mapper = mapper;
    }

    /** 1. 무한 스크롤용 목록 조회 (offset, limit, themeId) */
    public List<Community> getFeedByOffset(int offset, int limit, int themeId) {
        return mapper.selectPage(offset, limit, themeId);
    }

    /** 2. 단일 게시글 조회 + 조회수 1 증가 */
    @Transactional
    public Community getById(Long communityId) {
        mapper.incrementViewCount(communityId);
        return mapper.selectById(communityId);
    }

    /** 3. 게시글 생성 */
    public Community create(Community community) {
        mapper.insert(community);
        return community;
    }

    /** 4. 게시글 수정 */
    public void update(Community community) {
        mapper.update(community);
    }

    /** 5. 게시글 소프트 삭제 */
    public void delete(Long communityId) {
        mapper.softDelete(communityId);
    }

    /** 6. 검색 + 페이징 */
    public List<Community> searchFeed(int offset, int limit, int themeId, String q) {
        // communityMapper 가 아니라 mapper 필드를 사용합니다
        return mapper.selectPageWithSearch(offset, limit, themeId, q);
    }
}

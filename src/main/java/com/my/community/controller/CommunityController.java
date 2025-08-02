// src/main/java/com/my/community/controller/CommunityController.java
package com.my.community.controller;

import com.my.community.domain.Community;
import com.my.community.service.CommunityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    private final CommunityService service;

    public CommunityController(CommunityService service) {
        this.service = service;
    }

    /** CREATE: 새 게시글 쓰기 */
    @PostMapping
    public Community create(@RequestBody Community c) {
        return service.create(c);
    }

    /**
     * READ ALL: 무한 스크롤 + 검색용
     * - offset, limit, themeId: 기본 페이징
     * - q: 검색어 (null 또는 빈 문자열일 땐 기본 페이징)
     */
    @GetMapping
    public List<Community> list(
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int themeId,        // 0이면 전체
            @RequestParam(name="q", required=false) String q
    ) {
        if (q != null && !q.trim().isEmpty()) {
            return service.searchFeed(offset, limit, themeId, q.trim());
        }
        return service.getFeedByOffset(offset, limit, themeId);
    }

    /** READ ONE: 상세 조회 (조회수 증가 포함) */
    @GetMapping("/{id}")
    public Community getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    /** UPDATE: 게시글 수정 */
    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody Community c
    ) {
        c.setCommunityId(id);
        service.update(c);
    }

    /** DELETE: 게시글 소프트 삭제 */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

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

    public List<Community> getFeed(int page, int size, Long themeId) {
        int offset = (page - 1) * size;
        return mapper.selectPage(offset, size, themeId);
    }

    public Community getOne(Long id) {
        return mapper.selectById(id);
    }

    @Transactional
    public void create(Community community) {
        mapper.insert(community);
    }

    @Transactional
    public void update(Community community) {
        mapper.update(community);
    }

    @Transactional
    public void delete(Long id) {
        mapper.softDelete(id);
    }

    @Transactional
    public void restore(Long id) {
        mapper.restore(id);
    }
}
// src/main/java/com/my/community/mapper/CommunityMapper.java
package com.my.community.mapper;

import com.my.community.domain.Community;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityMapper {
    Community selectById(@Param("communityId") Long communityId);

    // 1) 기존 무한 스크롤 전용 (3개 인자)
    List<Community> selectPage(
            @Param("offset")  int offset,
            @Param("limit")   int limit,
            @Param("themeId") int themeId
    );

    // 2) 검색 + 페이징 전용 (4개 인자)
    List<Community> selectPageWithSearch(
            @Param("offset")  int offset,
            @Param("limit")   int limit,
            @Param("themeId") int themeId,
            @Param("q")       String q
    );

    int insert(Community community);  // community.communityId에 자동 채번

    int update(Community community);

    int softDelete(@Param("communityId") Long communityId);
    int incrementViewCount(@Param("communityId") Long communityId);
}

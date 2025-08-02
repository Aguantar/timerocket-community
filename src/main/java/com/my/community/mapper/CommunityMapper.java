package com.my.community.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.my.community.domain.Community;
import java.util.List;

@Mapper
public interface CommunityMapper {
    Community selectById(@Param("communityId") Long id);
    List<Community> selectPage(
            @Param("offset") int offset,
            @Param("limit") int limit,
            @Param("themeId") Long themeId
    );
    void insert(Community community);
    void update(Community community);
    void softDelete(@Param("communityId") Long id);
    void restore(@Param("communityId") Long id);
}
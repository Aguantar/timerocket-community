// src/main/java/com/my/community/mapper/CommentMapper.java
package com.my.community.mapper;

import com.my.community.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 1) 댓글 리스트 (최상위 포함, parentCommentId null)
    List<Comment> selectByCommunityId(@Param("communityId") Long communityId);

    // 2) 삽입
    int insert(Comment c);

    // 3) 수정
    int update(@Param("commentId") Long commentId,
               @Param("content") String content);

    // 4) 소프트 삭제
    int softDelete(@Param("commentId") Long commentId);
}

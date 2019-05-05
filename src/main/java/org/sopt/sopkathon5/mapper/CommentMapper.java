package org.sopt.sopkathon5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.sopkathon5.model.entity.Comment;

@Mapper
public interface CommentMapper {

	@Select("SELECT * FROM comment WHERE contentIdx = #{contentIdx}")
	List<Comment> findAllComment(@Param("contentIdx") final int contentIdx);

	@Insert("INSERT INTO content(contentIdx, userIdx, content, createdAt) VALUES(#{comment.contentIdx}, #{comment.userIdx}, #{comment.content}, #{comment.createdAt})")
	void comment(@Param("comment") final Comment comment);
}

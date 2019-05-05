package org.sopt.sopkathon5.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.sopt.sopkathon5.model.entity.Content;
import org.sopt.sopkathon5.model.entity.Keyword;

@Mapper
public interface ContentMapper {
	@Select("SELECT * FROM keyword")
	List<Keyword> findAllKeyword();

	@Select("SELECT * FROM content WHERE keywordIdx = #{keywordIdx}")
	List<Content> findAllContent(@Param("keywordIdx") final int keywordIdx);

	@Select("SELECT * FROM content WHERE contentIdx = #{contentIdx}")
	Content findContent (@Param("contentIdx") final int contentIdx);

	@Insert("INSERT INTO content(keywordIdx, userIdx, createdAt, name, content, heartCount, commentCount) VALUES(#{content.keywordIdx}, #{content.userIdx}, #{content.createdAt}, #{content.name}, #{content.content}, #{content.heartCount}, #{content.commentCount})")
	void addContent (@Param("content") Content content);

	@Update("UPDATE content SET heartCount = #{heartCount} WHERE contentIdx = #{contentIdx}")
	void addHeart (@Param("heartCount") final int heartCount, @Param("contentIdx") final int contentIdx);

	@Select("SELECT heartCount FROM content WHERE contentIdx = #{contentIdx}")
	int findHeart (@Param("contentIdx") final int contentIdx);
}

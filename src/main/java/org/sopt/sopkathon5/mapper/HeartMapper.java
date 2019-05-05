package org.sopt.sopkathon5.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HeartMapper {

	@Insert("INSERT INTO heart(userIdx, contentIdx) VALUES(#{userIdx}, #{contentIdx})")
	void add(@Param("userIdx") final int userIdx, @Param("contentIdx") final int contentIdx);
}

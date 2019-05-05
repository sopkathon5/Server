package org.sopt.sopkathon5.mapper;

import org.apache.ibatis.annotations.*;
import org.sopt.sopkathon5.model.entity.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE email = #{email} AND password = #{password}")
	User findUserByEmailAndPassword(@Param("email") final String email, @Param("password") final String password);

	@Insert("INSERT INTO user(email, password, nickname, sex, point) VALUES(#{user.email}, #{user.password}, #{user.nickname}, #{user.sex}, #{user.point})")
	void save(@Param("user") final User user);

	@Select("SELECT point FROM user WHERE userIdx = #{userIdx}")
	int point(@Param("userIdx") final int userIdx);

	@Update("UPDATE user SET point = #{point} WHERE userIdx = #{userIdx}")
	void addpoint(@Param("userIdx") final int userIdx, @Param("point") final int point);
}

package org.sopt.sopkathon5.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.sopkathon5.model.entity.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE email = #{email} AND password = #{password}")
	Optional<User> findUserByEmailAndPassword(@Param("email") final String email, @Param("password") final String password);

	@Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
	Optional<User> findUserByUserIdx(@Param("userIdx") final int userIdx);

	@Select("SELECT * FROM user WHERE email = #{email}")
	Optional<User> findUserByEmail(@Param("email") final String email);

	@Insert("INSERT INTO user(email, password, nickname, birth, sex) VALUES(#{user.email}, #{user.password}, #{user.nickname}, #{user.birth}, #{user.sex})")
	User save(@Param("user") final User user);
}

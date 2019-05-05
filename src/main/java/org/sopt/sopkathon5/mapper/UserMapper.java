package org.sopt.sopkathon5.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sopt.sopkathon5.model.entity.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM user WHERE email = #{email} AND password = #{password}")
	Optional<User> findUserByUserIdAndUserPw(@Param("email") final String email, @Param("password") final String password);
}

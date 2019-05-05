package org.sopt.sopkathon5.service;

import java.util.Optional;

import org.sopt.sopkathon5.mapper.UserMapper;
import org.sopt.sopkathon5.model.entity.User;
import org.sopt.sopkathon5.model.request.LoginReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.utils.ResponseMessage;
import org.sopt.sopkathon5.utils.StatusCode;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

	private final UserMapper userMapper;
	private final JwtService jwtService;

	public AuthService(UserMapper userMapper, JwtService jwtService) {
		this.userMapper = userMapper;
		this.jwtService = jwtService;
	}

	public DefaultRes<JwtService.TokenRes> login(final LoginReq loginReq) {
		final Optional<User> user = userMapper.findUserByEmailAndPassword(loginReq.getEmail(), loginReq.getPassword());
		if (user.isPresent()) {
			//토큰 생성
			final JwtService.TokenRes tokenDto = new JwtService.TokenRes(jwtService.create(user.get().getUserIdx()));
			return DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, tokenDto);
		}

		return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.LOGIN_FAIL);
	}
}

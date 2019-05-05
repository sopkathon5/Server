package org.sopt.sopkathon5.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.mapper.UserMapper;
import org.sopt.sopkathon5.model.entity.User;
import org.sopt.sopkathon5.model.request.JoinReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.model.response.UserRes;
import org.sopt.sopkathon5.service.JwtService;
import org.sopt.sopkathon5.service.UserService;
import org.sopt.sopkathon5.utils.ResponseMessage;
import org.sopt.sopkathon5.utils.StatusCode;
import org.sopt.sopkathon5.utils.security.PasswordUtil;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final JwtService jwtService;

	public UserServiceImpl(JwtService jwtService, UserMapper userMapper) {
		this.jwtService = jwtService;
		this.userMapper = userMapper;
	}

	@Override
	public DefaultRes join(final JoinReq joinReq) {
		try {
			Optional<User> temp = userMapper.findUserByEmail(joinReq.getEmail());

			if (temp.isPresent()) {
				return DefaultRes.res(StatusCode.BAD_REQUEST, ResponseMessage.DUPLICATED_ID);
			}

			PasswordUtil util = new PasswordUtil();
			joinReq.setPassword(util.encryptSHA256(joinReq.getPassword()));

			User user = userMapper.save(new User(joinReq));
			UserRes userRes = new UserRes(user);
			final JwtService.TokenRes tokenRes = new JwtService.TokenRes(jwtService.create((user.getUserIdx())));

			Map<String, Object> result = new HashMap<>();
			result.put("token", tokenRes.getToken());
			result.put("user", userRes);

			return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER, result);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}


}

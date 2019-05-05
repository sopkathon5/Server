package org.sopt.sopkathon5.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.mapper.UserMapper;
import org.sopt.sopkathon5.model.entity.User;
import org.sopt.sopkathon5.model.request.JoinReq;
import org.sopt.sopkathon5.model.request.LoginReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.model.response.UserRes;
import org.sopt.sopkathon5.service.UserService;
import org.sopt.sopkathon5.utils.ResponseMessage;
import org.sopt.sopkathon5.utils.StatusCode;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public DefaultRes join(final JoinReq joinReq) {
		try {

			userMapper.save(new User(joinReq));
//			UserRes userRes = new UserRes(user);


//			Map<String, Object> result = new HashMap<>();
//			result.put("user", userRes);

			return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}

	@Override
	public DefaultRes login(final LoginReq loginReq){
		try {

			User loginUser = new User(loginReq);

			final User user = userMapper.findUserByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
			if (user == null)
				return DefaultRes.res(StatusCode.UNAUTHORIZED, ResponseMessage.LOGIN_FAIL);

//			Map<String, Object> result = new HashMap<>();

//			result.put("user", new UserRes(user.get()));

			return DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS);
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}


}

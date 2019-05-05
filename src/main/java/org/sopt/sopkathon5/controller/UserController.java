package org.sopt.sopkathon5.controller;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.model.entity.User;
import org.sopt.sopkathon5.model.request.JoinReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.service.JwtService;
import org.sopt.sopkathon5.service.UserService;
import org.sopt.sopkathon5.service.impl.UserServiceImpl;
import org.sopt.sopkathon5.utils.ResponseMessage;
import org.sopt.sopkathon5.utils.StatusCode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.sopt.sopkathon5.model.response.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	private static final DefaultRes<User> UNAUTHORIZED_RES = new DefaultRes(StatusCode.INTERNAL_SERVER_ERROR, ResponseMessage.INTERNAL_SERVER_ERROR);

	private final UserService userService;
	private final JwtService jwtService;

	public UserController(final UserService userService, final JwtService jwtService) {
		this.userService = userService;
		this.jwtService = jwtService;
	}

	@PostMapping("/join")
	public ResponseEntity<DefaultRes> join(@RequestBody final JoinReq joinReq) {
		try {
			return new ResponseEntity<>(userService.join(joinReq), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

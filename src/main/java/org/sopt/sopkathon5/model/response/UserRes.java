package org.sopt.sopkathon5.model.response;

import java.time.LocalDateTime;

import org.sopt.sopkathon5.model.entity.User;

public class UserRes {
	private int userIdx;
	private String email;
	private String password;
	private String nickname;
	private LocalDateTime birth;
	private int sex;
	private int point;

	public UserRes(User user) {
		this.userIdx = user.getUserIdx();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.nickname = user.getNickname();
		this.birth = user.getBirth();
		this.sex = user.getSex();
		this.point = 0;
	}
}

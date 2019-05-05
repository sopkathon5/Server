package org.sopt.sopkathon5.model.entity;

import lombok.*;
import org.sopt.sopkathon5.model.request.JoinReq;
import org.sopt.sopkathon5.model.request.LoginReq;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	private int userIdx;
	private String email;
	private String password;
	private String nickname;
	private int sex;
	private int point;

	@Builder
	public User(JoinReq joinReq) {
		this.email = joinReq.getEmail();
		this.password = joinReq.getPassword();
		this.nickname = joinReq.getNickname();
		this.sex = joinReq.getSex();
		this.point = joinReq.getPoint();
	}

	public User(LoginReq loginReq) {
		this.email = loginReq.getEmail();
		this.password = loginReq.getPassword();
	}
}

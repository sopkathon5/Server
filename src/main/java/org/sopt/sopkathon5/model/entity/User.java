package org.sopt.sopkathon5.model.entity;

import java.time.LocalDateTime;

import lombok.*;
import org.sopt.sopkathon5.model.request.JoinReq;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
	private int userIdx;
	private String email;
	private String password;
	private String nickname;
	private LocalDateTime birth;
	private int sex;
	private int point;

	@Builder
	public User(JoinReq joinReq) {
		this.email = joinReq.getEmail();
		this.password = joinReq.getPassword();
		this.nickname = joinReq.getNickname();
		this.birth = joinReq.getBirth();
		this.sex = joinReq.getSex();
	}
}

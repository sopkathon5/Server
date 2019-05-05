package org.sopt.sopkathon5.model.entity;

import java.time.LocalDateTime;

import lombok.*;

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
	public User(String email, String password, String nickname, LocalDateTime birth, int sex) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.birth = birth;
		this.sex = sex;
	}
}

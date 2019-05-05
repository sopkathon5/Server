package org.sopt.sopkathon5.model.response;

import lombok.Data;

@Data
public class LoginRes {
	private int userIdx;
	private String nickname;

	public LoginRes(int userIdx, String nickname) {
		this.userIdx = userIdx;
		this.nickname = nickname;
	}
}

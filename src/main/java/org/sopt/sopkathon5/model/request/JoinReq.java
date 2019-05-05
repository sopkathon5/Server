package org.sopt.sopkathon5.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinReq {
	private String email;
	private String password;
	private String nickname;
	private int sex;
	private int point;
}

package org.sopt.sopkathon5.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginReq {
	private String email;
	private String password;

	public boolean isLogin() {
		return (email != null && password != null);
	}
}

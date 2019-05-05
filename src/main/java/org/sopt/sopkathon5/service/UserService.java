package org.sopt.sopkathon5.service;

import org.sopt.sopkathon5.model.request.JoinReq;
import org.sopt.sopkathon5.model.request.LoginReq;
import org.sopt.sopkathon5.model.response.DefaultRes;

public interface UserService {

	DefaultRes join(final JoinReq joinReq);
	DefaultRes login(final LoginReq loginReq);
	DefaultRes point(final int userIdx);

}


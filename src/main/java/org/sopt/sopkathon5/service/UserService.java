package org.sopt.sopkathon5.service;

import org.sopt.sopkathon5.model.request.JoinReq;
import org.sopt.sopkathon5.model.response.DefaultRes;

public interface UserService {

	DefaultRes join(final JoinReq joinReq);

}


package org.sopt.sopkathon5.service;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.mapper.ContentMapper;
import org.sopt.sopkathon5.mapper.HeartMapper;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.utils.ResponseMessage;
import org.sopt.sopkathon5.utils.StatusCode;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HeartService {
	private final HeartMapper heartMapper;
	private final ContentMapper contentMapper;

	public HeartService(HeartMapper heartMapper, ContentMapper contentMapper) {
		this.heartMapper = heartMapper;
		this.contentMapper = contentMapper;
	}

	public DefaultRes heart(final int userIdx, final int contentIdx) {
		try {

			int heartCount = contentMapper.findHeart(contentIdx);
			heartCount = heartCount + 1;
			contentMapper.addHeart(heartCount, contentIdx);

			heartMapper.add(userIdx, contentIdx);

			return DefaultRes.res(StatusCode.OK, "좋아요 성공");
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}

}

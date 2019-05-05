package org.sopt.sopkathon5.service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.mapper.ContentMapper;
import org.sopt.sopkathon5.mapper.UserMapper;
import org.sopt.sopkathon5.model.entity.Content;
import org.sopt.sopkathon5.model.entity.Keyword;
import org.sopt.sopkathon5.model.request.ContentReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.utils.ResponseMessage;
import org.sopt.sopkathon5.utils.StatusCode;

import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContentService {
	private final ContentMapper contentMapper;
	private final UserMapper userMapper;

	public ContentService(ContentMapper contentMapper, UserMapper userMapper) {
		this.contentMapper = contentMapper;
		this.userMapper = userMapper;
	}

	// 키워드 조회
	public DefaultRes keyword() {
		try {
			List<Keyword> keywords = contentMapper.findAllKeyword();
			return DefaultRes.res(StatusCode.OK, "키워드 조회 성공", keywords);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}

	// 게시글 목록
	public DefaultRes contentList(final int keywordIdx) {
		try {
			List<Content> contents = contentMapper.findAllContent(keywordIdx);
			return DefaultRes.res(StatusCode.OK, "게시글 목록 조회 성공", contents);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}

	// 게시글
	public DefaultRes content(final int contentIdx) {
		try {
			Content content = contentMapper.findContent(contentIdx);
			return DefaultRes.res(StatusCode.OK, "게시글 조회 성공", content);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}

	// 게시글 추가
	public DefaultRes addContent(final ContentReq contentReq) {
		try {
			Content content = new Content(contentReq);
			contentMapper.addContent(content);

			int point = userMapper.point(contentReq.getUserIdx());
			point = point + 5;
			userMapper.addpoint(contentReq.getUserIdx(), point);

			return DefaultRes.res(StatusCode.OK, "게시글 추가 성공");
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}
}

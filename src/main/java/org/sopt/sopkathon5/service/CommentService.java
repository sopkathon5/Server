package org.sopt.sopkathon5.service;

import java.util.List;

import org.sopt.sopkathon5.mapper.CommentMapper;
import org.sopt.sopkathon5.mapper.ContentMapper;
import org.sopt.sopkathon5.model.entity.Comment;
import org.sopt.sopkathon5.model.request.CommentReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.utils.ResponseMessage;
import org.sopt.sopkathon5.utils.StatusCode;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
	private final CommentMapper commentMapper;
	private final ContentMapper contentMapper;

	public CommentService(CommentMapper commentMapper, ContentMapper contentMapper) {
		this.commentMapper = commentMapper;
		this.contentMapper = contentMapper;
	}

	public DefaultRes commentList(final int contentIdx) {
		try {
			List<Comment> comments = commentMapper.findAllComment(contentIdx);
			return DefaultRes.res(StatusCode.OK, "댓글 조회 성공", comments);
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
//			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}

	public DefaultRes comment(final CommentReq commentReq) {
		try {
			Comment comment = new Comment(commentReq);
			commentMapper.comment(comment);

			int commentCount = contentMapper.findComment(commentReq.getContentIdx());
			commentCount = commentCount + 1;
			contentMapper.addComment(commentCount, commentReq.getContentIdx());

			return DefaultRes.res(StatusCode.OK, "댓글 등록 성공");
		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
//			log.error(e.getMessage());
			return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
		}
	}
}

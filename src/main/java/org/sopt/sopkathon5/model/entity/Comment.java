package org.sopt.sopkathon5.model.entity;

import java.time.LocalDateTime;

import lombok.*;
import org.sopt.sopkathon5.model.request.CommentReq;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
	private int commentIdx;
	private int contentIdx;
	private int userIdx;
	private String content;
	private LocalDateTime createdAt;

	@Builder
	public Comment(CommentReq commentReq) {
		this.contentIdx = commentReq.getContentIdx();
		this.userIdx = commentReq.getUserIdx();
		this.content = commentReq.getContent();
		this.createdAt = LocalDateTime.now();
	}
}

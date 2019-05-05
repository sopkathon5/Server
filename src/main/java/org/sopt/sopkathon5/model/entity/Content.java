package org.sopt.sopkathon5.model.entity;

import java.time.LocalDateTime;

import lombok.*;
import org.sopt.sopkathon5.model.request.ContentReq;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {
	private int contentIdx;
	private int userIdx;
	private int keywordIdx;
	private LocalDateTime createdAt;
	private String name;
	private String content;
	private int heartCount;
	private int commentCount;

	@Builder
	public Content(ContentReq contentReq){
		this.userIdx = contentReq.getUserIdx();
		this.keywordIdx = contentReq.getKeywordIdx();
		this.content = contentReq.getContent();
		this.name = contentReq.getName();
		this.createdAt = LocalDateTime.now();
		this.heartCount = 0;
		this.commentCount = 0;
	}
}

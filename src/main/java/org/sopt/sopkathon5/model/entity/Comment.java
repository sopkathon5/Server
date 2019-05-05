package org.sopt.sopkathon5.model.entity;

import java.time.LocalDateTime;

import lombok.*;

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
	public Comment(int contentIdx, int userIdx, String content){
		this.contentIdx = contentIdx;
		this.userIdx = userIdx;
		this.content = content;
		this.createdAt = LocalDateTime.now();
	}
}

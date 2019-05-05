package org.sopt.sopkathon5.model.entity;

import java.time.LocalDateTime;

import lombok.*;

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
	public Content(int userIdx, int keywordIdx, String name, String content){
		this.userIdx = userIdx;
		this.keywordIdx = keywordIdx;
		this.content = content;
		this.name = name;
		this.createdAt = LocalDateTime.now();
	}
}

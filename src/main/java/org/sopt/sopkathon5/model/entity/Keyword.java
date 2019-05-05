package org.sopt.sopkathon5.model.entity;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {
	private int keywordIdx;
	private String content;
	private LocalDateTime endDate;

	@Builder
	public Keyword(String content, LocalDateTime endDate){
		this.content = content;
		this.endDate = endDate;
	}
}

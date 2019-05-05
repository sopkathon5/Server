package org.sopt.sopkathon5.model.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Heart {
	private int heartIdx;
	private int userIdx;
	private int contentIdx;

	@Builder
	public Heart(int userIdx, int contentIdx){
		this.userIdx = userIdx;
		this.contentIdx = contentIdx;
	}
}

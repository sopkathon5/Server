package org.sopt.sopkathon5.model.request;

import lombok.Data;

@Data
public class CommentReq {
	private int contentIdx;
	private int userIdx;
	private String content;
}

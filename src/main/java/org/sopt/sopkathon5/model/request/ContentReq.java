package org.sopt.sopkathon5.model.request;

import lombok.Data;

@Data
public class ContentReq {
	private int userIdx;
	private int keywordIdx;
	private String name;
	private String content;
}

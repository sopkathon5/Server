package org.sopt.sopkathon5.controller;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.model.request.CommentReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.service.CommentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.sopt.sopkathon5.model.response.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
	private final CommentService commentService;

	public CommentController(final CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping("/{contentIdx}")
	public ResponseEntity<DefaultRes> commentList(@PathVariable(value = "contentIdx") final int contentIdx) {
		try {
			return new ResponseEntity<>(commentService.commentList(contentIdx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("")
	public ResponseEntity<DefaultRes> comment(@RequestBody CommentReq commentReq) {
		try {
			return new ResponseEntity<>(commentService.comment(commentReq), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}


package org.sopt.sopkathon5.controller;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.model.request.ContentReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.service.ContentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.sopt.sopkathon5.model.response.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("/content")
public class ContentController {

	private final ContentService contentService;

	public ContentController(final ContentService contentService) {
		this.contentService = contentService;
	}

	@GetMapping("/keyword")
	public ResponseEntity<DefaultRes> keyword() {
		try {
			return new ResponseEntity<>(contentService.keyword(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/keyword/{keywordIdx}")
	public ResponseEntity<DefaultRes> contentList(@PathVariable(value = "keywordIdx") final int keywordIdx) {
		try {
			return new ResponseEntity<>(contentService.contentList(keywordIdx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{contentIdx}")
	public ResponseEntity<DefaultRes> content(@PathVariable(value = "contentIdx") final int contentIdx) {
		try {
			return new ResponseEntity<>(contentService.content(contentIdx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("")
	public ResponseEntity<DefaultRes> content(@RequestBody ContentReq contentReq) {
		try {
			return new ResponseEntity<>(contentService.addContent(contentReq), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

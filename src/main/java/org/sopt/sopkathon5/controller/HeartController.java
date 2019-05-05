package org.sopt.sopkathon5.controller;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sopkathon5.model.request.ContentReq;
import org.sopt.sopkathon5.model.response.DefaultRes;
import org.sopt.sopkathon5.service.HeartService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.sopt.sopkathon5.model.response.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
@RequestMapping("/heart")
public class HeartController {
	private final HeartService heartService;

	public HeartController(final HeartService heartService) {
		this.heartService = heartService;
	}

	@PostMapping("/{userIdx}/{contentIdx}")
	public ResponseEntity<DefaultRes> heart(@PathVariable(value = "userIdx") final int userIdx,
											@PathVariable(value = "contentIdx") final int contentIdx) {
		try {
			return new ResponseEntity<>(heartService.heart(userIdx, contentIdx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

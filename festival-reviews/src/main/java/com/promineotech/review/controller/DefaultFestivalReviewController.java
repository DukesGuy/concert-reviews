package com.promineotech.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.review.entity.Review;
import com.promineotech.review.service.FestivalReviewService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultFestivalReviewController implements FestivalReviewController {
	
	@Autowired
	private FestivalReviewService festivalReviewService;

	@Override
	public List<Review> fetchReviews(String concertName) {
		log.info("Controller: concertName={}", concertName);
		return festivalReviewService.fetchReviews(concertName);
	}

}

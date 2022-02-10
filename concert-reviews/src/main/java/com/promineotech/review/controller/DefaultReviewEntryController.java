package com.promineotech.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.ReviewEntry;
import com.promineotech.review.service.ReviewEntryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultReviewEntryController implements ReviewEntryController {

	@Autowired
	private ReviewEntryService reviewEntryService;
	
	@Override
	public Review createReview(ReviewEntry review) {
		log.info("Controller: {}", review);
		return reviewEntryService.createReview(review);
	}

}

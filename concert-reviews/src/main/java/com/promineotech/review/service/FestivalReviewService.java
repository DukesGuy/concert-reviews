package com.promineotech.review.service;

import java.util.List;

import com.promineotech.review.entity.Review;

public interface FestivalReviewService {
	
	List<Review> fetchReviews(String concertName);

}

package com.promineotech.review.dao;

import java.util.List;

import com.promineotech.review.entity.Review;

public interface FestivalReviewDao {
	
	List<Review> fetchReviews(String concertName);

}

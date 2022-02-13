package com.promineotech.review.service;

import java.util.List;

import com.promineotech.review.entity.Concert;
import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.Venue;

public interface FestivalReviewService {
	
	List<Review> fetchReviews(String concertName);
	
	List<Concert> fetchConcerts(String state);

	List<Venue> fetchVenues(String concertName);

}

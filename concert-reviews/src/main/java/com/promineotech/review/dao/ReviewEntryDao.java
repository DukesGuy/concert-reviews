package com.promineotech.review.dao;

import java.util.Date;
import java.util.Optional;

import com.promineotech.review.entity.Attendee;
import com.promineotech.review.entity.Concert;
import com.promineotech.review.entity.Review;

public interface ReviewEntryDao {
	
	Optional<Attendee> fetchAttendee(Long attendeeId);
	Optional<Concert> fetchConcert(String concertId);
	
	Review saveReview(Concert concert, Attendee attendee, Date datePosted, int productionRating, 
			int soundRating, int foodRating, int restroomRating, int merchRating, int parkingRating, 
			int securityRating, int attractionsRating, String comments);
	
	Review updateReview(Long reviewPK, Concert concert, Attendee attendee, Date datePosted, int productionRating, int soundRating,
			int foodRating, int restroomRating, int merchRating, int parkingRating, int securityRating,
			int attractionsRating, String comments);
	
	Review delete(Long reviewPK);
	

}

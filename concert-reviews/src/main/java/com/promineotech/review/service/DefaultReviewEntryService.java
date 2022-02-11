package com.promineotech.review.service;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.review.dao.ReviewEntryDao;
import com.promineotech.review.entity.Attendee;
import com.promineotech.review.entity.Concert;
import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.ReviewEntry;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultReviewEntryService implements ReviewEntryService {

	@Autowired
	private ReviewEntryDao reviewEntryDao;
	
	@Override
	@Transactional
	public Review createReview(ReviewEntry review) {
		log.info("Service: {}", review);
		
		Concert concert = getConcert(review);
		Attendee attendee = getAttendee(review);
		Date datePosted = review.getDatePosted();
		int productionRating = review.getProductionRating();
		int soundRating = review.getSoundRating();
		int foodRating = review.getFoodRating();
		int restroomRating = review.getRestroomRating();
		int merchRating = review.getMerchRating();
		int parkingRating = review.getParkingRating();
		int securityRating = review.getSecurityRating();
		int attractionsRating = review.getAttractionsRating();
		String comments = review.getComments();
		
		return reviewEntryDao.saveReview(concert, attendee, datePosted, productionRating, 
				soundRating, foodRating, restroomRating, merchRating, parkingRating, 
				securityRating, attractionsRating, comments);
	}
	
	@Override
	@Transactional
	public Review update(ReviewEntry review, Long reviewPK) {
		log.info("Service: Updating review id = {}: {}", reviewPK, review);
		
		Concert concert = getConcert(review);
		Attendee attendee = getAttendee(review);
		Date datePosted = review.getDatePosted();
		int productionRating = review.getProductionRating();
		int soundRating = review.getSoundRating();
		int foodRating = review.getFoodRating();
		int restroomRating = review.getRestroomRating();
		int merchRating = review.getMerchRating();
		int parkingRating = review.getParkingRating();
		int securityRating = review.getSecurityRating();
		int attractionsRating = review.getAttractionsRating();
		String comments = review.getComments();
		
		return reviewEntryDao.updateReview(reviewPK, concert, attendee, datePosted, productionRating, 
				soundRating, foodRating, restroomRating, merchRating, parkingRating, 
				securityRating, attractionsRating, comments);
	}
	
	@Override
	@Transactional
	public Review delete(Long reviewPK) {
		log.info("Service: Deleting review id = {}", reviewPK);
		
		return reviewEntryDao.delete(reviewPK);
	}

	private Attendee getAttendee(ReviewEntry reviewEntry) {
		return reviewEntryDao.fetchAttendee(reviewEntry.getAttendeeId())
				.orElseThrow(() -> new NoSuchElementException("Attendee with ID = "
			            + reviewEntry.getAttendeeId() + " was not found"));
	}

	private Concert getConcert(ReviewEntry reviewEntry) {
		return reviewEntryDao.fetchConcert(reviewEntry.getConcertId())
				.orElseThrow(() -> new NoSuchElementException("Concert with name = "
			            + reviewEntry.getConcertId() + " was not found"));
	}


}

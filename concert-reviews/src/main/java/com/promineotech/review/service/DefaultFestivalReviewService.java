package com.promineotech.review.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.review.dao.FestivalReviewDao;
import com.promineotech.review.entity.Concert;
import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.Venue;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultFestivalReviewService implements FestivalReviewService {

	@Autowired
	private FestivalReviewDao festivalReviewDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Review> fetchReviews(String concertName) {
		log.info("Service: concertName = {}", concertName);
		
		List<Review> reviews = festivalReviewDao.fetchReviews(concertName);
		
		if(reviews.isEmpty()) {
			String msg = String.format("No reviews were found for %s", concertName);
			throw new NoSuchElementException(msg);
		}
		
		return reviews;
	}
	
	@Transactional
	@Override
	public List<Concert> fetchConcerts(String state) {
		log.info("Service: state = {}", state);
		
		List<Concert> concerts = festivalReviewDao.fetchConcerts(state);
		
		if(concerts.isEmpty()) {
			String msg = String.format("No concerts were found in %s", state);
			throw new NoSuchElementException(msg);
		}
		
		return concerts;
	}

	@Override
	public List<Venue> fetchVenues(String concertName) {
		log.info("Service: concertName = {}", concertName);
		
		List<Venue> venues = festivalReviewDao.fetchVenues(concertName);
		
		if(venues.isEmpty()) {
			String msg = String.format("No venues were found for %s", concertName);
			throw new NoSuchElementException(msg);
		}
		
		return venues;
	}

}

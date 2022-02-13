package com.promineotech.review.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.review.entity.Concert;
import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.Venue;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultFestivalReviewDao implements FestivalReviewDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Review> fetchReviews(String concertName) {
		log.info("DAO: concertName = {}", concertName);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM reviews "
				+ "WHERE concert_id = :concert_id";
		// @formatter:on
		
		Map<String, Object> parms = Map.of("concert_id", concertName.toString());
		
		return jdbcTemplate.query(sql, parms, new RowMapper<Review>() {
			@Override
			public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Review.builder()
						.reviewPK(rs.getObject("review_pk", Long.class))
						.concertId(rs.getString("concert_id"))
						.attendeeId(rs.getObject("attendee_id", Long.class))
						.datePosted(rs.getObject("date_posted", Date.class))
						.productionRating(rs.getInt("production_rating"))
						.soundRating(rs.getInt("sound_rating"))
						.foodRating(rs.getInt("food_rating"))
						.restroomRating(rs.getInt("restroom_rating"))
						.merchRating(rs.getInt("merch_rating"))
						.parkingRating(rs.getInt("parking_rating"))
						.securityRating(rs.getInt("security_rating"))
						.attractionsRating(rs.getInt("attractions_rating"))
						.comments(rs.getString("comments"))
						.build();
				// @formatter:on
			}
			
		});
	}

	@Override
	public List<Concert> fetchConcerts(String state) {
		log.info("DAO: state = {}", state);
		
		// @formatter:off
		String sql = ""
				+ "SELECT concerts.* "
				+ "FROM concerts "
				+ "INNER JOIN venues "
				+ "ON concerts.venue_id = venues.venue_pk "
				+ "WHERE venues.state = :state";
		// @formatter:on
		
		Map<String, Object> parms = Map.of("state", state.toString());
		
		return jdbcTemplate.query(sql, parms, new RowMapper<Concert>() {
			@Override
			public Concert mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Concert.builder()
						.concertName(rs.getString("concert_name"))
						.venueId(rs.getObject("venue_id", Long.class))
						.dateId(rs.getString("date_id"))
						.organizer(rs.getString("organizer"))
						.build();
				// @formatter:on
			}
			
		});
	}

	@Override
	public List<Venue> fetchVenues(String concertName) {
		log.info("DAO: concertName = {}", concertName);
		
		// @formatter:off
		String sql = ""
				+ "SELECT venues.* "
				+ "FROM venues "
				+ "INNER JOIN concerts "
				+ "ON concerts.venue_id = venues.venue_pk "
				+ "WHERE concerts.concert_name = :concert_name";
		// @formatter:on
		
		Map<String, Object> parms = Map.of("concert_name", concertName.toString());
		
		return jdbcTemplate.query(sql, parms, new RowMapper<Venue>() {
			@Override
			public Venue mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter:off
				return Venue.builder()
						.venuePK(rs.getObject("venue_pk", Long.class))
						.venueName(rs.getString("venue_name"))
						.street(rs.getString("street"))
						.city(rs.getString("city"))
						.state(rs.getString("state"))
						.zip(rs.getString("zip"))
						.build();
				// @formatter:on
			}
			
		});
	}
	
	

}

package com.promineotech.review.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.review.entity.Attendee;
import com.promineotech.review.entity.Concert;
import com.promineotech.review.entity.Review;


@Component
public class DefaultReviewEntryDao implements ReviewEntryDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Review saveReview(Concert concert, Attendee attendee, Date datePosted, int productionRating, 
			int soundRating, int foodRating, int restroomRating, int merchRating, int parkingRating, 
			int securityRating, int attractionsRating, String comments) {
		
		SqlParams sqlParams = generateInsertSql(concert, attendee, datePosted, productionRating, 
				soundRating, foodRating, restroomRating, merchRating, parkingRating, 
				securityRating, attractionsRating, comments);
		  
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder, new String[] { "review_pk" });
		  
		  Long reviewPK = keyHolder.getKey().longValue();
		  
		  // @formatter:off
		  return Review.builder()
				  .reviewPK(reviewPK)
				  .concertId(concert.getConcertName())
				  .attendeeId(attendee.getAttendeePK())
				  .datePosted(datePosted)
				  .productionRating(productionRating)
				  .soundRating(soundRating)
				  .foodRating(foodRating)
				  .restroomRating(restroomRating)
				  .merchRating(merchRating)
				  .parkingRating(parkingRating)
				  .securityRating(securityRating)
				  .attractionsRating(attractionsRating)
				  .comments(comments)
				  .build();
		  // @formatter:on
		  
	}
	
	@Override
	public Review updateReview(Long reviewPK, Concert concert, Attendee attendee, Date datePosted, int productionRating, 
			int soundRating, int foodRating, int restroomRating, int merchRating, int parkingRating, 
			int securityRating, int attractionsRating, String comments) {
		
		SqlParams sqlParams = generateUpdateSql(reviewPK, concert, attendee, datePosted, productionRating, 
				soundRating, foodRating, restroomRating, merchRating, parkingRating, 
				securityRating, attractionsRating, comments);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(sqlParams.sql, sqlParams.source, keyHolder);
		  
		  // @formatter:off
		  return Review.builder()
				  .reviewPK(reviewPK)
				  .concertId(concert.getConcertName())
				  .attendeeId(attendee.getAttendeePK())
				  .datePosted(datePosted)
				  .productionRating(productionRating)
				  .soundRating(soundRating)
				  .foodRating(foodRating)
				  .restroomRating(restroomRating)
				  .merchRating(merchRating)
				  .parkingRating(parkingRating)
				  .securityRating(securityRating)
				  .attractionsRating(attractionsRating)
				  .comments(comments)
				  .build();
		  // @formatter:on
		  
	}
	
	@Override
	public Review delete(Long reviewPK) {
		
		SqlParams sqlParams = new SqlParams();
		
		String sql = "DELETE FROM reviews WHERE review_pk = :review_pk";
		sqlParams.source.addValue("review_pk", reviewPK);
		
		jdbcTemplate.update(sql, sqlParams.source);
		
		return Review.builder().reviewPK(reviewPK).build();
	}
	
	private SqlParams generateInsertSql(Concert concert, Attendee attendee, Date datePosed, int productionRating, 
			int soundRating, int foodRating, int restroomRating, int merchRating, int parkingRating, 
			int securityRating, int attractionsRating, String comments) {
		
		// @formatter:off
	    String sql = ""
	        + "INSERT INTO reviews ("
	        + "concert_id, attendee_id, production_rating, sound_rating, food_rating, restroom_rating, "
	        + "merch_rating, parking_rating, security_rating, attractions_rating, comments"
	        + ") VALUES ("
	        + ":concert_id, :attendee_id, :production_rating, :sound_rating, :food_rating, :restroom_rating, "
	        + ":merch_rating, :parking_rating, :security_rating, :attractions_rating, :comments"
	        + ")";
	    // @formatter:on
	    
	    SqlParams params = new SqlParams();
	    
	    params.sql = sql;
	    params.source.addValue("concert_id", concert.getConcertName());
	    params.source.addValue("attendee_id", attendee.getAttendeePK());
	    params.source.addValue("production_rating", productionRating);
	    params.source.addValue("sound_rating", soundRating);
	    params.source.addValue("food_rating", foodRating);
	    params.source.addValue("restroom_rating", restroomRating);
	    params.source.addValue("merch_rating", merchRating);
	    params.source.addValue("parking_rating", parkingRating);
	    params.source.addValue("security_rating", securityRating);
	    params.source.addValue("attractions_rating", attractionsRating);
	    params.source.addValue("comments", comments);
	    
	    
	    return params;
	}
	
	private SqlParams generateUpdateSql(Long reviewPK, Concert concert, Attendee attendee, Date datePosed, int productionRating, 
			int soundRating, int foodRating, int restroomRating, int merchRating, int parkingRating, 
			int securityRating, int attractionsRating, String comments) {
		
		// @formatter:off
	    String sql = ""
	        + "UPDATE reviews "
	        + "SET concert_id = :concert_id, attendee_id = :attendee_id, production_rating = :production_rating, sound_rating = :sound_rating, food_rating = :food_rating, restroom_rating = :restroom_rating, "
	        + "merch_rating = :merch_rating, parking_rating = :parking_rating, security_rating = :security_rating, attractions_rating = :attractions_rating, comments = :comments "
	        + "WHERE review_pk = :review_pk";
	    // @formatter:on
	    
	    SqlParams params = new SqlParams();
	    
	    params.sql = sql;
	    params.source.addValue("review_pk", reviewPK);
	    params.source.addValue("concert_id", concert.getConcertName());
	    params.source.addValue("attendee_id", attendee.getAttendeePK());
	    params.source.addValue("production_rating", productionRating);
	    params.source.addValue("sound_rating", soundRating);
	    params.source.addValue("food_rating", foodRating);
	    params.source.addValue("restroom_rating", restroomRating);
	    params.source.addValue("merch_rating", merchRating);
	    params.source.addValue("parking_rating", parkingRating);
	    params.source.addValue("security_rating", securityRating);
	    params.source.addValue("attractions_rating", attractionsRating);
	    params.source.addValue("comments", comments);
	    
	    
	    return params;
	}
	
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

	@Override
	public Optional<Attendee> fetchAttendee(Long attendeeId) {
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM attendees "
			+ "WHERE attendee_pk = :attendee_pk";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("attendee_pk", attendeeId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql, params, new AttendeeResultSetExtractor()));
	}

	@Override
	public Optional<Concert> fetchConcert(String concertId) {
		// @formatter:off
		String sql = ""
			+ "SELECT * "
			+ "FROM concerts "
			+ "WHERE concert_name = :concert_name";
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("concert_name", concertId);
		
		return Optional.ofNullable(jdbcTemplate.query(sql, params, new ConcertResultSetExtractor()));
	}
	
	class AttendeeResultSetExtractor implements ResultSetExtractor<Attendee> {

		@Override
		public Attendee extractData(ResultSet rs) throws SQLException {
			rs.next();
			
			// @formatter:off
			return Attendee.builder()
					.attendeePK(rs.getLong("attendee_pk"))
					.firstName(rs.getString("first_name"))
					.lastName(rs.getString("last_name"))
					.username(rs.getString("username"))
					.email(rs.getString("email"))
					.build();
			// @formatter:on
		}
		
	}
	
	class ConcertResultSetExtractor implements ResultSetExtractor<Concert> {

		@Override
		public Concert extractData(ResultSet rs) throws SQLException {
			rs.next();
			
			// @formatter:off
			return Concert.builder()
					.concertName(rs.getString("concert_name"))
					.venueId(rs.getLong("venue_id"))
					.dateId(rs.getString("date_id"))
					.organizer(rs.getString("organizer"))
					.build();
			// @formatter:on
		}
		
	}
	
	class ReviewResultSetExtractor implements ResultSetExtractor<Review> {

		@Override
		public Review extractData(ResultSet rs) throws SQLException {
			rs.next();
			
			// @formatter:off
			return Review.builder()
					.reviewPK(rs.getLong("review_pk"))
					.concertId(rs.getString("concert_id"))
					.attendeeId(rs.getLong("venue_id"))
					.datePosted(rs.getDate("date_posted"))
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
		
	}

}

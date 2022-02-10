package com.promineotech.review.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Review {
	private Long reviewPK;
	private String concertId;
	private Long attendeeId;
	private Date datePosted;
	private int productionRating;
	private int soundRating;
	private int foodRating;
	private int restroomRating;
	private int merchRating;
	private int parkingRating;
	private int securityRating;
	private int attractionsRating;
	private String comments;
	
	@JsonIgnore
	public Long getReviewPK() {
		return reviewPK;
	}
}

package com.promineotech.review.entity;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class ReviewEntry {
	
	@NotNull
	@Length(max = 40)
	@Pattern(regexp = "[\\w\\s]*")
	private String concertId;
	
	@NotNull
	private Long attendeeId;
	
	@NotNull
	private Date datePosted;
	
	@Positive
	@Min(1)
	@Max(10)
	private int productionRating;
	
	@Positive
	@Min(1)
	@Max(10)
	private int soundRating;
	
	@Positive
	@Min(1)
	@Max(10)
	private int foodRating;
	
	@Positive
	@Min(1)
	@Max(10)
	private int restroomRating;
	
	@Positive
	@Min(1)
	@Max(10)
	private int merchRating;
	
	@Positive
	@Min(1)
	@Max(10)
	private int parkingRating;
	
	@Positive
	@Min(1)
	@Max(10)
	private int securityRating;
	
	@Positive
	@Min(1)
	@Max(10)
	private int attractionsRating;
	
	@NotNull
	@Length(max = 255)
	@Pattern(regexp = "[\\w\\s]*")
	private String comments;


}

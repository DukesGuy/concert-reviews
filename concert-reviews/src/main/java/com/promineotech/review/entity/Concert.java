package com.promineotech.review.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Concert {
	private String concertName;
	private Long venueId;
	private String dateId;
	private String organizer;
	
	@JsonIgnore
	public Long getVenueId() {
		return venueId;
	}
}

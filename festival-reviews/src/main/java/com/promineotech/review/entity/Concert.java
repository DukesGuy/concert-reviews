package com.promineotech.review.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Concert {
	private Long concertPK;
	private String concertName;
	private Long venueId;
	private Date dateId;
	private String organizer;
}

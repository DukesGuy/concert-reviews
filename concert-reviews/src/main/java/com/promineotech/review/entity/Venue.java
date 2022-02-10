package com.promineotech.review.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Venue {
	private Long venuePK;
	private String venueName;
	private String street;
	private String city;
	private String state;
	private String zip;
}

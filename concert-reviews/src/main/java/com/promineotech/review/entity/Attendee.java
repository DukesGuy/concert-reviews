package com.promineotech.review.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attendee {
	private Long attendeePK;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
}

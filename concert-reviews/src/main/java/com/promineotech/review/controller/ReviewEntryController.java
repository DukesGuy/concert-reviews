package com.promineotech.review.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.ReviewEntry;


@Validated
@RequestMapping("/entry")
public interface ReviewEntryController {
/*	
	// @formatter:off
		@Operation(
			summary = "Creates a review",
			description = "Creates a review for given a concert name",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "A review is created",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Review.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No concerts were found with the input criteria",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occurred.",
							content = @Content(mediaType = "application/json")),
			},
			parameters = {
					@Parameter(
							name = "concertName",
							allowEmptyValue = false,
							required = true,
							description = "The concert name (i.e., 'Decadence AZ')"),
					@Parameter(
							name = "attendeeId",
							allowEmptyValue = false,
							required = true,
							description = "The attendee ID (i.e., '1')"),
					@Parameter(
							name = "productionRating",
							allowEmptyValue = false,
							required = false,
							description = "The production rating (i.e., '1-10')"),
					@Parameter(
							name = "soundRating",
							allowEmptyValue = false,
							required = false,
							description = "The sound rating (i.e., '1-10')"),
					@Parameter(
							name = "foodRating",
							allowEmptyValue = false,
							required = false,
							description = "The food rating (i.e., '1-10')"),
					@Parameter(
							name = "restroomRating",
							allowEmptyValue = false,
							required = false,
							description = "The restroom rating (i.e., '1-10')"),
					@Parameter(
							name = "merchRating",
							allowEmptyValue = false,
							required = false,
							description = "The merch rating (i.e., '1-10')"),
					@Parameter(
							name = "parkingRating",
							allowEmptyValue = false,
							required = false,
							description = "The parking rating (i.e., '1-10')"),
					@Parameter(
							name = "securityRating",
							allowEmptyValue = false,
							required = false,
							description = "The security rating (i.e., '1-10')"),
					@Parameter(
							name = "attractionsRating",
							allowEmptyValue = false,
							required = false,
							description = "The attractions rating (i.e., '1-10')"),
					@Parameter(
							name = "comments",
							allowEmptyValue = false,
							required = true,
							description = "comments (1-255 characters)"),
			}
		)
	// @formatter:on
*/			
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Review createReview(@Valid @RequestBody ReviewEntry review);
	

}

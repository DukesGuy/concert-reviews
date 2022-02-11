package com.promineotech.review.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.review.entity.Review;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/reviews")
@OpenAPIDefinition(info = @Info(title = "Festival Review Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface FestivalReviewController {
	
	// @formatter:off
		@Operation(
			summary = "Returns a list of reviews",
			description = "Returns a list of reviews given a concert name",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "A list of reviews is returned",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = Review.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No reviews were found with the input criteria",
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
							description = "The concert name (i.e., 'Decadence AZ')")
			}
		)
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		public List<Review> fetchReviews(
				@Length(max = 40)
				@Pattern(regexp = "[\\w\\s]*")
				@RequestParam(required = false)
				String concertName);
		// @formatter:on		
		

}

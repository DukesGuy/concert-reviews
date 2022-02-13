package com.promineotech.review.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.review.entity.Review;
import com.promineotech.review.entity.ReviewEntry;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@Validated
@RequestMapping("/reviews")
public interface ReviewEntryController {

	@Operation(summary = "Create a review")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Save review",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Review.class))}),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Review createReview(@Valid @RequestBody ReviewEntry review);
	
	
	
	@Operation(summary = "Update a review")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Updated review",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Review.class))}),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.OK)
	Review update(@Valid @RequestBody ReviewEntry review, 
			@Parameter (description = "Review id to be updated")
			@RequestParam(required = true)
			@PathVariable Long reviewPK);
	
	
	
	@Operation(summary = "Delete a review")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Deleted review",
					content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Review.class))}),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
	})
	@DeleteMapping("/delete")
	@ResponseStatus(code = HttpStatus.OK)
	Review delete(
			@Parameter(description = "Review id to be deleted") 
			@RequestParam(required = true)
			@PathVariable Long reviewPK);
	

}

package com.promineotech.review.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.promineotech.review.entity.Review;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/Festival_Review_Schema.sql",
		"classpath:flyway/migrations/Festival_Data.sql"},
		config = @SqlConfig(encoding = "utf-8"))
class ReviewEntryTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;

	@Test
	void testCreateReviewReturnsSuccess201() {
		// Given: a body and REST URI
		String body = createOrderBody();
		String uri = String.format("http://localhost:%d/entry", serverPort);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> bodyEntity = new HttpEntity<String>(body,headers);
		
		// When: an HTTP (REST) request is sent to the service
		ResponseEntity<Review> response = 
				restTemplate.exchange(uri, HttpMethod.POST, bodyEntity, Review.class);
		
		// Then: assert status code is equal to 201
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isNotNull();
	}

	private String createOrderBody() {
		// @formatter:off
		return "{"
			+ "  \"concertId\":\"Coachella\","
			+ "  \"attendeeId\":1,"
			+ "  \"datePosted\":\"2022-02-10T02:46:47.000+00:00\","
			+ "  \"productionRating\":10,"
			+ "  \"soundRating\":10,"
			+ "  \"foodRating\":10,"
			+ "  \"restroomRating\":10,"
			+ "  \"merchRating\":10,"
			+ "  \"parkingRating\":10,"
			+ "  \"securityRating\":10,"
			+ "  \"attractionsRating\":10,"
			+ "  \"comments\":\"This is a test\""
			+ "}";
		// @formatter:on
	}

}

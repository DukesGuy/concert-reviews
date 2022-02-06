package com.promineotech.review.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
class FetchReviewTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int serverPort;

	@Test
	void testThatReviewsAreReturnedWhenAValidConcertNameIsSupplied() {
		// Given: a concert name and REST URI
		String concertName = "Decadence AZ";
		String uri = String.format(
				"http://localhost:%d/reviews?concertName=%s", serverPort, concertName);
		
		// When: an HTTP (REST) request is sent to the service
		ResponseEntity<List<Review>> response = 
				restTemplate.exchange(
						uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		//Then: the response status is 200 (OK)
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void testThatAnErrorMessageIsReturnedWhenAnUnknownConcertNameIsSupplied() {
		// Given: a concert name and REST URI
		String concertName = "Unknown concert name";
		String uri = String.format(
				"http://localhost:%d/reviews?concertName=%s", serverPort, concertName);
		
		// When: an HTTP (REST) request is sent to the service
		ResponseEntity<Map<String, Object>> response = 
				restTemplate.exchange(
						uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		// Then: a not found (404) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		
		// And: an error message is returned
		Map<String, Object> error = response.getBody();
		
		assertErrorMessageValid(error, HttpStatus.NOT_FOUND);
		
		
	}
	
	protected void assertErrorMessageValid(Map<String, Object> error,
			HttpStatus status) {
		// @formatter:off
		assertThat(error)
			.containsKey("message")
			.containsEntry("status code", status.value())
			.containsEntry("uri", "/reviews")
			.containsKey("timestamp")
			.containsEntry("reason", status.getReasonPhrase());
		// @formatter:on
	}

}

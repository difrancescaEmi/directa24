/**
 * 
 */
package com.directa24.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.directa24.model.EronMoviesResponse;
import com.directa24.service.RestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @author Emi
 *
 */
@SpringBootTest
public class ApplicationTests {
	
	@Test
	void givenGetData_whenRestClientFetch_thenReturnsPageOfMovies(@Autowired RestUtils restUtils) throws JsonMappingException, JsonProcessingException {
		
		EronMoviesResponse responseEntity = restUtils.getObjectMapper().readValue(restUtils.getResponse(System.getenv("eron.movies.url") + "1"), 
																				  EronMoviesResponse.class);
		
		assertEquals(10, responseEntity.getPerPage());
	    assertNotNull(responseEntity.getLstEronMoviesData());
	}
}
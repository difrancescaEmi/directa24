/**
 * 
 */
package com.directa24.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Emi
 *
 */
@Service
public class RestUtils {
	
	private final RestClient restClient;
	private ObjectMapper objectMapper;

	RestUtils(RestClient.Builder restClient) {
		
		this.restClient   = restClient.build();
		this.objectMapper = new ObjectMapper();
	}

	public String getResponse(String url) {

		return this.restClient.get().uri(url).retrieve().body(String.class);
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}
}
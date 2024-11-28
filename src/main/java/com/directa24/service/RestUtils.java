/**
 * 
 */
package com.directa24.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Emi
 *
 */
@Service
public class RestUtils {

	private OkHttpClient client;
	private Gson gson; 
	
	public OkHttpClient getClient() {
		
		if(client == null)
			client = new OkHttpClient(); 
		return client;
	}
	
	public Gson getGson() {
		
		if(gson == null)
			gson = new Gson();
		return gson;
	}
	
	public String getResponse(String url) {
		
		Request request = new Request.Builder().url(url).build();
		
		Response response = null;
		
		try {
			
			response = getClient().newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
}
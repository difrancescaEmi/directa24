/**
 * 
 */
package com.directa24.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.directa24.model.EronMovieDirectorsSortedNames;
import com.directa24.model.EronMoviesData;
import com.directa24.model.EronMoviesResponse;
import com.directa24.service.EronMoviesService;
import com.directa24.service.RestUtils;

/**
 * @author Emi
 *
 */
@Component("eronMoviesService")
public class EronMoviesServiceImpl implements EronMoviesService {

	@Autowired
	private RestUtils restUtils;
	
	@Override
	public String getDirectorsNamesWithMoreMoviesThanThreshold(int threshold) {
		
		List<String> lstDirectors = new ArrayList<String>();
		List<EronMoviesData> lstEronMovies = new ArrayList<EronMoviesData>();
		
		Integer totalPages = callEronMovies("0").getTotalPages();
		
		for(Integer i = 1 ; i <= totalPages ; i++) 
			lstEronMovies.addAll(callEronMovies(i.toString()).getLstEronMoviesData());
		
		for(EronMoviesData eronMovieData : lstEronMovies) 
			lstDirectors.add(eronMovieData.getDirector());
		
		Map<String, Integer> counts = new HashMap<>();
		for (String item : lstDirectors) {
		    Integer count = counts.get(item);
		    if (count == null) {
		        count = 0;
		    }
		    count = count + 1;
		    counts.put(item, count);
		}
		
		lstDirectors.clear();
		
		for (Map.Entry<String, Integer> entry : counts.entrySet())
			if(entry.getValue() > threshold)
				lstDirectors.add(entry.getKey());
		
		lstDirectors.sort((director1, director2) -> director1.compareTo(director2));
		
		EronMovieDirectorsSortedNames eronMovieDirectorsSortedNames = new EronMovieDirectorsSortedNames();
		eronMovieDirectorsSortedNames.setDirectors(lstDirectors);
		
		return restUtils.getGson().toJson(eronMovieDirectorsSortedNames);
	}
	
	private EronMoviesResponse callEronMovies(String page) {
		
		return restUtils.getGson().fromJson(restUtils.getResponse("https://eron-movies.wiremockapi.cloud/api/movies/search?page="+page), 
				                            EronMoviesResponse.class);
	}
}
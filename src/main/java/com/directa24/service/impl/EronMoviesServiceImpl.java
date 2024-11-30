/**
 * 
 */
package com.directa24.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.directa24.model.EronMovieDirectorsSortedNames;
import com.directa24.model.EronMoviesData;
import com.directa24.model.EronMoviesResponse;
import com.directa24.service.EronMoviesService;
import com.directa24.service.RestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Emi
 *
 */
@Component("eronMoviesService")
public class EronMoviesServiceImpl implements EronMoviesService {
	
	@Autowired
	private RestUtils restUtils;
	
	public String getDirectorsNamesWithMoreMoviesThanThreshold(int threshold) throws JsonProcessingException {
		
		Iterator<List<EronMoviesData>> eronMoviesDataIterator = fetchAllMovies();
		List<String> lstDirectors = new ArrayList<String>();
		
		while(eronMoviesDataIterator.hasNext())
			lstDirectors.addAll(eronMoviesDataIterator.next().stream()
					 										 .map(p -> p.getDirector())
					 										 .collect(Collectors.toList()));
		
		Map<String,Long> mapDirectorsCount = lstDirectors.stream()
	            							             .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		lstDirectors.clear();
		lstDirectors = mapDirectorsCount.entrySet()
	                                    .stream()
	                                    .filter(entry -> entry.getValue() > threshold)
	                                    .map(Map.Entry::getKey)
	                                    .distinct()
	                                    .collect(Collectors.toList());

		lstDirectors.sort(Comparator.comparing(o -> o));
		return getRestUtils().getObjectMapper().writeValueAsString(new EronMovieDirectorsSortedNames(lstDirectors));
	}
	
	public Iterator<List<EronMoviesData>> fetchAllMovies() {
		
	    return new ResponseIterator();
	}

	public class ResponseIterator implements Iterator<List<EronMoviesData>> {

	    private Long nextPage;

	    public ResponseIterator() {
	    	
	      nextPage = 1L;
	    }

	    @Override
	    public boolean hasNext() {
	    	
	      return nextPage != null;
	    }

	    @Override
	    public List<EronMoviesData> next() {
	    	
	      if (!hasNext()) 
	        throw new NoSuchElementException("No more pages in API response.");
	      
	      EronMoviesResponse response = null;
	      	
	      try {
	    	  
			response = callFetchMoviesByPage(nextPage);
		  } catch (IOException e) {
			  
			e.printStackTrace();
		  }
	      
	      nextPage = getNextPageNo(response.getPage(), response.getTotalPages());
	      return response.getLstEronMoviesData();
	    }

	    private Long getNextPageNo(Long currentPage, Long totalPages) {
	    	
	      if (currentPage + 1 <= totalPages) 
	        return currentPage + 1;
	      
	      return null;
	    }
	}
	
	private EronMoviesResponse callFetchMoviesByPage(Long pageNo) throws IOException {
		
	    return fetchMoviesByPage(pageNo);
	}

	public EronMoviesResponse fetchMoviesByPage(Long page) throws IOException{
		
		return getRestUtils().getObjectMapper().readValue(getRestUtils().getResponse(System.getenv("eron.movies.url") + page.toString()), 
				                                          EronMoviesResponse.class);
	}
	
	public RestUtils getRestUtils() {
		
		return restUtils;
	}
}
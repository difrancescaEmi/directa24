/**
 * 
 */
package com.directa24.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.directa24.service.EronMoviesService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Emi
 *
 */
@RestController
@RequestMapping("/api/directors")
public class MasterController {
	
	@Autowired
	private EronMoviesService eronMoviesService;

	@RequestMapping(method = RequestMethod.GET)
	public String getDirectorsNamesWithMoreMoviesThanThreshold(@RequestParam("threshold") int threshold, 
			                                                         HttpServletRequest request) throws Exception  {

		return eronMoviesService.getDirectorsNamesWithMoreMoviesThanThreshold(threshold);
	}
}
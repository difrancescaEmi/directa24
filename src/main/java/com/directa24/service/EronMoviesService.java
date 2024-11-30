package com.directa24.service;

import java.io.IOException;

import com.directa24.model.EronMoviesResponse;

/**
 * @author Emi
 *
 */
public interface EronMoviesService {

	String getDirectorsNamesWithMoreMoviesThanThreshold(int threshold) throws IOException;
}
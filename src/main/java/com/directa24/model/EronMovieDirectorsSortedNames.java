/**
 * 
 */
package com.directa24.model;

import java.util.List;

/**
 * @author Emi
 *
 */
public class EronMovieDirectorsSortedNames {
	
	public EronMovieDirectorsSortedNames(List<String> directors) {
		super();
		this.directors = directors;
	}
	private List<String> directors;

	public List<String> getDirectors() {
		return directors;
	}
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
}
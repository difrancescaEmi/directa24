/**
 * 
 */
package com.directa24.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Emi
 *
 */
public class EronMoviesData {

	@SerializedName("Title")
	private String title;
	@SerializedName("Year")
	private String year;
	@SerializedName("Rated")
	private String rated;
	@SerializedName("Released")
	private String released;
	@SerializedName("Runtime")
	private String runtime;
	@SerializedName("Genre")
	private String genre;
	@SerializedName("Director")
	private String director;
	@SerializedName("Writer")
	private String writer;
	@SerializedName("Actors")
	private String actors;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
}
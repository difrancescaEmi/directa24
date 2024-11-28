/**
 * 
 */
package com.directa24.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * @author Emi
 *
 */
public class EronMoviesResponse {

	private int page;
	@SerializedName("per_page")
	private int perPage;
	private int total;
	@SerializedName("total_pages")
	private int totalPages;
	@SerializedName("data")
	private List<EronMoviesData> lstEronMoviesData;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<EronMoviesData> getLstEronMoviesData() {
		return lstEronMoviesData;
	}
	public void setLstEronMoviesData(List<EronMoviesData> lstEronMoviesData) {
		this.lstEronMoviesData = lstEronMoviesData;
	}
}
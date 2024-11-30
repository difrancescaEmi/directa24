/**
 * 
 */
package com.directa24.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Emi
 *
 */
public class EronMoviesResponse {

	private Long page;
	@JsonProperty("per_page")
	private Long perPage;
	private Long total;
	@JsonProperty("total_pages")
	private Long totalPages;
	@JsonProperty("data")
	private List<EronMoviesData> lstEronMoviesData;
	
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public List<EronMoviesData> getLstEronMoviesData() {
		return lstEronMoviesData;
	}
	public void setLstEronMoviesData(List<EronMoviesData> lstEronMoviesData) {
		this.lstEronMoviesData = lstEronMoviesData;
	}
}
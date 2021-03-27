package com.ltts.Detailinfo.model;

public class Movie {
	
	
	private int movieId;
	private String movieName;
	private String cast;
	private String releaseDate;
	private int price;
	
	
	
	
	public Movie() {
		super();
	}
	public Movie(int movieId, String movieName, String cast, String releaseDate, int price) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.cast = cast;
		this.releaseDate = releaseDate;
		this.price = price;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", cast=" + cast + ", releaseDate="
				+ releaseDate + ", price=" + price + "]";
	}
	
	
	

	
}

package com.ltts.Detailinfo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ltts.Detailinfo.model.Movie;
import com.ltts.Detailinfo.model.Team;

@RestController
public class DetailController {
	
	@Autowired
	RestTemplate rt;
	
	
	@RequestMapping("/detail")
	public List<Team> getExternalTeam(){
		/*
		 * //List<Team> li=new ArrayList<Team> List<Team>
		 * li=rt.getForObject("http://localhost:8080/teams", Team.class); return li;
		 * 
		 */
		
		/*
		 * ResponseEntity<List<Team>> responseEntity =
		 * rt.exchange("http://localhost:8080/teams", HttpMethod.GET, null, new
		 * ParameterizedTypeReference<List<Team>>() { }); List<Team> li =
		 * Arrays.asList(responseEntity.getBody()); return li;
		 */
		
		ResponseEntity<Team[]> response =
				  rt.getForEntity(
				  "http://localhost:8080/teams/",
				  Team[].class);
				Team[] teams = response.getBody();
				List<Team> lt=Arrays.asList(teams);
				
				//player
				//plist array
				
				//List<Player> plt=Arrays.asList(players);
				
				//List<Combined> comlist 
				//combine
				//return the combined list
				return lt;
	}
	
	
	@GetMapping(value="/movies")
	public List<Movie> getMovies(){
		
		ResponseEntity<Movie[]> response =
				  rt.getForEntity(
				  "http://localhost:8082/viewMovies",
				  Movie[].class);
				Movie[] teams = response.getBody();
				List<Movie> lt=Arrays.asList(teams);
		
		return lt;
		
	}

}

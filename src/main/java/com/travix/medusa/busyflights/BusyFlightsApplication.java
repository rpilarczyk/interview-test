package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.search.SearchAdapter;
import com.travix.medusa.busyflights.search.SearchRequest;
import com.travix.medusa.busyflights.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class BusyFlightsApplication {

	@Autowired
	SearchAdapter searchAdapter;

	public static void main(String[] args) {
		SpringApplication.run(BusyFlightsApplication.class, args);
	}

	@RequestMapping("/")
	public List<SearchResponse> search(SearchRequest searchRequest) {
		return searchAdapter.search(searchRequest);
	}


	// todo informations
	/*  Finally after some recommendations from Kernic I spent four, five hours.
		To finish this project should be done some of things.

		- set all filters in adapters (date filters, price filters)
		- add RequestMapping in BusyFlightsApplication class
		- repository should not be created in adapter
		- tests should be added
		- annotation RestController has as result JSON. so is nothing to do with JSON
		- small refactoring

		Please read comments in class

		I dont want to spend to much time for this project.

		I hope that this short example can show my approach to the problem.
 */

}

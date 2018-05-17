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
	/* The time I spent was around two hours with a break to talk to the overseer.
	   Unfortunately, the task I had to do during work, hence I was not completely
	   focused on the task. There is definitely order in the packages. Respositories,
	   Adapters, etc. The repositories does not return exemplary results.
       RestController annotation should return JSON. There are no tests.
	   It seems to me that you can see the idea that guided me.
	   I think that's what it was about.

		In my opinion, to do this task very well should be devoted to the task definitely much more time.

	   Regards */

}

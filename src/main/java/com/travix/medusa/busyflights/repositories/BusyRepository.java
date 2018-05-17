package com.travix.medusa.busyflights.repositories;

import com.travix.medusa.busyflights.adapters.dispatcher.Lines;
import com.travix.medusa.busyflights.request.BusyRequestRequest;
import com.travix.medusa.busyflights.response.BusyFlightsResponse;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * todo: Please read...
 * In my example as repository I specially was used building in time repository to show possibilities stream functionality
 * Normally we should use in simple example file repository or db repository or another similar or better ...
 */
public class BusyRepository implements Repository<BusyRequestRequest, BusyFlightsResponse> {

    @Override
    public Set<BusyFlightsResponse> search(Optional<BusyRequestRequest> request) {

        BusyRequestRequest busyRequestRequest = request.get();

        // todo: for Example 2 filter
        Predicate<BusyFlightsResponse> origin = (p) -> p.getOrigin().contains(busyRequestRequest.getOrigin());
        Predicate<BusyFlightsResponse> destination = (p) -> p.getDestination().contains(busyRequestRequest.getDestination());


        return Arrays.asList(BusyFlightsResponse.builder()
                        .price(34)
                        .origin("AMS")
                        .destination("LHR")
                        .departureDate("2018-05-17 12:34")
                        .returnDate("2018-06-17 12:34")
                        .numberOfPassengers(45)
                        .build(),

                BusyFlightsResponse.builder()
                        .price(5)
                        .origin("ABC")
                        .destination("DEF")
                        .departureDate("2018-05-18 12:34")
                        .returnDate("2018-06-18 12:34")
                        .numberOfPassengers(45)
                        .build())

                .stream()
                .filter(origin.and(destination))
                .collect(Collectors.toSet());
    }


}

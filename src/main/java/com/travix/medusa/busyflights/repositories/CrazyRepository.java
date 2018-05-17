package com.travix.medusa.busyflights.repositories;

import com.travix.medusa.busyflights.adapters.dispatcher.Lines;
import com.travix.medusa.busyflights.request.CrazyAirRequest;
import com.travix.medusa.busyflights.request.ToughJetRequest;
import com.travix.medusa.busyflights.response.CrazyAirResponse;
import com.travix.medusa.busyflights.response.ToughJetResponse;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 *  todo: Please read...
 *  In my example as repository I specially was used building in time repository to show possibilities stream functionality
 *  Normally we should use in simple example file repository or db repository or another similar or better ...
 */
public class CrazyRepository implements Repository<CrazyAirRequest, CrazyAirResponse> {

    @Override
    public Set<CrazyAirResponse> search(Optional<CrazyAirRequest> request) {

        CrazyAirRequest crazyAirRequest = request.get();

        // todo: for Example 2 filters
        Predicate<CrazyAirResponse> origin  = (f) -> f.getDepartureAirportCode().contains(crazyAirRequest.getOrigin());
        Predicate<CrazyAirResponse> destination  = (f) -> f.getDestinationAirportCode().contains(crazyAirRequest.getDestination());

        return Arrays.asList(CrazyAirResponse.builder()
                        .price(67)
                        .cabinclass("B")
                        .departureAirportCode("LHR")
                        .destinationAirportCode("AMS")
                        .departureDate("2018-05-17 12:34")
                        .arrivalDate("2018-06-17 12:34")
                        .build(),

                CrazyAirResponse.builder()
                        .price(67)
                        .cabinclass("B")
                        .departureAirportCode("LHR")
                        .destinationAirportCode("AMS")
                        .departureDate("2018-05-17 12:34")
                        .arrivalDate("2018-06-17 12:34")
                        .build())

                .stream()
                .filter(destination.and(origin))
                .collect(Collectors.toSet());
    }





}

package com.travix.medusa.busyflights.repositories;

import com.travix.medusa.busyflights.request.ToughJetRequest;
import com.travix.medusa.busyflights.response.ToughJetResponse;

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
public class ToughRepository implements Repository<ToughJetRequest, ToughJetResponse> {

    @Override
    public Set<ToughJetResponse> search(Optional<ToughJetRequest> request) {

        ToughJetRequest toughJetRequest = request.get();

        // todo: for Example 1 filter
        Predicate<ToughJetResponse> filter = (f) -> f.getDepartureAirportName().contains(toughJetRequest.getTo());

        return Arrays.asList(ToughJetResponse.builder()
                        .basePrice(56)
                        .tax(2)
                        .discount(1)
                        .departureAirportName("LHR")
                        .arrivalAirportName("AMS")
                        .outboundDateTime("2018-05-17 12:34")
                        .inboundDateTime("2018-05-17 19:34")
                        .build(),

                ToughJetResponse.builder()
                        .basePrice(56)
                        .tax(2)
                        .discount(1)
                        .departureAirportName("DEF")
                        .arrivalAirportName("GHC")
                        .outboundDateTime("2018-05-18 12:34")
                        .inboundDateTime("2018-05-18 19:34")
                        .build())

                .stream().filter(filter).collect(Collectors.toSet());
    }
}
